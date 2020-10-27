package com.biz.ems.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.biz.ems.model.EmsVO;
import com.biz.ems.service.EmsService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value="/ems")
public class EmsController {
	
	@Autowired
	@Qualifier("emsServiceV1")
	private EmsService emsService;
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public String list(Model model) {
		
		List<EmsVO> emsList = emsService.selectAll();
		
		model.addAttribute("EMS_LIST", emsList);
		return "/ems/list";
	
	}

	@RequestMapping(value="/notice",method=RequestMethod.GET)
	public String notice(Model model) {
		return "/ems/write";
	}
	
	@RequestMapping(value="/write",method=RequestMethod.GET)
	public String write(Model model) {
		return "/ems/write";
	}

	@RequestMapping(value="/write",method=RequestMethod.POST)
	public String write(EmsVO emsVO, 
			@RequestParam(name = "file",required = false) MultipartFile file) {
		
		emsService.insert(emsVO,file);
		return "redirect:/ems/list";
	
	}
	
	@RequestMapping(value="/detail/{id}",method=RequestMethod.GET)
	public String detail(@PathVariable("id") String id, Model model) {
		
		long long_id = Long.valueOf(id);
		EmsVO emsVO = emsService.findById(long_id);
		
		model.addAttribute("EmsVO", emsVO);
		return "/ems/detail";
	}
	
	@RequestMapping(value="/{id}/{url}",method=RequestMethod.GET)
	public String update(@PathVariable("id") String id,
			@PathVariable("url") String url,Model model) {
		
		long long_id = Long.valueOf(id);
		String ret_url = "redirect:/ems/list";
		
		if(url.equalsIgnoreCase("DELETE")) {
			emsService.delete(long_id);			
		} else if(url.equalsIgnoreCase("UPDATE")) {
			model.addAttribute("EmsVO", emsService.findById(long_id));
			ret_url = "/ems/write";
		}
		return ret_url;
	}
	
	
}
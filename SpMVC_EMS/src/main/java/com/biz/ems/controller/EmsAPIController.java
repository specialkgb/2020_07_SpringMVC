package com.biz.ems.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.biz.ems.model.EmsVO;
import com.biz.ems.service.EmsService;
import com.biz.ems.service.FileService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@CrossOrigin({ "http://127.0.0.1:5500", "https://naver.com", "*" })
@RestController
@RequestMapping(value =  "/api")
public class EmsAPIController {
	
	@Autowired
	@Qualifier("emsServiceV1")
	private EmsService emsService;
	
	@Autowired
	@Qualifier("fileServiceV1")
	private FileService fileService;
	
	@RequestMapping(value = "/ems", method=RequestMethod.GET)
	public List<EmsVO> ems_list() {
		
		List<EmsVO> emsList = emsService.selectAll();
		
		return emsList;
	}
	
	@RequestMapping(value = "/ems/{id}", method = RequestMethod.GET)
	public EmsVO ems_item(@PathVariable("id") String id) {
		
		long long_id = Long.valueOf(id);
		EmsVO emsVO = emsService.findById(long_id);
		
		return emsVO;
	}
	
	@RequestMapping(value = "/ems", method=RequestMethod.POST)
	public String ems_insert(@ModelAttribute EmsVO emsVO, @RequestParam("file") MultipartFile file) {
		
		return "ems_insert";
	}
	
	@RequestMapping(value = "/ems", method=RequestMethod.PUT)
	public String ems_update(@ModelAttribute EmsVO emsVO, @RequestParam("file") MultipartFile file) {
		
		return "ems_update";
	}
	
	@RequestMapping(value = "/ems", method = RequestMethod.DELETE)
	public String ems_delete(@RequestBody Map<String, String> data) {
		return "ems_delete";
	}
	
	@RequestMapping(value = "/file", method = RequestMethod.POST)
	public String file_up(@RequestParam("file") MultipartFile file) {
		
		String ret_file = fileService.fileUp(file);
		return ret_file;
	}	
}

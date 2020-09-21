package com.biz.read.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.biz.read.model.BookVO;
import com.biz.read.service.NaverService;

@Controller
@RequestMapping(value="/naver")
public class NaverController {
	
	@Autowired
	private NaverService naverService;
	
	
	@RequestMapping(value = "/search", method=RequestMethod.GET)
	public String search(String search_text) {
		return "naver";
		
	}
	
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public String search(String category, String search_text,Model model) {
		
		String queryURL = naverService.queryURL(category, search_text);
		String jsonString = naverService.getNaverBook(queryURL);
		List<BookVO> bookList = naverService.getJsonObject(jsonString);
		
		model.addAttribute("NAVERS", bookList);
		return "naver";
		
	}

}

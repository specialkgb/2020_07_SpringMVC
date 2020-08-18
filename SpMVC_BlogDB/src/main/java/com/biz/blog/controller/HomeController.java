package com.biz.blog.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.biz.blog.service.BlogFileService;


@Controller
public class HomeController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		return "home";
	}

	@RequestMapping(value="/input", method=RequestMethod.GET)
	public String input() {
		
		// /WEB-INF/views/write.jsp 파일을 response 하여라
		return "write";
	}

	@RequestMapping(value = "/writer", method=RequestMethod.POST)
	public String writer(String title, String content, Model model) {
		System.out.println("제목 : " + title);
		System.out.println("내용 : " + content);
		
		model.addAttribute("TITLE", title);
		model.addAttribute("CONTENT", content);
		// Controller의 함수에서 return null을 수행하면
		// RequestMapping에서 지정한 value 값을 문자열로 자동인식한다.
		// return null;
		return "view";
	}
	
}

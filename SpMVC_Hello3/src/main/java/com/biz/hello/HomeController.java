package com.biz.hello;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
		
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
			
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate );
		return "home";
	}
	
	@RequestMapping(value="/home")
	public String home() {
		return "home";
	}
	@RequestMapping(value="/home2")
	public String home2(Model model) {
		return "home2";
	}
	@RequestMapping(value="/home3")
	public String home3(Model model) {
		
		model.addAttribute("your", "너, 기건우");
		return "home3";
	}
	@RequestMapping(value="/home4")
	public String home4(Model model) {
		model.addAttribute("your1", "기건우");
		model.addAttribute("your2", "김민석");
		return "home4";
	}
	@RequestMapping(value="/home5")	
	public String home5(Model model) {
		model.addAttribute("friend", "장현정");
		return "home5";
	} // 다 바꾸면 저장하고 좀 기다리세요 형님. 서버 재시작함.
}

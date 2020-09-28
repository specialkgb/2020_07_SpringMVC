package com.biz.read.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.biz.read.model.UserDetailsVO;
import com.biz.read.service.MemberService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
@RequestMapping(value="/member")
public class MemberController {
	
	private final MemberService memberService;
	
	@RequestMapping(value = "/join", method=RequestMethod.GET)
	public String join(@ModelAttribute("memberVO") UserDetailsVO userVO, Model model) {
		
		model.addAttribute("memberVO", userVO);
		model.addAttribute("BODY", "MEMBER-JOIN");
		return "home";
	}
	
	@RequestMapping(value = "/join", method=RequestMethod.POST)
	public String join(@ModelAttribute("memberVO") UserDetailsVO userVO) {
		
		memberService.insert(userVO);
		
		return "redirect:/";
		
	}
	
	@RequestMapping(value = "/logout", method=RequestMethod.GET)
	public String logout() {
		return "member/logout";
	}
}
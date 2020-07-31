package com.biz.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.biz.order.model.OrderVO;
import com.biz.order.service.OrderService;

@Controller
public class OrderController {
	
	
	@Autowired
	private OrderService oService;
	
	
	@RequestMapping	(value="/order")
	public String getOrder(Model model) {
		
		OrderVO orderVO = oService.findBySeq(2);
		
		model.addAttribute("ORDER", orderVO);
		
		return "order/view";
	}

}

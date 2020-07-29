package com.biz.hello;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/*
 * Comment : 코드가 실행되는데 아무런 영향을 미치지 않는 설명문
 * @ : Annotation, (Comment 하고는 조금 다른 의미의 주석)이라고 한다.
 * 	-- 의미가 부여된 특별한 주석
 * 	-- Java 1.5부터 사용할 수 있는 주석
 * 	-- 실제로, interface, Class, method 등으로 구성된 모듈을
 * 	-- 한두개의 키워드로 현재의 소스코드에 부착시키는(include) 키워드
 * 	-- 메타데이터
 * 	-- 사용가능한 키워드가 정해져있고, 이 키워드를 사용하기 위해서는 어딘가에
 * 	-- 이 키워드로 실행가능(호출가능)한 클래스, 메서드가 존재해야 한다.
 */
// @controller를 메서드 위에 적는 순간 서버에 하나의 요소로 등록된다.
@Controller
public class HomeController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home"; // 일반 Controller는 views의 home.jsp를 리턴해서 보여주고 RestController는 return 문의 값을 그대로 return한다. 
	}
	
	@RequestMapping(value = "/korea", method = RequestMethod.GET)
	public String home2(Model model) {
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", "Republic of Korea");
		
		return "home";
	}
	
	@RequestMapping(value = "/name", method = RequestMethod.GET)
	public String name(Model model) {
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", "Republic of Korea");
		
		return "name";
	}
	
}

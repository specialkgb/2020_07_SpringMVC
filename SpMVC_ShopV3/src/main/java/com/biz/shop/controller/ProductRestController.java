package com.biz.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.biz.shop.service.ProductService;

/*
 * RestController
 * 표준 Controller는 return 문자열을 가지고 view 파일을 읽고
 * rendering을 수행한 후 web client에 HTML 코드로 response를 수행한다.
 * 그에 반해 RestControlelr는 view가 없이 데이터를 직접 web client에
 * 전송할 때 사용하는 Controller
 * 
 * 표준 Controller에서는 특정 method를 지정하여
 * view가 아닌 데이터를 직접 web client로 전송할 때
 * method에 @ResponseBody를 설정해준다.
 * 
 * RestController는 모든 method에 @ResponseBody가 설정된 것과
 * 똑같은 효과를 낸다
 * 
 * RequestMapping을 api로 시작한 이유
 * API(Application Programmerble Interface)는
 * 서로다른 서버와 서버간, 서로다른 서비스와 서비스 간에
 * 데이터를 주고 받는 방식을 일컫는 용어
 */
@RequestMapping(value = "/api/product")
@RestController
public class ProductRestController {
	
	@Autowired
	@Qualifier("proServiceV1")
	ProductService proService;
	
	@RequestMapping(value = "/get_pcode", method=RequestMethod.GET)
	public String getPCode() {
		
		/*
		 * ProductService의 getPCode() 호출하여
		 * 새로운 상품코드를 생성하여 받고 싶다.
		 * 
		 * TDD(Test Driven Developer)
		 * 요구사항을 먼저 만들고
		 * 실제 구현되는 코드를 나중에 만드는 방식
		 */
		
		String strPCode = proService.getPCode();
		return strPCode;
	}
}

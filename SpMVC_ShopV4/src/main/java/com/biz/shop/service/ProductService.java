package com.biz.shop.service;

import java.util.List;

import com.biz.shop.model.ProductVO;
/*
 * ProductService interface는 GenericService interface를 확장상속했기 때문에
 * CRUD 기본 method를 별도로 선언하지 않아도 된다.
 * 필요한 추가 method가 있으면 별도로 선언을 해주고
 * 이 interface를 implements한 클래스는 interface의 영향을 받아
 * method를 구현하게 된다.
 */
public interface ProductService 
			extends GenericService <ProductVO, String> {
	
	// Generic에는 없지만 Product를 구현하는데 필요한 메서드가 있으면
	// 그 메서드를 별도로 선언해준다.
	public List<ProductVO> findByTitle(String title);
	
	// Controller에서 getPCode() method를 "사용하는" 코드를 먼저 작성한 후
	// 실제 구현되는 코드를 만들기 위해서 interface에 method를
	// 자동 생성한다.
	public String getPCode();
}
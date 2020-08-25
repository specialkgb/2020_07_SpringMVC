package com.biz.shop.service;

import java.util.List;

import com.biz.shop.model.ProductVO;
/**
 * GenericService interface
 * @param <VO>
 * @param <PK>
 * 
 * DB와 관련된 Project를 수행할 때
 * Service 클래스를 만들기에 앞서 반드시
 * Service 인터페이스를 만들도록 권하고 있다.
 * 
 * 다수의 table이 존재하는 프로젝트일 경우 비슷한(같은) 이름의 method를
 * 중복하여 선언해야 하는 경우가 많다.
 * 
 * 이런 경우에 Service interface를 만들기 위한 상위 인터페이스를 선언하고
 * 인터페이스에 Generic을 선언해 둔다.
 * 
 * 이 인터페이스를 상속받아서 실제 사용할 interface를 선언 해주면
 * 기본 method는 별도로 작성(코딩)하지 않아도 클래스를 생성할 때
 * 자동으로 method를 선언할 수 있는 기능을 구현할 수 있다.
 */
public interface GenericService<VO,PK> {
	
	public List<VO> selectAll();
	public VO findById(PK id); // ID = PK라는 개념으로 생성하는 method
	
	public int insert(VO vo);
	public int update(VO vo);
	public int delete(PK id);

}

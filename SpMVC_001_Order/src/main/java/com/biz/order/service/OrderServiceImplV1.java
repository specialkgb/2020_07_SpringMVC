package com.biz.order.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.order.dao.OrderDao;
import com.biz.order.model.OrderVO;

@Service
public class OrderServiceImplV1 implements OrderService {
	
	@Autowired
	SqlSession sqlSession;
	
	private OrderDao orderDao;
	
	/*
	 * OrderServiceImpl 클래스를 객체로 생성하는 과정에서 
	 * getMapper() method를 자동으로 호출하고 orderDao를 초기화 하라
	 * 
	 * ServiceImpl 클래스를 객체로 생성할 때 호출되는 생성자는 최초에 한번 Container에 등록될때 호출된다.
	 * 
	 * 이후에 다른 객체, 변수등을 초기화 하려면
	 * 별도의 method를 만든 후 @Autowired를 설정해 주어야 한다
	 */
	@Autowired
	public void getMapper() {
		this.orderDao = sqlSession.getMapper(OrderDao.class);
	}

	@Override
	public List<OrderVO> selectAll() {
		return null;
	}
	
	/*
	 * seq 값을 파라메터로 받아서
	 * OrderDao.findBySeq(seq) 호출하고 db로부터 받아온 주문서 1개 레코드를 orderVO에 받고
	 * 호출한 곳으로 그대로 return
	 */

	@Override
	public OrderVO findBySeq(long seq) {
		
		// 52
		OrderVO orderVO = orderDao.findBySeq(seq);
		return orderVO;
	}

	@Override
	public int insert(OrderVO orderVo) {
		
		return 0;
	}

	@Override
	public int update(OrderVO orderVo) {
		
		return 0;
	}

	@Override
	public int delete(long seq) {
		
		return 0;
	}

}

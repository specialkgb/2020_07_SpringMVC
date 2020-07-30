package com.biz.order.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.biz.order.dao.OrderDao;
import com.biz.order.model.OrderVO;

@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	SqlSession sqlSession;
	
	private OrderDao orderDao;

	@Override
	public List<OrderVO> selectAll() {
		
		return null;
	}
	
	@Autowired
	public void GetMapper() {
		this.orderDao = sqlSession.getMapper(OrderDao.class);
		
	}

	@Override
	public OrderVO findBySeq(long seq) {
		
		// 2
		OrderVO orderVO = orderDao.findBySeq(seq);
		
		return orderVO;
	}

	@Override
	public int insert(OrderVO orderVO) {
		
		return 0;
	}

	@Override
	public int update(OrderVO orderVO) {
		
		return 0;
	}

	@Override
	public int delete(long seq) {
		
		return 0;
	}
	
	
	

}

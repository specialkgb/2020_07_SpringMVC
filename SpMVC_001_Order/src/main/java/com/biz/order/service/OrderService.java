package com.biz.order.service;

import java.util.List;

import com.biz.order.model.OrderVO;

public interface OrderService {
	
	public List<OrderVO> selectAll();
	public OrderVO findBySeq(long seq);
	
	public int insert(OrderVO orderVo);
	public int update(OrderVO orderVo);
	public int delete(long seq);
}

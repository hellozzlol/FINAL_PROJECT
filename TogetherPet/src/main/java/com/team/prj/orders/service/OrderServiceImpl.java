package com.team.prj.orders.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.prj.cart.service.CartVO;
import com.team.prj.orders.mapper.OrderMapper;
import com.team.prj.users.service.UsersVO;

@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	OrderMapper map;

	@Override
	public UsersVO userInfo(CartVO vo) {
		// TODO Auto-generated method stub
		return map.userInfo(vo);
	}

	@Override
	public int insertOrder(OrderVO vo) {
		// TODO Auto-generated method stub
		return map.insertOrder(vo);
	}
}

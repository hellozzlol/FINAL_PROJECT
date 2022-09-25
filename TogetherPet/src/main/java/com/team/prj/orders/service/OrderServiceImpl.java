package com.team.prj.orders.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.prj.cart.service.CartVO;
import com.team.prj.goods.service.GoodsVO;
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

	@Override
	public List<OrderVO> selectOrder(OrderVO vo) {
		// TODO Auto-generated method stub
		return map.selectOrder(vo);
	}

	@Override
	public int updateMoney(UsersVO vo) {
		return map.updateMoney(vo);
	}

	@Override
	public int updateGoodsQty(OrderVO vo) {
		// TODO Auto-generated method stub
		return map.updateGoodsQty(vo);
	}
}

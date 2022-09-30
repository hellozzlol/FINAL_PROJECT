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
		return map.userInfo(vo);
	}

	@Override
	public int insertOrder(OrderVO vo) {
		return map.insertOrder(vo);
	}

	@Override
	public List<OrderVO> selectOrder(OrderVO vo) {
		return map.selectOrder(vo);
	}

	@Override
	public int updateMoney(UsersVO vo) {
		return map.updateMoney(vo);
	}

	@Override
	public int updateGoodsQty(OrderVO vo) {
		return map.updateGoodsQty(vo);
	}

	@Override
	public int updateMinusYN() {
		return map.updateMinusYN();
	}

	// 주문 내역 삭제 0930 선희추가
	@Override
	public int deleteOrder(OrderVO vo) {
		return map.deleteOrder(vo);
	}
}

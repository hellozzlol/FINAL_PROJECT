package com.team.prj.cart.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.prj.cart.mapper.CartMapper;

@Service
public class CartServiceImpl implements CartService{
	@Autowired
	private CartMapper map;
	@Override
	public List<CartVO> cartList(CartVO vo) {
		// TODO Auto-generated method stub
		return map.cartList(vo);
	}

	@Override
	public int insertCart(CartVO vo) {
		// TODO Auto-generated method stub
		return map.insertCart(vo);
	}

	@Override
	public int updateCart(CartVO vo) {
		// TODO Auto-generated method stub
		return map.updateCart(vo);
	}

	@Override
	public int deleteCart(CartVO vo) {
		// TODO Auto-generated method stub
		return map.deleteCart(vo);
	}

	@Override
	public CartVO isGoods(CartVO vo) {
		// TODO Auto-generated method stub
		return map.isGoods(vo);
	}
	
}

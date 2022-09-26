package com.team.prj.cart.service;

import java.util.List;
import java.util.Map;

public interface CartService {
	List<CartVO> cartList(CartVO vo);

	int insertCart(CartVO vo);

	int updateCart(CartVO vo);

	int deleteCart(CartVO vo);
	
	CartVO isGoods(CartVO vo);
	
	// 0926 희수가 추가
	int cartCount(CartVO vo);
}

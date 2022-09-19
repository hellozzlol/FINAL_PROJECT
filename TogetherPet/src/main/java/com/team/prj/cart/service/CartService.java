package com.team.prj.cart.service;

import java.util.List;
import java.util.Map;

public interface CartService {
List<Map<String, Object>> cartList(CartVO vo);
	
	int insertCart(CartVO vo);
	int updateCart(CartVO vo);
	int deleteCart(CartVO vo);
}

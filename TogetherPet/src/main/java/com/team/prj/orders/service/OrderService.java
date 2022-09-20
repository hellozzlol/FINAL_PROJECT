package com.team.prj.orders.service;

import com.team.prj.cart.service.CartVO;
import com.team.prj.users.service.UsersVO;

public interface OrderService {
	UsersVO userInfo(CartVO vo);

	int insertOrder(OrderVO vo);
}

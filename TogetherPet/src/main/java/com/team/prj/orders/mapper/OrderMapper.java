package com.team.prj.orders.mapper;

import com.team.prj.cart.service.CartVO;
import com.team.prj.orders.service.OrderVO;
import com.team.prj.users.service.UsersVO;

public interface OrderMapper {
	UsersVO userInfo(CartVO vo);

	int insertOrder(OrderVO vo);

}

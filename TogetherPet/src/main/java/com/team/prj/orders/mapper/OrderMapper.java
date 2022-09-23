package com.team.prj.orders.mapper;

import java.util.List;

import com.team.prj.cart.service.CartVO;
import com.team.prj.orders.service.OrderVO;
import com.team.prj.users.service.UsersVO;

public interface OrderMapper {
	UsersVO userInfo(CartVO vo);
	List<OrderVO> selectOrder(OrderVO vo);
	int insertOrder(OrderVO vo);
	
	int updateMoney(UsersVO vo);

}

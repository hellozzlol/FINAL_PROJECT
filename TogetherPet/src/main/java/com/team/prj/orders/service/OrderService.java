package com.team.prj.orders.service;

import java.util.List;

import com.team.prj.cart.service.CartVO;
import com.team.prj.goods.service.GoodsVO;
import com.team.prj.users.service.UsersVO;

public interface OrderService {
	UsersVO userInfo(CartVO vo);
	List<OrderVO> selectOrder(OrderVO vo);
	int insertOrder(OrderVO vo);
	
	int updateMoney(UsersVO vo);

	// 주문 및 결제시 재고 업데이트
	int updateGoodsQty(OrderVO vo);
	
	// 0927 희수 추가
	int updateMinusYN();

	// 주문 내역 삭제 0930 선희 추가
	int deleteOrder(OrderVO vo);
}

package com.team.prj.state.service;

import java.util.List;

import com.team.prj.orders.service.OrderVO;

public interface StateService {
	// 반품, 교환상태 전체 조회
	List<OrderVO> stateSelectList(OrderVO vo);

	// 단건 조회
	StateVO stateSelect(OrderVO vo);

	// 반품 신청 등록, 업데이트
	int cancelInsert(StateVO svo, OrderVO ovo);
	
	// 교환 신청 등록, 업데이트
	int changeInsert(StateVO svo, OrderVO ovo);
	
	// 교환,반품 신청 폼에 주문내역 불러오기
	OrderVO orderCanList(OrderVO vo);
	
	// 구매확정 상태 변경
	int goodsConfirm(OrderVO vo);
}

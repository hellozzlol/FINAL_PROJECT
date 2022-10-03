package com.team.prj.state.mapper;

import java.util.List;

import com.team.prj.orders.service.OrderVO;
import com.team.prj.state.service.StateVO;

public interface StateMapper {
	// 반품, 교환상태 전체 조회
	List<OrderVO> stateSelectList();

	// 단건 조회
	StateVO stateSelect(OrderVO vo);

	// 배송 상태 업데이트(default 1번에서 5번 반품으로)
	int cancelUpdate(OrderVO vo);

	// 배송 상태 업데이트(default 1번에서 6번 반품으로)
	int changeUpdate(OrderVO vo);

	// 반품 신청 등록
	int cancelInsert(StateVO vo);

	// 교환 신청 등록
	int changeInsert(StateVO vo);

	// 교환,반품 신청 폼에 주문내역 불러오기
	OrderVO orderCanList(OrderVO vo);

	// 구매확정 상태 변경
	int goodsConfirm(OrderVO vo);
}

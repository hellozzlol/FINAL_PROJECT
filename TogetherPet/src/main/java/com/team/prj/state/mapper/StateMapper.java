package com.team.prj.state.mapper;

import java.util.List;

import com.team.prj.orders.service.OrderVO;
import com.team.prj.state.service.StateVO;

public interface StateMapper {
	// 반품, 교환상태 전체 조회
	List<StateVO> stateSelectList();

	// 단건 조회
	StateVO stateSelect(OrderVO vo);

	// 상태 업데이트
	// 1 : 반품신청(개인), 2 : 반품신청접수(판매자), 3 : 교환신청(개인), 4 : 교환신청접수(판매자)
	int stateUpdate(StateVO vo);

	// 반품 신청 등록
	int cancelInsert(StateVO vo);

	// 반품 신청 폼에 주문내역 불러오기
	OrderVO orderCanList(OrderVO vo);
}

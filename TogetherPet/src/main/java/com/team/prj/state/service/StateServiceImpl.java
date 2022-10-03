package com.team.prj.state.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.prj.orders.service.OrderVO;
import com.team.prj.state.mapper.StateMapper;

@Service
public class StateServiceImpl implements StateService {
	@Autowired
	private StateMapper map;

	// 반품, 교환상태 전체 조회
	@Override
	public List<OrderVO> stateSelectList() {
		return map.stateSelectList();
	}

	// 단건 조회
	@Override
	public StateVO stateSelect(OrderVO vo) {
		return map.stateSelect(vo);
	}

	// 배송 상태 업데이트(default 1번에서 5번 반품으로)
	@Override
	public int cancelUpdate(OrderVO vo) {
		return map.cancelUpdate(vo);
	}
	
	// 배송 상태 업데이트(default 1번에서 6번 반품으로)
	@Override
	public int changeUpdate(OrderVO vo) {
		return map.changeUpdate(vo);
	}

	// 반품 신청 등록
	@Override
	public int cancelInsert(StateVO vo) {
		return map.cancelInsert(vo);
	}

	// 교환,반품 신청 폼에 주문내역 불러오기
	@Override
	public OrderVO orderCanList(OrderVO vo) {
		return map.orderCanList(vo);
	}

	// 교환 신청 등록
	@Override
	public int changeInsert(StateVO vo) {
		return map.changeInsert(vo);
	}

	// 구매확정 상태변경
	@Override
	public int goodsConfirm(OrderVO vo) {
		return map.goodsConfirm(vo);
	}

}

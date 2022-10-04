package com.team.prj.state.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.team.prj.orders.service.OrderVO;
import com.team.prj.state.mapper.StateMapper;

@Service
public class StateServiceImpl implements StateService {
	@Autowired
	private StateMapper map;

	// 반품, 교환상태 전체 조회
	@Override
	public List<OrderVO> stateSelectList(OrderVO vo) {
		return map.stateSelectList(vo);
	}

	// 단건 조회
	@Override
	public StateVO stateSelect(OrderVO vo) {
		return map.stateSelect(vo);
	}


	// 반품 신청 등록
	@Override
	@Transactional
	public int cancelInsert(StateVO svo, OrderVO ovo) {
		map.cancelInsert(svo);
		return map.cancelUpdate(ovo);
	}

	// 교환 신청 등록
	@Override
	@Transactional
	public int changeInsert(StateVO svo, OrderVO ovo) {
		map.changeInsert(svo);
		return map.changeUpdate(ovo);
	}

	// 교환,반품 신청 폼에 주문내역 불러오기
	@Override
	public OrderVO orderCanList(OrderVO vo) {
		return map.orderCanList(vo);
	}

	// 구매확정 상태변경
	@Override
	public int goodsConfirm(OrderVO vo) {
		return map.goodsConfirm(vo);
	}

}

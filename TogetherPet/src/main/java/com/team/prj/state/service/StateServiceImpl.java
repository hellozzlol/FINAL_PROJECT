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
	public List<StateVO> stateSelectList() {
		return map.stateSelectList();
	}

	// 단건 조회
	@Override
	public StateVO stateSelect(OrderVO vo) {
		return map.stateSelect(vo);
	}

	// 상태 업데이트
	// 1 : 반품신청(개인), 2 : 반품신청접수(판매자), 3 : 교환신청(개인), 4 : 교환신청접수(판매자)
	@Override
	public int stateUpdate(StateVO vo) {
		return map.stateUpdate(vo);
	}

	// 반품 신청 등록
	@Override
	public int cancelInsert(StateVO vo) {
		return map.cancelInsert(vo);
	}

	// 반품 신청 폼에 주문내역 불러오기
	@Override
	public OrderVO orderCanList(OrderVO vo) {
		return map.orderCanList(vo);
	}

}

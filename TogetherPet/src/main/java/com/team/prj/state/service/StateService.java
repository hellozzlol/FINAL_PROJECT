package com.team.prj.state.service;

import java.util.List;

import com.team.prj.orders.service.OrderVO;

public interface StateService {
	List<StateVO> stateSelectList();
	
	// 상태 목록
	StateVO stateSelect(OrderVO vo);
	
	// 상태 업데이트
	int stateUpdate(StateVO vo);
}

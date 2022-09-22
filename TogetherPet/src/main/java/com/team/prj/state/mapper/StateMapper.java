package com.team.prj.state.mapper;

import java.util.List;

import com.team.prj.orders.service.OrderVO;
import com.team.prj.state.service.StateVO;

public interface StateMapper {
	List<StateVO> stateSelectList();

	StateVO stateSelect(OrderVO vo);

	int stateUpdate(StateVO vo);
}

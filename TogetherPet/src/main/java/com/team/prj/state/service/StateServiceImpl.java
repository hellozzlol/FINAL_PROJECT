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
	
	@Override
	public List<StateVO> stateSelectList() {
		return map.stateSelectList();
	}

	@Override
	public StateVO stateSelect(OrderVO vo) {
		return map.stateSelect(vo);
	}

	@Override
	public int stateUpdate(StateVO vo) {
		return map.stateUpdate(vo);
	}

}

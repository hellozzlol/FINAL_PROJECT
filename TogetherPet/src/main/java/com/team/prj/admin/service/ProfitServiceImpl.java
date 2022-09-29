package com.team.prj.admin.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.prj.admin.mapper.ProfitMapper;

@Service
public class ProfitServiceImpl implements ProfitService {
	@Autowired
	private ProfitMapper map;
	@Override
	public List<ProfitVO> profitList(String start, String end) {
		// TODO Auto-generated method stub
		return map.profitList(start, end);
	}

	@Override
	public ProfitVO profitSelect(ProfitVO vo) {
		// TODO Auto-generated method stub
		return map.profitSelect(vo);
	}

	@Override
	public List<Map<String, Object>> dailyList() {
		// TODO Auto-generated method stub
		return map.dailyList();
	}

	@Override
	public List<Map<String, Object>> weeklyList() {
		// TODO Auto-generated method stub
		return map.weeklyList();
	}

	@Override
	public List<Map<String, Object>> monthlyList() {
		// TODO Auto-generated method stub
		return map.monthlyList();
	}

}

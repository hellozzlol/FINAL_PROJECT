package com.team.prj.admin.service;

import java.util.List;
import java.util.Map;

// 0928 희수 추가
public interface ProfitService {

	List<ProfitVO> profitList(String start, String end);

	ProfitVO profitSelect(ProfitVO vo);
	
	//Map monthlyList(String key);
	
	List<Map<String, Object>> dailyList();
	List<Map<String, Object>> weeklyList();
	List<Map<String, Object>> monthlyList();
}

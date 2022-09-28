package com.team.prj.admin.service;

import java.util.List;
import java.util.Map;

public interface ProfitService {

	// 0928 희수 추가
	List<ProfitVO> profitList(String start, String end);

	ProfitVO profitSelect(ProfitVO vo);
	
	Map monthlyList(String key);
	
}

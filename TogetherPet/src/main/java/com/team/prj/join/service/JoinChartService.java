package com.team.prj.join.service;

import java.util.List;
import java.util.Map;

public interface JoinChartService {

	
	//List<JChartVO> JoinList(String start, String end);
	
	List<Map<String, Object>> dailyList(String start);
	List<Map<String, Object>> weeklyList(String start);
	List<Map<String, Object>> monthlyList(String start);
}

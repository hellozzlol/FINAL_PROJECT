package com.team.prj.admin.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.team.prj.admin.service.ProfitService;

@RestController
public class AjaxProfitController {
	@Autowired
	private ProfitService ps;
	
	@RequestMapping("/manager/ajaxDailyList")
	public List<Map<String, Object>> dailyList(@RequestParam String start){
		if(start == "") {
			start = null;
		}
		return ps.dailyList(start);
	}
	
	@RequestMapping("/manager/ajaxWeeklyList")
	public List<Map<String, Object>> weeklyList(@RequestParam String start){
		if(start == "") {
			start = null;
		}
		return ps.weeklyList(start);
	}
	
	@RequestMapping("/manager/ajaxMonthlyList")
	public List<Map<String, Object>> monthlyList(@RequestParam String start){
		if(start == "") {
			start = null;
		}
		System.out.println("start month" + start);
		
		List<Map<String, Object>> ml =  ps.monthlyList(start);
		
		System.out.println("==========================");
		System.out.println(ml);
		
		return ml;
	}

}

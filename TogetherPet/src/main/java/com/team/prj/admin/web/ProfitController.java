package com.team.prj.admin.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.team.prj.admin.service.ProfitService;

@Controller
public class ProfitController {
	@Autowired
	private ProfitService ps;

	// 매출 조회
	@GetMapping("/manager/profit")
	public String salesCheck(Model model) {
		String start = null;
		String end = null;
		String key = null;
		model.addAttribute("profitList", ps.profitList(start, end));
		model.addAttribute("monthlyList", ps.monthlyList(key));
		return "admin/profit";
	}
}

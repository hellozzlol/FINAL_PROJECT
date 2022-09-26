package com.team.prj.accomo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.team.prj.accomo.service.accomoService;
import com.team.prj.accomo.service.accomoVO;

@Controller
public class accomoController {
	@Autowired
	private accomoService dao;

	
	//숙소리스트
	@RequestMapping("/accomoList")
	public String accomoList(Model model) {
		model.addAttribute("accomo", dao.accomoSelectList());
		return "accomo/accomoList";

	}
	//숙소상세보기
	@RequestMapping("/accomo")
	public String accomoSelect(accomoVO vo, Model model) {
		model.addAttribute("accomo",dao.accomoSelect(vo));
		dao.accomoHitUpdate(vo);//조회수증가
		return "accomo/accomoSelect";
	}
	
	//숙소 검색 아작스 처리
	
	@RequestMapping("accomoSearch")
	
	public String accomoSearch(accomoVO vo ,String key, String val,Model model) {
		return "accomo/accomoSearch";
	}
	
	
}

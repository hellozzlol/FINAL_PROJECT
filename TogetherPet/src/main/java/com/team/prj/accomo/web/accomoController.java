package com.team.prj.accomo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.team.prj.accomo.service.accomoService;

@Controller
public class accomoController {
	@Autowired
	private accomoService dao;

	@RequestMapping("/accomoList")
	public String accomoList(Model model) {
		model.addAttribute("accomo", dao.accomoSelectList());
		return "accomo/accomoList";

	}
	
	
	
	
}

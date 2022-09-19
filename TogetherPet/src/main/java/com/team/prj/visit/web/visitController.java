package com.team.prj.visit.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.team.prj.visit.service.visitService;

@Controller
public class visitController {
	@Autowired
	private visitService vs;
	
	@GetMapping("/visitCount")
	public String visitCount(Model model) {
		//
		return "admin/visitCount";
	}
	
}

package com.team.prj.funeral.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.team.prj.funeral.mapper.FuneralMapper;

@Controller
public class FuneralController {
	
	@Autowired
	FuneralMapper dao;
	
	@RequestMapping("/funeralList")
	
	public String funeralList(Model model) {
		model.addAttribute("funeral", dao.findAll());
		return "funeral/funeralList";
	}
	
	
	
	
	
	
}

package com.team.prj.classes.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.team.prj.classes.mapper.ClassMapper;

@Controller
public class ClassController {
	
	@Autowired ClassMapper dao;
	
	@RequestMapping("/classSelectList")
	public String classSelectList(Model model) {
		model.addAttribute("class", dao.classSelectList());
		return "class/classSelectList";
	}
	

}

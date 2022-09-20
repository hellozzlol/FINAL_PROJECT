package com.team.prj.classes.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.team.prj.classes.mapper.ClassMapper;
import com.team.prj.classes.service.ClassVO;

@Controller
public class ClassController {
	
	@Autowired ClassMapper dao;
	
	@RequestMapping("classList")
	public String classSelectList(Model model) {
		model.addAttribute("class", dao.classSelectList());
		return "class/classList";
	}
	
	@RequestMapping("classSelect")
	public String classSelect(Model model) {
		ClassVO vo = new ClassVO();
		model.addAttribute("class", dao.classSelect(vo));
		return "class/classSelect";
	}
	
	@RequestMapping("test")
	public String test(Model model) {
		return "class/test";
	}
	
	@GetMapping("classInsert")
	public String classInsert(Model model) {
		//ClassVO vo = new ClassVO();
		//model.addAttribute("class", dao.classInsert(vo));
		return "class/classInsert";
	}
	

}

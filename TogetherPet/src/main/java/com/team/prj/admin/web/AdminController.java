package com.team.prj.admin.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.team.prj.attend.service.attendService;

@Controller
public class AdminController {
	@Autowired
	private attendService dao;
	
	@RequestMapping("/admin")
	public String admin() {
		return "admin/admin";
	}
	
	@GetMapping("/mypage")
	public String mypage(Model model) {
		//model.addAttribute("attendList", dao.attendSelectList());
		return "admin/mypage";
	}
}

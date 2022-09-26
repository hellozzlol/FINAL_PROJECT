package com.team.prj.mem.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.team.prj.mem.service.MemService;

@Controller
public class MemController {

	@Autowired
	MemService dao;
	
//	@RequestMapping("/memManage")
//	public String memManage(Model model) {
//		model.addAttribute("usersList", dao.usersList());
//		return "member/memManage";
//	}
	
//	@RequestMapping("/stateUpdate")
//	
//	return "redirect:
}

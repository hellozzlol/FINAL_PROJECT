package com.team.prj.test.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.team.prj.test.mapper.TestMapper;

@Controller
public class TestController {
	
	@Autowired TestMapper test;
	
	@RequestMapping("/main")
	public String main(Model model) {
		return "main/main";
	}
	
	@RequestMapping("/testList")
	public String testList(Model model) {
		model.addAttribute("test", test.findAll());
		return "test/testList";
	}
	
	@RequestMapping("/shopList")
	public String shopList(Model model) {
		return "shop/shopList";
	}
}

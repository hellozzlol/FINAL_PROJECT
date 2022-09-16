package com.team.prj.users.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.team.prj.users.service.UsersService;
import com.team.prj.users.service.UsersVO;

@Controller
public class UsersController {
	@Autowired
	private UsersService us;
	
	// 개인 회원 리스트
	@GetMapping("/usersSelect")
	public String usersSelectList(Model model, UsersVO vo) {
		vo.setUserNo(1);
		vo = us.usersSelect(vo);
		model.addAttribute("users", vo);
		System.out.println(vo.getName());
		return "users/usersSelect";
	}
	
	// 회원 정보 수정 폼 호출
	@GetMapping("/usersUpdateForm")
	public String usersUpdateForm(UsersVO vo, Model model) {
		System.out.println("userNo" + vo.getUserNo());
		vo = us.usersSelect(vo);
		model.addAttribute("users", vo);
		System.out.println("userNo22" + vo.getUserNo());
		
		return "users/usersUpdateForm";
	}
	
	// 회원 정보 수정
	@PostMapping("/usersUpdate")
	public String usersUpdate(UsersVO vo, Model model) {
		model.addAttribute("users", us.usersUpdate(vo));
		return "redirect:usersSelectList";
	}
}

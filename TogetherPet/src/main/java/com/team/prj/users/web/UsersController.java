package com.team.prj.users.web;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.team.prj.users.service.UsersService;
import com.team.prj.users.service.UsersVO;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor // 생성자 주입
@Controller
public class UsersController {
	@Autowired
	private UsersService dao;
	
	// 개인 회원 리스트
	@GetMapping("/users/usersSelect")
	public String usersSelect(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		UsersVO vo = (UsersVO) session.getAttribute("user");
		
		model.addAttribute("userList", vo);
		return "users/usersSelect";
	}
	
	// 개인 회원 리스트
//	@GetMapping("/usersSelect")
//	public String usersSelect(UsersVO vo, Model model) {
//		model.addAttribute("userList", dao.usersSelect(vo));
//		return "users/usersSelect";
//	}
	
	// 회원 정보 수정 폼 호출
	@GetMapping("/user/usersUpdateForm")
	public String usersUpdateForm(UsersVO vo, Model model) {
		vo.setUserNo(1);
		model.addAttribute("userList", dao.usersSelect(vo));
		return "users/usersUpdateForm";
	}
	
	// 회원 정보 수정
	@PostMapping("/usersUpdate")
	public String usersUpdate(UsersVO vo, Model model) {
		model.addAttribute("updateList", dao.usersUpdate(vo));
		return "redirect:usersSelect";
	}
	
}

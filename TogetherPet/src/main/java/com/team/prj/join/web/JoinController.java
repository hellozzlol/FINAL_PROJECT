package com.team.prj.join.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.team.prj.join.service.JoinService;
import com.team.prj.join.service.RegisterMail;
import com.team.prj.users.service.UsersVO;

@Controller
public class JoinController {

	@Autowired
	private JoinService js;
	
	// 회원등록
	@PostMapping("/admin/userJoinForm")
	public String usersInsert(UsersVO vo) {
		js.usersInsert(vo);
		return "redirect:/loginForm";
	}
	
	
}
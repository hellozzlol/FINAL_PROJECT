package com.team.prj.join.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.team.prj.join.service.JoinService;
import com.team.prj.join.service.RegisterMail;
import com.team.prj.users.service.UsersService;
import com.team.prj.users.service.UsersVO;

@RestController
@RequestMapping("/join")
public class JoinAjaxController {
	
	@Autowired
	private JoinService js;
	
	@Autowired
	private RegisterMail rm;
	
	@Autowired
	private UsersService user;
	
	// 일반회원id 중복체크
	@ResponseBody
	@RequestMapping("/idCheck")
	public int idCheck(String id){
		System.out.println("===JoinAjaxCont" + id);
		int result = js.idCheck(id);
		return result;
	}
	
	// 튜터id 중복체크
	@ResponseBody
	@RequestMapping("/tCheck")
	public int tCheck(String id){
		System.out.println("===JoinAjaxCont" + id);
		int result = js.tCheck(id);
		return result;
	}
	
	
	// 판매자id 중복체크
	@ResponseBody
	@RequestMapping("/sCheck")
	public int sCheck(String id){
		System.out.println("===JoinAjaxCont" + id);
		int result = js.sCheck(id);
		return result;
	}
	

	// 닉네임 중복체크
	@ResponseBody
	@RequestMapping("/nickCheck")
	public int nickCheck(String nickname) {
		System.out.println("===JoinAjaxCont" + nickname);
		int result = js.nickCheck(nickname);
		return result;
	}
	
	
	// 이메일 인증
	@ResponseBody
	@PostMapping("/sendCode")
	public String mailConfirm(String email) throws Exception{
		String code="";
		try {
			code = rm.sendSimpleMessage(email);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("인증코드: " + code);
		return code;
	}
	
	
	// 비밀번호 재설정 - 업데이트 // 안 됨..
	@PostMapping("/pwUpdate")
	public String usersUpdate(UsersVO vo) {
		user.usersUpdate(vo);
		return "redirect:/loginForm";
	}
	
}

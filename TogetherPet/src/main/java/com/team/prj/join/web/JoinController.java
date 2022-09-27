package com.team.prj.join.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

	@RequestMapping(value = "/userJoinForm", method=RequestMethod.POST)
	public String registerPOST(UsersVO usersVO, String id, String nickname) throws Exception{
		int idResult = js.idCheck(id);
		int nickResult = js.nickCheck(nickname);
		System.out.println("??????????");
		try {
			if(idResult == 1 || nickResult == 1 ) {
				return "admin/userJoinForm";
			}else if(idResult == 0 && nickResult == 0 ) {
				js.usersInsert(usersVO);
			}
		}catch(Exception e) {
			throw new RuntimeException();
		}
		return "redirect:/";
	}
	
	// 이메일 인증
	@PostMapping("admin/mailConfirm")
	@ResponseBody
	String mailConfirm(@RequestParam("email") String email) throws Exception{
		String code=null;
		//String code = RegisterMail.sendSimpleMessage;
		System.out.println("인증코드: " + code);
		return code;
	}
}
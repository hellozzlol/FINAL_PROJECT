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
	
	
	@PostMapping("userJoinForm")
	public String usersInsert(UsersVO vo, Model model) {
		int u = js.usersInsert(vo);
		if (u !=0 ) {
			model.addAttribute("message", "정상적으로 추가 됨");
		}else {
			model.addAttribute("message", "멤버 추가 실패");
		}
		return "loginForm";
	}
	

//	@RequestMapping(value = "/userJoinForm", method=RequestMethod.POST)
//	public String registerPOST(UsersVO usersVO, String id, String nickname) throws Exception{
//		int idResult = js.idCheck(id);
//		int nickResult = js.nickCheck(nickname);
//		System.out.println("??????????");
//		try {
//			if(idResult == 1 || nickResult == 1 ) {
//				return "admin/userJoinForm";
//			}else if(idResult == 0 && nickResult == 0 ) {
//				js.usersInsert(usersVO);
//			}
//		}catch(Exception e) {
//			throw new RuntimeException();
//		}
//		return "redirect:/";
//	}
	
	
}
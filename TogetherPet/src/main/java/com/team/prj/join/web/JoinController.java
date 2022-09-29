package com.team.prj.join.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.team.prj.join.service.JoinService;
import com.team.prj.join.service.RegisterMail;
import com.team.prj.seller.service.SellerVO;
import com.team.prj.tutor.service.TutorVO;
import com.team.prj.users.service.UsersVO;

@Controller
//@RequestMapping("/mem")
public class JoinController {

	@Autowired
	private JoinService js;
	
	
	
	// 로그인
	@GetMapping("/loginForm")
	public String loginForm(Model model) {
		return "member/loginForm";
	}
	
	
	// 회원가입 메인페이지
	@GetMapping("/joinMain")
	public String joinMain() {
		return "member/joinMain";
	}
	
	// 일반회원 가입페이지
	@GetMapping("/userJoinForm")
	public String userJoinForm(Model model) {
		return "member/userJoinForm";
	}

	// 튜터회원 가입페이지
	@GetMapping("/tutorJoinForm")
	public String tutorJoinForm(Model model) {
		return "member/tutorJoinForm";
	}		
	
	// 판매자회원 가입페이지
	@GetMapping("/sellerJoinForm")
	public String sellerJoinForm(Model model) {
		return "member/sellerJoinForm";
	}		
	
	
		
	
	
	// 일반 회원등록
	@PostMapping("/member/userJoinForm")
	public String usersInsert(UsersVO vo) {
		js.usersInsert(vo);
		return "redirect:/loginForm";
	}
	
	// 튜터 회원등록
	@PostMapping("/admin/tutorJoinForm")
	public String tutorInsert(TutorVO vo) {
		
		return "redirect:/loginForm";
	}
	
	// 판매자 회원등록
	@PostMapping("/admin/sellerJoinForm")
	public String sellerInsert(SellerVO vo) {
		
		return "redirect:/loginForm";
	}
	
}
package com.team.prj.admin.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.team.prj.admin.service.adminService;
import com.team.prj.admin.service.adminVO;
import com.team.prj.attend.service.attendService;
import com.team.prj.attend.service.attendVO;


@Controller
public class adminController {
	
	@Autowired
	private adminService as;
	@Autowired
	private attendService ts;
	
	
	@RequestMapping("/manager/admin")
	public String admin() {
		return "admin/admin";
	}
	
	@RequestMapping("/manager/mypage")
	public String adminSelect(Model model, HttpServletRequest request) { 
		HttpSession session = request.getSession();
		adminVO vo = (adminVO) session.getAttribute("admin");
		
		// 고객 정보 가져오기
		model.addAttribute("admin", vo);
		
		// 근태 리스트 가져오기
		model.addAttribute("attendList", ts.attendSelectList(vo.getAdNo()));
		System.out.println("controller:"+model.getAttribute("attendList"));
		
		return "admin/mypage";
	}
	
//	@GetMapping("/visitCount")
//	public String visitCount(Model model) {
//		//
//		return "admin/visitCount";
//	}
	
	
	
	@GetMapping("/postCount")
	public String postCount(Model model) {
		//
		return "admin/postCount";
	}
	
	@GetMapping("/userManage")
	public String userManage(Model model) {
		//
		return "admin/userManage";
	}
	
	@GetMapping("/buserManage")
	public String buserManage(Model model) {
		//
		return "admin/buserManage";
	}
	
	
	@GetMapping("/allPostView")
	public String allPostView(Model model) {

		return "admin/allPostView";
	}
	

	@GetMapping("/postManage")
	public String postManage(Model model) {
		
		return "admin/postManage";
	}
	
	
	@GetMapping("/salesCheck")
	public String salesCheck(Model model) {
		
		return "admin/salesCheck";
	}
	
	@GetMapping("/loginForm")
	public String loginForm(Model model) {
		
		return "admin/loginForm";
	}
	
	@GetMapping("/userJoinForm")
	public String userJoinForm(Model model) {
		
		return "admin/userJoinForm";
	}
	
	@RequestMapping("/admin/workIn")
		public String workIn() {
			// Ad넘버를 받아가지고
			// insert
			// update
			return "출근되었습니다.";
		}
	}
	
	


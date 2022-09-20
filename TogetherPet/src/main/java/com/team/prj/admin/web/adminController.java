package com.team.prj.admin.web;

import com.team.prj.admin.service.adminService;
import com.team.prj.admin.service.adminVO;
import com.team.prj.attend.service.attendService;
import com.team.prj.attend.service.attendVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class adminController {
	
	@Autowired
	private adminService as;
	@Autowired
	private attendService ts;
	
	
	@RequestMapping("/admin")
	public String admin() {
		return "admin/admin2";
	}
	
	@GetMapping("/mypage")
	public String adminSelect(Model model, adminVO vo, attendVO tvo) { 
		vo.setAdNo(115913);
		
		// 고객 정보 가져오기
		vo = as.adminSelect(vo);
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
	
	
	
}

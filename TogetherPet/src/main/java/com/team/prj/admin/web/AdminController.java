package com.team.prj.admin.web;

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
public class AdminController {
	@Autowired
	private adminService as;
	private attendService ts;
	
	
	@RequestMapping("/admin")
	public String admin() {
		return "admin/admin";
	}
	
	@GetMapping("/mypage")
	public String adminSelect(Model model, adminVO vo) { 
		vo.setAdNo(115913);
		vo = as.adminSelect(vo);
		model.addAttribute("admin", vo);
		System.out.println(vo.getName());
	
//	String attendSelect(Model model1, attendVO tvo)
//		vo.setAdNo(115913);
//		tvo = ts.attendSelect(tvo);
//		model1.addAttribute("attend", tvo);
//		System.out.println(tvo.getStartDt());
		
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
}

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
import com.team.prj.users.service.UsersService;


@Controller
public class adminController {
	
	@Autowired
	private adminService as;
	
	@Autowired
	private attendService ts;
	
	@Autowired
	private UsersService us;


	
	
	@RequestMapping("/manager/admin")
	public String admin() {
		return "admin/admin";
	}
	
	@RequestMapping("/manager/mypage")
	public String adminSelect(Model model, HttpServletRequest request) { 
		HttpSession session = request.getSession();
		adminVO vo = (adminVO) session.getAttribute("admin");
		
		// 관리자 정보 가져오기
		model.addAttribute("admin", vo);
		
		// 근태 리스트 가져오기
		model.addAttribute("attendList", ts.attendSelectList(vo.getAdNo()));
		System.out.println("controller:"+model.getAttribute("attendList"));
		
		return "admin/mypage";
	}
	
	
	// 방문자 수
	@GetMapping("/manager/visitCount")
	public String visitCount(Model model) {
		//
		return "admin/visitCount";
	}
	
	// 조회수
	@GetMapping("/manager/postCount")
	public String postCount(Model model) {
		//
		return "admin/postCount";
	}
	
	
	// 일반회원 관리
	@GetMapping("/manager/memManage")
	public String memManage(Model model) {
		model.addAttribute("users", us.usersSelectList());
		return "member/memManage";
	}
	
	
	
	
	// 업체회원 관리
	@GetMapping("/manager/buserManage")
	public String buserManage(Model model) {
		//
		return "admin/buserManage";
	}
	
	
	// 전체 글 조회, 삭제?
	@GetMapping("/manager/allPostView")
	public String allPostView(Model model) {

		return "admin/allPostView";
	}
		
	//  
	@GetMapping("/manager/postManage")
	public String postManage(Model model) {
		
		return "admin/postManage";
	}
	

	
	
	
	// 로그인
	@GetMapping("/loginForm")
	public String loginForm(Model model) {
		
		return "admin/loginForm";
	}
	
	
	// 일반회원 가입
		@GetMapping("/userJoinForm")
		public String userJoinForm(Model model) {
			
			return "admin/userJoinForm";
		}

	
	// 출근 등록
	@RequestMapping("/admin/workIn")
		public String workIn(String checkVal, HttpServletRequest request) {
			HttpSession session = request.getSession();
			attendVO vo = (attendVO) session.getAttribute("admin");
		
		// Ad넘버를 받아
			attendVO avo = new attendVO();
			avo.setAdNo(vo.getAdNo());
			avo.setWorkCk(checkVal);
			
			// insert
			
			// update
			return "admin/admin";
		}
	}
	
	


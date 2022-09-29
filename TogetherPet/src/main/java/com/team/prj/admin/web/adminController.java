package com.team.prj.admin.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.team.prj.admin.service.adminService;
import com.team.prj.admin.service.adminVO;
import com.team.prj.attend.service.attendService;
import com.team.prj.attend.service.attendVO;
import com.team.prj.seller.service.SellerService;
import com.team.prj.seller.service.SellerVO;
import com.team.prj.tutor.service.TutorService;
import com.team.prj.tutor.service.TutorVO;
import com.team.prj.users.service.UsersService;
import com.team.prj.users.service.UsersVO;


@Controller
public class adminController {
	
	@Autowired
	private adminService admin;
	
	@Autowired
	private attendService attend;
	
	@Autowired
	private UsersService users;
	
	@Autowired
	private TutorService tutor;
	
	@Autowired
	private SellerService seller;


	
	
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
		model.addAttribute("attendList", attend.attendSelectList(vo.getAdNo()));
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
	@GetMapping("/manager/userManage")
	public String userManage(Model model, UsersVO vo, HttpServletRequest request,
			@RequestParam(required = false, defaultValue = "1") int pageNum,
			@RequestParam(required = false, defaultValue = "10") int pageSize) {
			PageHelper.startPage(pageNum, pageSize); 
			model.addAttribute("pageInfo", PageInfo.of(users.usersSelectList()));
			//model.addAttribute("users", us.usersSelectList());
		return "admin/userManage";
	}
		
	
	// 튜터회원 관리
	@GetMapping("/manager/tutorManage")
	public String tutorManage(Model model, TutorVO vo, HttpServletRequest request,
			@RequestParam(required = false, defaultValue = "1") int pageNum,
			@RequestParam(required = false, defaultValue = "10") int pageSize) {
			PageHelper.startPage(pageNum, pageSize); 
			model.addAttribute("pageInfo", PageInfo.of(tutor.tutorSelectList()));
		return "admin/tutorManage";
	}
	
	
	// 업체회원 관리
	@GetMapping("/manager/buserManage")
	public String buserManage(Model model, SellerVO vo, HttpServletRequest request,
			@RequestParam(required = false, defaultValue = "1") int pageNum,
			@RequestParam(required = false, defaultValue = "10") int pageSize) {
			PageHelper.startPage(pageNum, pageSize); 
			model.addAttribute("pageInfo", PageInfo.of(seller.sellerSelectList()));
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
	
	


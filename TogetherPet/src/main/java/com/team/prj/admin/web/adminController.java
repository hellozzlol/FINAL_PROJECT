package com.team.prj.admin.web;


import java.util.List;

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
import com.team.prj.board.service.BoardService;
import com.team.prj.board.service.BoardVO;
import com.team.prj.classes.service.ClassService;
import com.team.prj.classes.service.ClassVO;
import com.team.prj.goods.service.GoodsService;
import com.team.prj.goods.service.GoodsVO;
import com.team.prj.photo.service.PhotoVO;
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

	@Autowired
	private BoardService board;

	@Autowired
	private GoodsService goods;

	@Autowired
	private ClassService cs;

	@RequestMapping("/manager/admin")
	public String admin() {
		return "admin/admin";
	}

	@RequestMapping("/manager/mypage")
	public String adminSelect(Model model, HttpSession session) {
		adminVO vo = (adminVO) session.getAttribute("admin");

		// 관리자 정보 가져오기
		model.addAttribute("admin", vo);

		// 근태 리스트 가져오기
		model.addAttribute("attendList", attend.attendSelectList(vo.getAdNo()));
		// System.out.println("controller:"+model.getAttribute("attendList"));

		return "admin/mypage";
	}


	// 일반회원 관리
	@GetMapping("/manager/userManage")
	public String userManage(Model model, UsersVO vo, HttpServletRequest request,
			@RequestParam(required = false, defaultValue = "1") int pageNum,
			@RequestParam(required = false, defaultValue = "10") int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		model.addAttribute("pageInfo", PageInfo.of(users.usersSelectList()));
		// model.addAttribute("users", us.usersSelectList());
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

	// 전체 글 조회, 삭제 (커뮤니티)
	@GetMapping("/manager/boardPost")
	public String boardPost(Model model, BoardVO vo, HttpServletRequest request,
			@RequestParam(required = false, defaultValue = "1") int pageNum,
			@RequestParam(required = false, defaultValue = "10") int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		model.addAttribute("pageInfo", PageInfo.of(board.boardSelectList()));
		return "admin/boardPost";
	}

	// 전체 글 조회, 삭제 (상품) / (state: 1(승인완료) 조회)
	@GetMapping("/manager/goodsPost") 
	public String goodsPost(String key, Model model, BoardVO vo, HttpServletRequest request,
			@RequestParam(required = false, defaultValue = "1") int pageNum,
			@RequestParam(required = false, defaultValue = "10") int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		if (key == null) {
			key = "1";
		}
		model.addAttribute("pageInfo", PageInfo.of(goods.goodsSelectAll(key)));
		return "admin/goodsPost";
	}

	// 전체 글 조회, 삭제 (클래스) / (state: 1(승인완료) 조회)
	@GetMapping("/manager/classPost")
	public String boardPost(Model model, String key, ClassVO vo, HttpServletRequest request,
			@RequestParam(required = false, defaultValue = "1") int pageNum,
			@RequestParam(required = false, defaultValue = "10") int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		if (key == null) {
			key = "1";
		}
		model.addAttribute("pageInfo", PageInfo.of(cs.classSelectList(key)));
		return "admin/classPost";
	}

	// 글 등록 검토 (상품) / (state: 0(승인대기) 조회)
	@GetMapping("/manager/goodsConfirm")
	public String goodsConfirm(String key, Model model, GoodsVO vo, HttpServletRequest request,
			@RequestParam(required = false, defaultValue = "1") int pageNum,
			@RequestParam(required = false, defaultValue = "10") int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		if (key == null) {
			key = "1";
		}
		model.addAttribute("pageInfo", PageInfo.of(goods.goodsList(key)));
		
		//vo.setGoodsNo(1);
		vo = goods.goodsSelectOne(vo);
		model.addAttribute("goods", vo);
		System.out.println("vo확인=========================" + vo);
		
		List<PhotoVO> list = goods.goodsPhotoList(vo);
		model.addAttribute("photoList", list);
		
		return "admin/goodsConfirm";
	}

	// ***** 글 등록 검토(클래스) / (state: 0(승인대기) 조회)
	@GetMapping("/manager/classConfirm")
	public String classConfirm(Model model, ClassVO vo, HttpServletRequest request,
			@RequestParam(required = false, defaultValue = "1") int pageNum,
			@RequestParam(required = false, defaultValue = "10") int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		model.addAttribute("pageInfo", PageInfo.of(cs.classList()));
		return "admin/classConfirm";
	}

	


	
}

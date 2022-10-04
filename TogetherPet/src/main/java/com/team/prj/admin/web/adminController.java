package com.team.prj.admin.web;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.team.prj.admin.service.adminService;
import com.team.prj.admin.service.adminVO;
import com.team.prj.attend.service.attendService;
import com.team.prj.attend.service.attendVO;
import com.team.prj.board.service.BoardService;
import com.team.prj.board.service.BoardVO;
import com.team.prj.classes.service.ClassService;
import com.team.prj.classes.service.ClassVO;
import com.team.prj.goods.service.GoodsService;
import com.team.prj.goods.service.GoodsVO;
import com.team.prj.seller.service.SellerService;
import com.team.prj.seller.service.SellerVO;
import com.team.prj.tutor.service.TutorService;
import com.team.prj.tutor.service.TutorVO;
import com.team.prj.users.service.UsersService;
import com.team.prj.users.service.UsersVO;

import lombok.extern.log4j.Log4j2;

@Log4j2
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
		//System.out.println("controller:"+model.getAttribute("attendList"));
		
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
			@RequestParam(required = false, defaultValue = "7") int pageSize) {
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
	
	

	
	
	// 전체 글 조회, 삭제 (커뮤니티)
	@GetMapping("/manager/boardPost")
	public String boardPost(Model model, BoardVO vo, HttpServletRequest request,
			@RequestParam(required = false, defaultValue = "1") int pageNum,
			@RequestParam(required = false, defaultValue = "10") int pageSize) {
			PageHelper.startPage(pageNum, pageSize); 
			model.addAttribute("pageInfo", PageInfo.of(board.boardSelectList()));
		return "admin/boardPost";
	}
	
	
	@GetMapping("/manager/goodsPost") // (state가 1인것만 조회)
	public String goodsPost (String key, Model model, BoardVO vo, HttpServletRequest request,
			@RequestParam(required = false, defaultValue = "1") int pageNum,
			@RequestParam(required = false, defaultValue = "10") int pageSize) {
			PageHelper.startPage(pageNum, pageSize); 
			if(key==null) {
				key="1";
			}
			model.addAttribute("pageInfo", PageInfo.of(goods.goodsSelectAll(key)));

		return "admin/goodsPost";
	}
	
	
	// 전체 글 조회, 삭제 (클래스) // (state가 1인것만 조회)
	@GetMapping("/manager/classPost")
	public String boardPost(Model model, ClassVO vo, HttpServletRequest request,
			@RequestParam(required = false, defaultValue = "1") int pageNum,
			@RequestParam(required = false, defaultValue = "10") int pageSize) {
			PageHelper.startPage(pageNum, pageSize); 
			model.addAttribute("pageInfo", PageInfo.of(cs.classSelectList()));
		return "admin/classPost";
	}
	
	
		
	//글 등록 검토 (상품) // 상태 조건 걸기(state가 0인것만 조회)
	@GetMapping("/manager/goodsConfirm")
	public String goodsConfirm(String key, Model model, GoodsVO vo, HttpServletRequest request,
			@RequestParam(required = false, defaultValue = "1") int pageNum,
			@RequestParam(required = false, defaultValue = "10") int pageSize) {
			PageHelper.startPage(pageNum, pageSize); 
			if(key==null) {
				key="1";
			}
			model.addAttribute("pageInfo", PageInfo.of(goods.goodsList(key)));
		return "admin/goodsConfirm";
	}
	
	
	// 글 등록 검토(클래스) // (state가 0 = 승인대기 인것만 조회)
	@GetMapping("/manager/classConfirm")
	public String classConfirm(Model model, ClassVO vo, HttpServletRequest request,
			@RequestParam(required = false, defaultValue = "1") int pageNum,
			@RequestParam(required = false, defaultValue = "10") int pageSize) {
			PageHelper.startPage(pageNum, pageSize); 
			model.addAttribute("pageInfo", PageInfo.of(cs.classList()));
		return "admin/classConfirm";
	}
	

		
	
	// 출퇴근 등록
	@ResponseBody
	@RequestMapping("/admin/workIn")
		public String workIn(String checkVal, HttpServletRequest request) {
			
		HttpSession session = request.getSession();
		adminVO ado = (adminVO) session.getAttribute("admin");
		attendVO ato = new attendVO();
		ato.setAdNo(ado.getAdNo());
		
		//날짜,시간 구해오기
		LocalDate now = LocalDate.now();
		LocalTime time = LocalTime.now();
		ato.setState(0); // 디폴트 값 0(정상)으로 설정
		
		// 오늘 날짜 데이터 있는지 확인
		ato.setStartDt(now.toString()+" "+time.toString().substring(0, 8));
		List<HashMap<String,Object>> attendList = attend.attendSelectList(ato.getAdNo());
		
		
		for(HashMap<String,Object> map : attendList) {
			System.out.println("출근날짜::" + map.get("START_DT"));
			if(map.get("START_DT").toString().substring(0, 8).equals(now.toString())) {
				
			}
		}
		
		//9시 넘으면 지각
		if(time.getHour()>9||(time.getHour()==9&&time.getSecond()>1)){
			ato.setState(1);
		};
		
		attend.insertWorkIn(ato);
		
		if(checkVal!=null) {
			//퇴근
			attend.updateWorkIn();
		}else{
			//출근
			attend.insertWorkIn(ato);
		} 
			
			return "admin/admin"; // 처리 결과를 넘기기 page x  
		}
	}
	
	


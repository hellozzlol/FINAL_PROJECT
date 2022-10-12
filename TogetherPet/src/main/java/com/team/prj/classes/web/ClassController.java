package com.team.prj.classes.web;

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
import com.team.prj.classes.service.ClassOptionVO;
import com.team.prj.classes.service.ClassService;
import com.team.prj.classes.service.ClassVO;
import com.team.prj.classexreserve.service.ClassExreserveService;
import com.team.prj.classexreserve.service.ClassExreserveVO;
import com.team.prj.classreserve.service.ClassReserveService;
import com.team.prj.classreserve.service.ClassReserveVO;
import com.team.prj.photo.service.PhotoVO;
import com.team.prj.review.service.ReviewService;
import com.team.prj.review.service.ReviewVO;
import com.team.prj.tutor.service.TutorService;
import com.team.prj.tutor.service.TutorVO;
import com.team.prj.users.service.UsersVO;

@Controller
public class ClassController {
	
	@Autowired
	private ClassService clas;
	@Autowired 
	private ClassExreserveService exreserve;
	@Autowired
	private ClassReserveService reserve;
	@Autowired
	private ReviewService review;
	@Autowired
	private TutorService tutor;
	
	//소스코드 테스트용입니다
	@RequestMapping("test")
	public String test(Model model) {
		return "class/test";
	}
	
	//클래스 리스트 페이지
	@RequestMapping("classList")
	public String classSelectList(Model model, HttpServletRequest request,
			@RequestParam(required = false, defaultValue = "1") int pageNum,
			@RequestParam(required = false, defaultValue = "9") int pageSize) {
		//현재 페이지 번호와 1페이지에 출력할 레코드 건수 
		PageHelper.startPage(pageNum, pageSize); 
		
		model.addAttribute("pageInfo",PageInfo.of(clas.classSelectList()));
		return "class/classList";
	}
	
	//클래스 단건조회 페이지
	@RequestMapping("classSelect")
	public String classSelect(Model model, ClassVO vo) {
		//클래스 정보
		vo = clas.classSelect(vo);
		model.addAttribute("clas", vo);
		
		//클래스 옵션 리스트
		List<ClassOptionVO> oplist = clas.classOptionList(vo);
		model.addAttribute("optionList", oplist);
		
		//클래스 리뷰 리스트
		List<ReviewVO> relist = clas.classReviewSelectList(vo);
		model.addAttribute("reviewList", relist);
		
		//클래스 튜터 정보
		TutorVO tutor = clas.tutorSelect(vo);
		model.addAttribute("tutor", tutor);
		
		//클래스 그룹사진 슬라이드 리스트
		List<PhotoVO> polist = clas.classPhotoList(vo);
		model.addAttribute("photoList", polist);
		
		return "class/classSelect";
	}

	
	
	//클래스 삭제처리
	@RequestMapping("classDelete")
	public String classDelete(Model model,HttpServletRequest request, 
			ClassVO clvo, 
			@RequestParam(required = false, defaultValue = "1") int pageNum,
			@RequestParam(required = false, defaultValue = "3") int pageSize) {
		//클래스 삭제
		clas.classDelete(clvo);
		
		//현재 페이지 번호와 1페이지에 출력할 레코드 건수 
		PageHelper.startPage(pageNum, pageSize);
		HttpSession session = request.getSession();
		TutorVO tuvo = (TutorVO) session.getAttribute("tutor");
		clvo.setTutorNo(tuvo.getTutorNo());
		model.addAttribute("pageInfo",PageInfo.of(tutor.myClassList(clvo)));
		
		return "redirect:/tutorClassList";
	}
	

	
	//클래스 결제 페이지
	@RequestMapping("classExreserve")
	public String classExreserve(Model model, ClassExreserveVO vo) {

		exreserve.classExreserveInsert(vo);
		System.out.println("임시예약 입력");

		int exno = vo.getExreserveNo();
		
		ClassExreserveVO exvo = exreserve.classExreserveSelect(exno);
		model.addAttribute("ex", exvo);
		System.out.println("임시예약 리스트 넘김");

		return "class/classExreserve";
	}
	
	//reserveConfirm 클래스 최종 예약
	@RequestMapping("reserveConfirm")
	public String orderConfirm(Model model, ClassReserveVO vo) {
		
		//vo.setReserveNo(reserveNo);
		System.out.println(vo.getReserveNo());
		
		List<ClassReserveVO> list = reserve.classReserveSelectList(vo);
		vo = list.get(0);
		System.out.println("클래스 예약 내역 셀렉트 완료");

		
		// 적립금 업데이트
		UsersVO u = new UsersVO();
		u.setUserNo(vo.getUserNo());
		u.setMoney(vo.getMoney());
		reserve.updateMoney(u);
		
		model.addAttribute("reserve", vo);
	
		
		return "class/reserveConfirm";
	}
	
	

}

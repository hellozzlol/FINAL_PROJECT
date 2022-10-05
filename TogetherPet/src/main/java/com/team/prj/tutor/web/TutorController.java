package com.team.prj.tutor.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.team.prj.classes.service.ClassService;
import com.team.prj.classes.service.ClassVO;
import com.team.prj.tutor.service.TutorService;
import com.team.prj.tutor.service.TutorVO;

@Controller
public class TutorController {
	@Value("${file.dir}")
	private String fileDir;
	
	@Autowired
	private TutorService tutor;
	
	@Autowired
	private ClassService clas;
	
	
	//튜터 클래스 등록페이지
	@GetMapping("classInsert")
	public String classInsert(Model model) {
		
		return "tutor/classInsert";
	}
	
	//튜터 마이페이지 - 기본정보 단건조회
	@RequestMapping("tutorMyPage")
	public String tutorMyPage(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		TutorVO vo = (TutorVO) session.getAttribute("tutor");
		tutor.tutorMyPage(vo);
		return "tutor/tutorMyPage";
	}
	
	//튜터 마이페이지 - 튜터정보 단건조회
	@RequestMapping("tutorComList")
	public String tutorComList(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		TutorVO vo = (TutorVO) session.getAttribute("tutor");
		tutor.tutorMyPage(vo);
		return "tutor/tutorComList";
	}
		
	
	//튜터 마이페이지 - 튜터정보 수정폼
	@RequestMapping("tutorComUpForm")
	public String tutorComUpForm(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		TutorVO vo = new TutorVO();
		String id = (String)session.getAttribute("id");
		vo.setId(id);
		vo = tutor.tutorMyPage(vo);
		request.setAttribute("tutorList", vo);
		return "tutor/tutorComUpForm";
	}
		

	//튜터 마이페이지 - 튜터정보 수정처리
	@PostMapping("tutorComUpdate")
	public String tutorComUpdate(TutorVO vo, HttpServletRequest request) {
		HttpSession session = request.getSession();
		tutor.tutorUpdate(vo);
		vo = tutor.tutorMyPage(vo);
		session.setAttribute("tutor", vo);
		return "redirect:/tutorComList";
	}
	
	//튜터가 등록신청한 클래스 리스트
	@RequestMapping("/tutorClassList")
	public String tutorClassList(Model model,  HttpServletRequest request, 
			ClassVO clvo, 
			@RequestParam(required = false, defaultValue = "1") int pageNum,
			@RequestParam(required = false, defaultValue = "3") int pageSize) {
		//현재 페이지 번호와 1페이지에 출력할 레코드 건수 
		PageHelper.startPage(pageNum, pageSize);
		HttpSession session = request.getSession();
		TutorVO tuvo = (TutorVO) session.getAttribute("tutor");
		clvo.setTutorNo(tuvo.getTutorNo());
		model.addAttribute("pageInfo",PageInfo.of(tutor.myClassList(clvo)));
		
		return "tutor/tutorClassList";
	}
	
	//튜터가 등록신청한 클래스 리스트
	@RequestMapping("/classTuteeList")
	public String classTuteeList(Model model,  HttpServletRequest request, 
			ClassVO clvo, 
			@RequestParam(required = false, defaultValue = "1") int pageNum,
			@RequestParam(required = false, defaultValue = "3") int pageSize) {
		//현재 페이지 번호와 1페이지에 출력할 레코드 건수 
		//PageHelper.startPage(pageNum, pageSize);
		//HttpSession session = request.getSession();
		//TutorVO tuvo = (TutorVO) session.getAttribute("tutor");
		//clvo.setTutorNo(tuvo.getTutorNo());
		model.addAttribute("pageInfo",PageInfo.of(tutor.myClassList(clvo)));
		
		return "tutor/classTuteeList";
	}
	
	
}

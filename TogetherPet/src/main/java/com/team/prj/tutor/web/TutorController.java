package com.team.prj.tutor.web;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.team.prj.admin.service.ProfitVO;
import com.team.prj.classes.service.ClassOptionVO;
import com.team.prj.classes.service.ClassService;
import com.team.prj.classes.service.ClassVO;
import com.team.prj.seller.service.SellerVO;
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
		
	

	//튜터 마이페이지 - 개인정보 수정폼 호출
	@RequestMapping("/tutorMyPageUpdForm")
	public String tutorMyPageUpdForm(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		TutorVO vo = new TutorVO();
		String id = (String) session.getAttribute("id");
		vo.setId(id);
		vo = tutor.tutorMyPage(vo);
		model.addAttribute("tutorList", vo);
		return "tutor/tutorMyPageUpdForm";
	}
	
	
	//튜터 마이페이지 - 튜터정보 수정폼 호출
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
	
	

	//튜터 클래스 등록폼 호출
	@GetMapping("classInsert")
	public String classInsert(Model model) {
		return "tutor/classInsert";
	}
	
	
	//튜터 마이페이지 - 클래스 정보 수정폼 호출
	@RequestMapping("classUpdateForm")
	public String classUpdateForm(HttpServletRequest request, Model model, @RequestParam(value="classNo") int classNo) {
		HttpSession session = request.getSession();
		ClassVO vo = new ClassVO();
		//int classNo = (int)session.getAttribute("classNo");
		vo.setClassNo(classNo);
		vo = clas.classSelect(vo);
		//vo = clas.classUpdate(vo);
		request.setAttribute("clas", vo);
		return "tutor/classUpdateForm";
	}
		

	//튜터 마이페이지 - 개인정보 수정처리
	@PostMapping("tutorMyPageUpd")
	public String tutorMyPageUpd(TutorVO vo, HttpServletRequest request) {
		HttpSession session = request.getSession();
		tutor.tutorUpdate(vo);
		vo = tutor.tutorMyPage(vo);
		session.setAttribute("tutor", vo);
		return "redirect:/tutorMyPage";
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
	
	//클래스 수강자 및 정산 페이지 리스트
	@RequestMapping("/classTuteeList")
	public String classTuteeList(Model model, TutorVO tvo, HttpServletRequest request, 
			ClassVO clvo, String key,
			@RequestParam(required = false, defaultValue = "1") int pageNum,
			@RequestParam(required = false, defaultValue = "9") int pageSize) {
		//현재 페이지 번호와 1페이지에 출력할 레코드 건수 
		PageHelper.startPage(pageNum, pageSize);
		if (key == null) {
			key = "1";
		}
		HttpSession session = request.getSession();
		tvo = (TutorVO) session.getAttribute("tutor");
		clvo.setTutorNo(tvo.getTutorNo());
		model.addAttribute("pageInfo",PageInfo.of(tutor.myActiveClassList(clvo)));
		
		
		//총 정산완료액 처리
		List<ProfitVO> list = tutor.tutorProfitList(tvo, key);
		int sum = 0;
		for(int i = 0; i<list.size();i++) {
			if(list.get(i).getMinusYn().equals("1")) {
				sum += list.get(i).getMinusPrice();
			}
		}
		model.addAttribute("sum", sum);
		
		//총 정산대기액 처리
		List<ProfitVO> unlist = tutor.tutorProfitList(tvo, key);
		int unsum = 0;
		for(int i = 0; i<unlist.size();i++) {
			if(unlist.get(i).getMinusYn().equals("0")) {
				unsum += unlist.get(i).getMinusPrice();
			}
		}
		model.addAttribute("unsum", unsum);


		return "tutor/classTuteeList";
	}
	
	
//////////////////////////ajax/////////////////////////////////
	
	
	
	
	//튜터 마이페이지 - 그룹 사진 수정시 이전 데이터 삭제
	@RequestMapping("classExphotoDelete")
	@ResponseBody
	public int classExphotoDelete(Model model, @RequestParam(value="groupNo") int groupNo) {
		int result = tutor.classExphotoDelete(groupNo);
		
		return result;
	}
	
//	//튜터 마이페이지 - 옵션 수정 시 이전 데이터 삭제
	@RequestMapping("classExoptionDelete")
	@ResponseBody
	public int classExoptionDelete(Model model, @RequestParam(value="classNo") int classNo) {	
		int result = tutor.classExoptionDelete(classNo);
		
		return result;
	}
	
	
	//클래스 수강자 및 정산 리스트에서 해당 클래스 클릭시 옵션리스트 자세히보기
	@RequestMapping("classOptionList")
	@ResponseBody
	public List<ClassOptionVO> classOptionList(Model model, @RequestParam(value="classNo") int classNo){
		//먼저 클래스의 예약 건수를 확인
		int reserv = tutor.getClassReserve(classNo);
		
		if (reserv == 0) { //예약 건수가 0이면
			List<ClassOptionVO> list = tutor.classOption(classNo);
			model.addAttribute("option", list);	
			return list;
			
		} else { //예약 건수가 1이상 존재하면
			List<ClassOptionVO> list = tutor.classOptionList(classNo);
			model.addAttribute("option", list);	
			return list;
		}
		
	}

	
	//클래스 정산 리스트에서 특정 클래스의 옵션 클릭시 수강자명단 자세히보기
	@RequestMapping("optionReserv")
	@ResponseBody
	public List<ClassOptionVO> optionReserv(Model model, @RequestParam(value="classOptionNo") int classOptionNo){
		List<ClassOptionVO> list = tutor.optionReserv(classOptionNo);
		model.addAttribute("reserv", list);
		return list;
	}
	
	//정산 
	@RequestMapping("profitOrderBy")
	public List<ProfitVO> profitOrderBy(TutorVO tvo, HttpSession session,  String key){
		System.out.println(key);
		System.out.println("===============================================");
		if (key == null) {
			key = "1";
		}
		tvo = (TutorVO) session.getAttribute("tutor");
		
		tvo.setTutorNo(tvo.getTutorNo());
		List<ProfitVO> list = tutor.tutorProfitList(tvo, key);
		
		return list;
	}

}

package com.team.prj.classes.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.team.prj.cart.service.CartVO;
import com.team.prj.classes.service.ClassOptionVO;
import com.team.prj.classes.service.ClassService;
import com.team.prj.classes.service.ClassVO;
import com.team.prj.classexreserve.mapper.ClassExreserveMapper;
import com.team.prj.classexreserve.service.ClassExreserveService;
import com.team.prj.classexreserve.service.ClassExreserveVO;
import com.team.prj.classreserve.service.ClassReserveService;
import com.team.prj.classreserve.service.ClassReserveVO;
import com.team.prj.orders.service.OrderVO;

@Controller
public class ClassAjaxController {
	
	@Autowired
	private ClassService ajaxDao;
	
	@Autowired
	private ClassExreserveService exreserveDao;
	
	@Autowired
	private ClassReserveService reserveDao;

	
	
	//클래스 리스트에서 검색하는 ajax
	@RequestMapping("classSearch")
	@ResponseBody
	public List<ClassVO> classSearch(Model model, ClassVO vo){
		return ajaxDao.classSearch(vo);
	}
	
	
	//클래스 단건조회에서 일정 달력 ajax
	@RequestMapping("classDateOption")
	@ResponseBody
	public List<ClassOptionVO> classDateOption(Model model, String sdate, int no, ClassVO vo){
		List<ClassOptionVO> list = ajaxDao.classDateOption(sdate, no);
		model.addAttribute("option", list);
		System.out.println("여기까지오긴하는거니..?");
		return list;
	}
	
	// 주문 및 결제 하기 (등록)
	@RequestMapping("classReserveInsert")
	@ResponseBody
	public int orderInsert(ClassReserveVO vo, Model model) {
		//예약정보 인서트
		reserveDao.classReserveInsert(vo);
		int reserveNo = vo.getReserveNo();
		int money = vo.getMoney();
		System.out.println("예약정보 인서트 완료");
		
		//선택한 클래스 타임에 인원 +1
		ClassOptionVO opvo = new ClassOptionVO();
		int classOptionNo = vo.getClassOptionNo();
		opvo.setClassOptionNo(classOptionNo);
		reserveDao.updateHeadCount(opvo);
		System.out.println("클래스 신청인원 +1완료");
		
		//예약전 정보 삭제
		ClassExreserveVO exvo = new ClassExreserveVO();
		int exreserveNo = exvo.getExreserveNo();
		exvo.setExreserveNo(exreserveNo);
		exreserveDao.classExreserveDelete(exvo);
		System.out.println("예약 전 임시정보 삭제 완료");
		
		System.out.println("===========" + exreserveNo);
		System.out.println("===========" + reserveNo);
		System.out.println("===========" + money);

		return reserveNo;
	}
	

}

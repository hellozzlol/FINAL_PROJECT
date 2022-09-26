package com.team.prj.classes.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.team.prj.classes.mapper.ClassMapper;
import com.team.prj.classes.service.ClassOptionVO;
import com.team.prj.classes.service.ClassService;
import com.team.prj.classes.service.ClassVO;
import com.team.prj.classexreserve.mapper.ClassExreserveMapper;
import com.team.prj.classexreserve.service.ClassExreserveService;
import com.team.prj.classexreserve.service.ClassExreserveVO;
import com.team.prj.classreserve.mapper.ClassReserveMapper;
import com.team.prj.classreserve.service.ClassReserveService;
import com.team.prj.classreserve.service.ClassReserveVO;
import com.team.prj.orders.service.OrderVO;
import com.team.prj.users.service.UsersVO;

@Controller
public class ClassController {
	
	@Autowired 
	private ClassMapper dao;
	
	@Autowired
	private ClassService classes;
	
	@Autowired 
	private ClassExreserveService exreserve;
	
	@Autowired
	private ClassReserveService reserve;
	
	//소스코드 테스트용입니다
	@RequestMapping("test")
	public String test(Model model) {
		return "class/test";
	}
	
	//클래스 리스트 페이지
	@RequestMapping("classList")
	public String classSelectList(Model model) {
		model.addAttribute("class", dao.classSelectList());
		return "class/classList";
	}
	
	//클래스 단건조회 페이지
	@RequestMapping("classSelect")
	public String classSelect(Model model, ClassVO vo) {
		//클래스 정보
		vo = classes.classSelect(vo);
		model.addAttribute("clas", vo);
		
		// 리뷰리스트
		
		//클래스 사진 슬라이드 리스트
		//List<PhotoVO> list = classes.classPhotoList(vo);
		return "class/classSelect";
	}
	

	//클래스 등록페이지
	@GetMapping("classInsert")
	public String classInsert(Model model) {
		//ClassVO vo = new ClassVO();
		//model.addAttribute("class", dao.classInsert(vo));
		return "class/classInsert";
	}

	/*클래스 결제 페이지
	@RequestMapping("classExreserve")
	public String classExreserveSelect(Model model, ClassExreserveVO vo) {
		//클래스 예약 선택 정보
		vo = exreserve.classExreserveSelect(vo);
		model.addAttribute("exreserve", vo);
		return "class/classExreserve";
	}*/

	
	//클래스 결제 페이지
	@RequestMapping("classExreserve")
	public String classExreserve(Model model, ClassExreserveVO vo) {
		int insert =0;
		int delete =0;
		//임시예약에 있는지 단건조회
		ClassExreserveVO oldvo = exreserve.classExreserveSelect(vo);
		System.out.println("임시예약 입력 전 중복체크 단건조회");
		if(oldvo == null) {
			//임시예약에 없는 classNo이면 인서트
			insert = exreserve.classExreserveInsert(vo);
			System.out.println("임시예약 입력");
		} else {
			//임시예약에 있는 classNo이면 삭제하고 인서트
			delete = exreserve.classExreserveDelete(vo);
			System.out.println("임시예약 삭제");

			insert = exreserve.classExreserveInsert(vo);
			System.out.println("임시예약 삭제후입력");
		}
		List<ClassExreserveVO> list = exreserve.exreserveList(oldvo);
		model.addAttribute("exreserve", list);
		System.out.println("임시예약 리스트 넘김");
		
		return "class/classExreserve";
	}
	
	//reserveConfirm 클래스 최종 예약
	@RequestMapping("/reserveConfirm")
	public String orderConfirm(Model model, ClassReserveVO vo) {
		
		List<ClassReserveVO> list = reserve.classReserveSelectList(vo);
		vo = list.get(0);
		System.out.println("클래스 예약 내역 셀렉트 완료");
		
		// 상품 총 가격(할인후가격-적립금)
		int total = 0;
		for (int i = 0; i < list.size(); i++) {
			total += list.get(i).getTotalPrice();
		}
		total = total - vo.getMoney();

		// 적립금 업데이트
		UsersVO u = new UsersVO();
		System.out.println("===========" + vo.getUserNo());
		System.out.println("===========" + vo.getMoney());
		u.setUserNo(vo.getUserNo());
		u.setMoney(vo.getMoney());
		reserve.updateMoney(u);
		System.out.println("적립금 업데이트 완료");
		
		model.addAttribute("reserveList", list);
		model.addAttribute("reserve", vo);
		model.addAttribute("totalPrice", total);
		
		
		return "class/reserveConfirm";
	}
	
	

}

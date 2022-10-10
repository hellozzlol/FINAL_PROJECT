package com.team.prj.hospital.web;




import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.team.prj.hospital.service.HospitalService;
import com.team.prj.hospital.service.HospitalVO;
import com.team.prj.review.service.ReviewService;
import com.team.prj.review.service.ReviewVO;
import com.team.prj.scrap.service.ScrapVO;

@Controller
public class HospitalController {

	@Autowired
	private HospitalService dao;
	
	 @Autowired
	 private ReviewService service;

	// 개인 회원 => 병원 스크랩 리스트
	@GetMapping("/usersHospitalList")
	public String hospitalSelectList(HospitalVO vo, Model model, String key) {
		model.addAttribute("hospitalList", dao.hospitalSelectList(key));
		return "users/usersHospitalList";
	}

	// 병원리스트
	
	  @RequestMapping("/hospitalList") 
	  public String hospitalList(Model model, String key){
		  if(key==null) {
			  key="1";
		  }
	 model.addAttribute("hospital",
	 dao.hospitalSelectList(key)); 
	 return "hospital/hospitalList"; 
	  }
	// 상세보기
	@RequestMapping("/hospital")
	public String hospitalSelect(HospitalVO vo, Model model,ReviewVO rvo) {
		model.addAttribute("hospital", dao.hospitalSelect(vo));
		//리뷰리스트
				List<ReviewVO> relist = dao.hospitalreviewSelectList(vo);
				model.addAttribute("ReviewSelectList",relist);
		dao.hospitalHitUpdate(vo);// 조회수 증가
		return "hospital/hospitalSelect";
	}

	// 검색아작스처리

	@RequestMapping("/hospitalSearch")

	public String hospitalSearch(HospitalVO vo, String key, String val, Model model) {
		return "hospital/hospitalSearch";

	}
	
	//리뷰전체조회
	@RequestMapping("ReviewSelectList")
	public String reviewSelectList(ReviewVO vo, Model model) {
		model.addAttribute("reviewList",service.reviewSelectList(vo));
		return "hospital/ReviewSelectList";
	
	}
	
	//클래스 단건조회에서 리뷰 등록
	@RequestMapping("hospitalReviewInsert")
	@ResponseBody
	public ReviewVO funeralReviewInsert(ReviewVO rvo, Model model) {
		//리뷰 정보 인서트
		int insert =  service.reviewInsert(rvo);
	
		//닉네임 포함된 값으로 다시 조회
		ReviewVO result = dao.hospitalreviewSelect(rvo);
		return result;
	}

}

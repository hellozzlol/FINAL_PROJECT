package com.team.prj.accomo.web;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.team.prj.accomo.service.accomoService;
import com.team.prj.accomo.service.accomoVO;
import com.team.prj.board.service.BoardVO;
import com.team.prj.review.service.ReviewService;
import com.team.prj.review.service.ReviewVO;
import com.team.prj.users.service.UsersService;

@Controller
public class accomoController {
	
	@Autowired
	private accomoService service;
	
	 @Autowired
	 private ReviewService Rservice;
	 
	 @Autowired
	 private UsersService Uservice;

	
	//숙소리스트
	@RequestMapping("/accomoList")
	public String accomoList(Model model, BoardVO vo,
			                 @RequestParam(required = false, defaultValue = "1") String key){
	
		model.addAttribute("accomo", service.accomoSelectList(key));
		return "accomo/accomoList";

	}
	//숙소상세보기
	@RequestMapping("/accomo")
	public String accomoSelect(accomoVO vo, Model model) {
		model.addAttribute("accomo",service.accomoSelect(vo));
			//리뷰리스트
				List<ReviewVO> relist = service.accomoreviewSelectList(vo);
				model.addAttribute("rEviewSelectList",relist);
		service.accomoHitUpdate(vo);//조회수증가
		return "accomo/accomoSelect";
	}
	

	
	@RequestMapping("accomoSearch")	
	public String accomoSearch() {
		return "accomo/accomoSearch";
	}
	
	
	//리뷰전체조회
		@RequestMapping("rEviewSelectList")
		public String reviewSelectList(ReviewVO vo, Model model) {
			model.addAttribute("reviewList",Rservice.reviewSelectList(vo));
			return "accomo/rEviewSelectList";
		
		}
		
		//클래스 단건조회에서 리뷰 등록
		@RequestMapping("accomoReviewInsert")
		@ResponseBody
		public ReviewVO accomoReviewInsert(ReviewVO rvo, Model model) {
			//리뷰 정보 인서트
			int insert =  Rservice.reviewInsert(rvo);
		
			//닉네임 포함된 값으로 다시 조회
			ReviewVO result = service.accomoreviewSelect(rvo);
			return result;
		}
		
	
}

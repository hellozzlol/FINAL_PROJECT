package com.team.prj.seller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.team.prj.seller.service.SellerService;
import com.team.prj.seller.service.SellerVO;

@Controller
public class SellerController {
	@Autowired
	private SellerService seller;

	// 판매자 회원 전체 조회
	@RequestMapping("/seller/sellerSelectList")
	public String sellerSelectList(Model model) {
		model.addAttribute("sellerList", seller.sellerSelectList());
		return "seller/sellerSelectList";
	}

	// 판매자 회원(개인정보) 단건 조회
	@RequestMapping("/seller/sellerMyPage")
	public String sellerMyPage(Model model, SellerVO vo) {
		vo.setSellerNo(1);
		model.addAttribute("sellerList", seller.sellerSelect(vo));
		return "seller/sellerMyPage";
	}

	// 판매자 회원(개인정보) 수정 폼 호출
	@RequestMapping("/seller/sellerMyPageUpdForm")
	public String sellerMyPageUpdForm(SellerVO vo, Model model) {
		vo.setSellerNo(1);
		model.addAttribute("sellerList", seller.sellerSelect(vo));
		return "seller/sellerMyPageUpdForm";
	}

	// 판매자 회원(사업자) 단건 조회
	@RequestMapping("/seller/sellerComList")
	public String sellerComList(Model model, SellerVO vo) {
		vo.setSellerNo(1);
		model.addAttribute("sellerList", seller.sellerSelect(vo));
		return "seller/sellerComList";
	}

	// 판매자 정보(사업자) 수정 폼 호출
	@RequestMapping("/seller/sellerComUpForm")
	public String sellerComUpForm(SellerVO vo, Model model) {
		vo.setSellerNo(1);
		model.addAttribute("sellerList", seller.sellerSelect(vo));
		return "seller/sellerComUpForm";
	}

	// 판매자 회원(개인정보) 수정
	@PostMapping("/seller/sellerMyPageUpd")
	public String sellerUpdate(SellerVO vo, Model model) {
		model.addAttribute("sellerList", seller.sellerUpdate(vo));
		return "redirect:sellerSelect";
	}
	
	// 판매 상품 등록 폼 호출
	@RequestMapping("/seller/sellerGIForm")
	public String sellerGoodsInsert() {
		return "seller/sellerGIForm";
	}

}

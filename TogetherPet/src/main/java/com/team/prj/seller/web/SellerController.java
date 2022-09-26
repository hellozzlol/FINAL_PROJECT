package com.team.prj.seller.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
	public String sellerMyPage(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		SellerVO vo = (SellerVO) session.getAttribute("seller");
		seller.sellerMyPage(vo);
		return "seller/sellerMyPage";
	}

	// 판매자 회원(개인정보) 수정 폼 호출
	@RequestMapping("/seller/sellerMyPageUpdForm")
	public String sellerMyPageUpdForm(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		SellerVO vo = new SellerVO();
		String id = (String) session.getAttribute("id");
		vo.setId(id);
		vo = seller.sellerMyPage(vo);
		request.setAttribute("sellerList", vo);
		return "seller/sellerMyPageUpdForm";
	}

	// 판매자 회원(개인정보) 수정
	@PostMapping("/seller/sellerMyPageUpd")
	public String sellerUpdate(SellerVO vo, HttpServletRequest request) {
		HttpSession session = request.getSession();
		seller.sellerUpdate(vo);
		vo = seller.sellerMyPage(vo);
		session.setAttribute("seller", vo);
		return "redirect:/seller/sellerMyPage";
	}

	// 판매자 회원(사업자) 단건 조회
	@RequestMapping("/seller/sellerComList")
	public String sellerComList(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		SellerVO vo = (SellerVO) session.getAttribute("seller");
		seller.sellerMyPage(vo);
		return "seller/sellerComList";
	}

	// 판매자 정보(사업자) 수정 폼 호출
	@RequestMapping("/seller/sellerComUpForm")
	public String sellerComUpForm(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		SellerVO vo = new SellerVO();
		String id = (String) session.getAttribute("id");
		vo.setId(id);
		vo = seller.sellerMyPage(vo);
		request.setAttribute("sellerList", vo);
		return "seller/sellerComUpForm";
	}

	// 판매자 정보(사업자) 수정 처리
	@PostMapping("/seller/sellerComUpdate")
	public String sellerComUpdate(SellerVO vo, HttpServletRequest request) {
		HttpSession session = request.getSession();
		seller.sellerUpdate(vo);
		vo = seller.sellerMyPage(vo);
		session.setAttribute("seller", vo);
		return "redirect:/seller/sellerComList";
	}

	// 판매 상품 등록 폼 호출
	@RequestMapping("/seller/sellerGIForm")
	public String sellerGoodsInsert() {
		return "seller/sellerGIForm";
	}

	// 판매 상품 조회
	@RequestMapping("/seller/sellerGoodsList")
	public String sellerGoodsList(Model model) {
		model.addAttribute("sellerList", seller.sellerSelectList());
		return "seller/sellerGoodsList";
	}

	// 배송 관리 페이지
	@RequestMapping("/seller/sellerDeliList")
	public String sellerDeliList(Model model) {
		model.addAttribute("sellerList", seller.sellerSelectList());
		return "seller/sellerDeliList";
	}

	// 취소/반품 관리 페이지
	@RequestMapping("/seller/sellerCanList")
	public String sellerCanList(Model model) {
		model.addAttribute("sellerList", seller.sellerSelectList());
		return "seller/sellerCanList";
	}

	// 판매완료 상품 관리 페이지
	@RequestMapping("/seller/sellerDoneList")
	public String sellerDoneList(Model model) {
		model.addAttribute("sellerList", seller.sellerSelectList());
		return "seller/sellerDoneList";
	}

}

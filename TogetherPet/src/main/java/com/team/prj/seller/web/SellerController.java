package com.team.prj.seller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.team.prj.seller.service.SellerService;
import com.team.prj.seller.service.SellerVO;

@Controller
public class SellerController {
	@Autowired
	private SellerService dao;
	
	// 판매자 회원 전체 조회
	@GetMapping("/sellerSelectList")
	public String sellerSelectList(Model model) {
		model.addAttribute("sellerList", dao.sellerSelectList());
		return "seller/sellerSelectList";
	}
	
	// 판매자 회원 단건 조회
	@GetMapping("/sellerSelect")
	public String sellerSelect(Model model, SellerVO vo) {
		vo.setSellerNo(1);
		model.addAttribute("sellerList", dao.sellerSelect(vo));
		return "seller/sellerSelect";
	}
	
	
}

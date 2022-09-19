package com.team.prj.goods.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.team.prj.goods.service.GoodsService;
import com.team.prj.goods.service.GoodsVO;
import com.team.prj.photo.service.PhotoVO;
import com.team.prj.users.service.UsersVO;

@Controller
public class GoodsController {
	@Autowired
	private GoodsService dao;

	@GetMapping("/shop")
	public String goodsSelectAll(Model model, GoodsVO vo) {
		
		model.addAttribute("goodsList", dao.goodsSelectAll());
		model.addAttribute("photoList", dao.ThumbList());
		model.addAttribute("reviewCount", dao.reviewCount());
		return "shop/goodsSelectAll";
	}
	
	@RequestMapping("/goods")
	public String goodsSelectOne(Model model, GoodsVO vo) {
		// 조회수 업데이트
		dao.goodsHitUpdate(vo);
		// 제품 정보
		vo = dao.goodsSelectOne(vo);
		model.addAttribute("goods", vo);
		// 제품 사진 슬라이드 리스트
		List<PhotoVO> list = dao.goodsPhotoList(vo);
		model.addAttribute("photoList", list);
		// 제품 사진
		model.addAttribute("detailshot", dao.goodsPhoto(vo));
		// 리뷰리스트
		model.addAttribute("reviewList", dao.reviewList(vo));
		return "shop/goodsSelectOne";
	}
	
	// 장바구니 뿌리기
	@RequestMapping("/cart") // cartList
	public String cart(UsersVO vo) {
		vo.setUserNo(1);
		return "shop/cart";
	}
	
	@RequestMapping("/order")
	public String order() {
		return "shop/order";
	}

	@RequestMapping("/orderConfirm")
	public String orderConfirm() {
		return "shop/orderConfirm";
	}

}

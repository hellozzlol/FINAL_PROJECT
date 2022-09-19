package com.team.prj.goods.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.team.prj.cart.service.CartService;
import com.team.prj.cart.service.CartVO;
import com.team.prj.goods.service.GoodsService;
import com.team.prj.goods.service.GoodsVO;
import com.team.prj.photo.service.PhotoVO;

@Controller
public class GoodsController {
	@Autowired
	private GoodsService goods;
	@Autowired
	private CartService cart;

	@GetMapping("/shop")
	public String goodsSelectAll(Model model, GoodsVO vo) {

		model.addAttribute("goodsList", goods.goodsSelectAll());
		model.addAttribute("photoList", goods.ThumbList());
		model.addAttribute("reviewCount", goods.reviewCount());
		return "shop/goodsSelectAll";
	}

	@RequestMapping("/goods")
	public String goodsSelectOne(Model model, GoodsVO vo) {
		// 조회수 업데이트
		goods.goodsHitUpdate(vo);
		// 제품 정보
		vo = goods.goodsSelectOne(vo);
		model.addAttribute("goods", vo);
		// 제품 사진 슬라이드 리스트
		List<PhotoVO> list = goods.goodsPhotoList(vo);
		model.addAttribute("photoList", list);
		// 제품 사진
		model.addAttribute("detailshot", goods.goodsPhoto(vo));
		// 리뷰리스트
		model.addAttribute("reviewList", goods.reviewList(vo));
		return "shop/goodsSelectOne";
	}

	// 장바구니 뿌리기
	@RequestMapping("/cart") // cartList
	public String cart(CartVO vo, Model model) {
		List<CartVO> list = cart.cartList(vo);
		model.addAttribute("cartList", list);
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

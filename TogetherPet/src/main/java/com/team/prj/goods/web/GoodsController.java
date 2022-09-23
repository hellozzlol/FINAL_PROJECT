package com.team.prj.goods.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.team.prj.cart.service.CartService;
import com.team.prj.cart.service.CartVO;
import com.team.prj.goods.service.GoodsService;
import com.team.prj.goods.service.GoodsVO;
import com.team.prj.orders.service.OrderService;
import com.team.prj.orders.service.OrderVO;
import com.team.prj.photo.service.PhotoVO;
import com.team.prj.state.service.StateService;
import com.team.prj.users.service.UsersVO;

@Controller
public class GoodsController {
	@Autowired
	private GoodsService goods;
	@Autowired
	private CartService cart;
	@Autowired
	private OrderService order;

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

	// 주문 및 결제 페이지 (조회)
	@RequestMapping("/order") // cartList
	public String order(CartVO vo, Model model) {
		List<CartVO> list = cart.cartList(vo);
		model.addAttribute("cartList", list);
		return "shop/order";
	}

	// 주문 및 결제 하기 (등록)
	@RequestMapping("/orderInsert")
	public String orderInsert(OrderVO vo, Model model) {
		int cnt = order.insertOrder(vo);

		// vo = order.selectOrder(vo);
		model.addAttribute("order", vo);
		return "shop/orderConfirm";
	}

	@RequestMapping("/orderConfirm")
	public String orderConfirm(OrderVO vo, Model model) {
		List<OrderVO> oList = order.selectOrder(vo);
		vo = oList.get(0);
		
		// 상품 총 가격(할인후가격-적립금)
		int total = 0;
		for (int i = 0; i < oList.size(); i++) {
			total += oList.get(i).getTotalPrice();
		}
		total = total - vo.getMoney();
		
		// 적립금 업데이트
		UsersVO u = new UsersVO();
		System.out.println("===========" + vo.getUserNo());
		System.out.println("===========" + vo.getMoney());
		u.setUserNo(vo.getUserNo());
		u.setMoney(vo.getMoney());
		order.updateMoney(u);
		
		model.addAttribute("orderList", oList);
		model.addAttribute("order", vo);
		model.addAttribute("totalPrice", total);
		
		return "shop/orderConfirm";
	}
}

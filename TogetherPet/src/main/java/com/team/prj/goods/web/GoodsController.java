package com.team.prj.goods.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.sql.IsNull;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.team.prj.cart.service.CartService;
import com.team.prj.cart.service.CartVO;
import com.team.prj.goods.service.GoodsService;
import com.team.prj.goods.service.GoodsVO;
import com.team.prj.orders.service.OrderService;
import com.team.prj.orders.service.OrderVO;
import com.team.prj.photo.service.PhotoVO;
import com.team.prj.users.service.UsersService;
import com.team.prj.users.service.UsersVO;

@Controller
public class GoodsController {
	@Autowired
	private GoodsService goods;
	@Autowired
	private CartService cart;
	@Autowired
	private OrderService order;
	@Autowired
	private UsersService user; // 개인회원
	
	@RequestMapping("/shop")
	public String goodsSelectAll(String key, Model model) {
		if(key==null) {
			key="1";
		}
		model.addAttribute("goodsList", goods.goodsSelectAll(key));
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

	@RequestMapping("/orderConfirm")
	public String orderConfirm(OrderVO vo, Model model, HttpServletRequest request) {
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
		u.setUserNo(vo.getUserNo());
		u.setMoney(vo.getMoney());
		order.updateMoney(u);
		u = user.usersSelect(u);
		HttpSession session = request.getSession();
		session.setAttribute("user", u);
		
		model.addAttribute("orderList", oList);
		model.addAttribute("order", vo);
		model.addAttribute("totalPrice", total);
		
		return "shop/orderConfirm";
	}
}

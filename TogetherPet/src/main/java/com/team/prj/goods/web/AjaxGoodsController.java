package com.team.prj.goods.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.team.prj.cart.service.CartService;
import com.team.prj.cart.service.CartVO;
import com.team.prj.orders.service.OrderService;
import com.team.prj.orders.service.OrderVO;

@RestController
public class AjaxGoodsController {

	@Autowired
	private CartService cart;
	@Autowired
	private OrderService order;

	@RequestMapping("/ajaxCartInsert")
	public String insertCart(CartVO vo, int amount) {
		String msg = null;
		int cnt = 0;
		int qty = 0;
		
		// 장바구니에 없는 goodsNo이면 인서트
		// 장바구니에 있는 goodsNo이면 수량 업데이트
		CartVO oldCart = cart.isGoods(vo);
		
		if (oldCart == null) {
			cnt = cart.insertCart(vo);
		} else {
			// 장바구니에 있는 수량 + 새로 추가된 수량 > 재고 이면
			if (amount < oldCart.getQty() + vo.getQty()) {
				return "장바구니 수량이 상품 재고를 초과했습니다.";
			} else {
				oldCart.setQty(oldCart.getQty() + vo.getQty());
				cnt = cart.updateCart(oldCart);
			}
		}
		if (cnt > 0) {
			msg = "장바구니에 추가 완료! 장바구니로 이동하시겠습니까?";
		} 
		else {
			msg = "네트워크 문제로 인해 장바구니에 상품을 넣지 못하였습니다. 다시 시도해 주세요.";
		}
		return msg;
	}

	@RequestMapping("/ajaxCartDelete")
	public String deleteCart(CartVO vo) {
		String msg;
		int cnt = cart.deleteCart(vo);
		if (cnt > 0) {
			msg = "삭제되었습니다.";
		} else {
			msg = "네트워크 문제로 인해 장바구니에서 상품을 삭제하지 못하였습니다. 다시 시도해 주세요.";
		}
		return msg;
	}

	@RequestMapping("/ajaxCartUpdate")
	public int updateCart(CartVO vo) {
		int cnt = cart.updateCart(vo);
		return cnt;
	}

	// 주문 및 결제 하기 (등록)
	@RequestMapping("/ajaxOrderInsert")
	public int orderInsert(OrderVO vo, Model model) {
		// 등록
		order.insertOrder(vo);
		int orderNo = vo.getOrderNo();
		int money = vo.getMoney();

		// 재고 관리
		int qtyUpd = order.updateGoodsQty(vo);

		// 장바구니 삭제
		CartVO c = new CartVO();
		int cartNo = vo.getCartNo();
		c.setCartNo(cartNo);
		cart.deleteCart(c);

		System.out.println("===========" + qtyUpd);

		return orderNo;
	}
}

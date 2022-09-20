package com.team.prj.goods.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.team.prj.cart.service.CartService;
import com.team.prj.cart.service.CartVO;

@RestController
public class AjaxGoodsController {

	@Autowired
	private CartService cart;

	@RequestMapping("/ajaxCartInsert")
	public String insertCart(CartVO vo) {
		int cnt=0;
		int qty=0;
		CartVO oldCart = cart.isGoods(vo);
		// 장바구니에 없는 goodsNo이면 인서트
		// 장바구니에 있는 goodsNo이면 수량 업데이트
		if(oldCart==null) {
			cnt = cart.insertCart(vo);
		}else {
			oldCart.setQty(oldCart.getQty()+vo.getQty());
			cnt = cart.updateCart(oldCart);
		}
		String msg;
		if (cnt > 0) {
			msg = "장바구니에 추가 완료! 장바구니로 이동하시겠습니까?";
		} else {
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
			msg = "네트워크 문제로 인해 장바구니에 상품을 넣지 못하였습니다. 다시 시도해 주세요.";
		}
		return msg;
	}
	
	@RequestMapping("/ajaxCartUpdate")
	public int updateCart(CartVO vo) {
		int cnt = cart.updateCart(vo);
		return cnt;
	}
}

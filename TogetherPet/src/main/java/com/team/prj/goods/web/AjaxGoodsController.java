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
		int cnt = cart.insertCart(vo);
		String msg;
		if(cnt>0) {
			msg="장바구니에 추가 완료! 장바구니로 이동하시겠습니까?";
		}else {
			msg="네트워크 문제로 인해 장바구니에 상품을 넣지 못하였습니다. 다시 시도해 주세요.";
		}
		return msg;
	}
}

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
	
	@RequestMapping()
	public String insertCart(CartVO vo) {
		return "";
	}
}

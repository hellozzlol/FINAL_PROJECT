package com.team.prj.cart.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CartController {
	
	@RequestMapping("/cart")
	public String cart() {
		return "shop/cart";
	}
	
	@RequestMapping("/order")
	public String order() {
		return "shop/order";
	}
	
	@RequestMapping("/orderConfirm")
	public String orderConfirm() {
		return "shop/checkout";
	}
	

}

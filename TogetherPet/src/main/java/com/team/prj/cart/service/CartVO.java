package com.team.prj.cart.service;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartVO {
	private int goodsNo, userNo, qty, cartNo;

	// GoodsVO
	private String name;
	private int price;
	private double dc;
}

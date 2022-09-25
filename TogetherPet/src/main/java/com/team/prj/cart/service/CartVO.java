package com.team.prj.cart.service;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartVO {
	private int goodsNo, userNo, qty, cartNo;

	// 0920 희수 추가
	private String name;
	private int price;
	private double dc;
	
	// 0925 희수 추가
	private int amount; // 재고
}

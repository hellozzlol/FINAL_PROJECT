package com.team.prj.orders.service;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderVO {
	private int orderNo, amount, totalPrice, minusPrice, userNo, goodsNo;
	private String address, message, call, name, pay, payYn, deliveryNo, deliveryState, minusYn;
	private Date dt, minusDate;
	
	// 0923 희수 추가
	private int cartNo, money; 
	
	//0925 희수 추가
	private int sellerNo;
	private String goodsName;
	
	// 0927 선희 추가
	private String thumb;
}

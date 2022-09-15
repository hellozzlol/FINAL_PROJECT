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
}

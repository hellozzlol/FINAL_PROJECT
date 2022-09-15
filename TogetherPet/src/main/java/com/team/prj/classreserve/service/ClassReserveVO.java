package com.team.prj.classreserve.service;

import java.util.Date;

import lombok.Data;

@Data
public class ClassReserveVO {
	int reserveNo;
	Date dt;
	Date orderDate;
	String pay;
	String payYn;
	int userNo;
	int classNo;
	int minusPrice;
	int totalPrice;
	int minusYn;
	Date minusDate;
}

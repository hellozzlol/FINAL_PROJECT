package com.team.prj.classexreserve.service;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClassExreserveVO {

	//ClassVO
	private String name;
	private int price;
	private String address;
	private String thumb;
	
	//ClassOptionVO
	private String startDt;
	private String endDt;
	
	//ClassExreserveVO
	private int userNo, classOptionNo, exreserveNo, classNo;
	
	
	
}

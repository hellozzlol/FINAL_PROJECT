package com.team.prj.funeral.service;

import lombok.Data;

@Data

public class FuneralVO {
	
	
    //변수는 첫글자는 반드시 소문자 그리고 암튼 밑에 처럼 쓰면된다

	
	private int funeralNo;
	private String name;
	private String address;
	private String call;
	private String info;
	private String latitude;
	private String longitude;
	private String categoryId;
	
	
}

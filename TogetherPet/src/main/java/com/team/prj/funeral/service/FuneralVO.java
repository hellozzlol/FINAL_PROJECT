package com.team.prj.funeral.service;

import lombok.Data;

@Data

public class FuneralVO {
	
	
    //변수는 첫글자는 반드시 소문자 그리고 암튼 밑에 처럼 쓰면된다

	
	private int funeralNo;//장례번호
	private String name;//장례식장이름
	private String address;//주소
	private String call;//전화번호
	private String info;//정보
	private String latitude;//위도
	private String longitude;//경도
	private String categoryId;//카테고리아이디
	private String homepage;//홈페이지
	private String fphoto;//포토
	
	
}

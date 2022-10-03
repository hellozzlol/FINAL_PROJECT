package com.team.prj.accomo.service;

import lombok.Data;

@Data
public class accomoVO {
	private int accomoNo;//숙박번호 
	private String name;//숙박이름
	private String price;//숙박가격
	private String address;//숙박주소
	private String info;//숙박정보
	private String category_id;//카테고리아이디
	private String aphoto;//숙소사진
	private String latitude;// 숙소위도
	private String longitude;// 숙소경도
	private String hit;//조회수
	private int groupNo;//그룹번호
	private String category;
}

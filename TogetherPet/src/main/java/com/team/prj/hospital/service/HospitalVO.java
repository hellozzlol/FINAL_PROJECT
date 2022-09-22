package com.team.prj.hospital.service;

import lombok.Data;

@Data
public class HospitalVO {

	private int hospitalNo;// 병원번호
	private String name;// 병원이름
	private String address;// 병원소재지
	private String call;// 병원전화번호
	private String vet;// 병원수의사
	private String workingHour; // 병원영업시간
	private String info;// 병원정보
	private String latitude;// 병원위도
	private String longitude;// 병원경도
	private String hphoto;//병원사진
	private String hit;//조회
	private String categoryId;// 카테고리 아이디

}

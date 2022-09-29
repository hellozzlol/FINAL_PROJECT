package com.team.prj.seller.service;

import java.util.Date;

import com.team.prj.goods.service.GoodsVO;

import lombok.Data;

@Data
public class SellerVO {
	int sellerNo; // 판매자 번호
	String id; // 판매자 아이디
	String password; // 판매자 비밀번호
	String name; // 판매자 이름
	String company; // 상호
	String email; // 판매자 이메일
	String call; // 판매자 전화번호 
	String address; // 판매자 주소
	String companyNo; // 사업자번호
	String author; // 권한
	int groupNo; // 그룹번호
	Date dt; // 가입일자
	String attach; // 사진 0928 선희 추가
	String attachDir; // 사진 위치 0928 선희 추가
	String postcode; // 우편번호 0929 선희 추가
	String da; // 상세주소 0929 선희 추가
	
	
	private GoodsVO goods; // 0928 선희 추가
}

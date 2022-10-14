package com.team.prj.admin.service;

import lombok.Data;

@Data
// 1014 선희 추가(조회수 통계)
public class hitTableVO {
	int no; // 고유번호
	String id; // 카테고리 아이디
	String title; // 글제목
	int hit; // 조회수
	String dt; // 게시일자
}

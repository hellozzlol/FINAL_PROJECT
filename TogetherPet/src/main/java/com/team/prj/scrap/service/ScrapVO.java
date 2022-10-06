package com.team.prj.scrap.service;

import java.sql.Date;

import lombok.Data;

@Data
public class ScrapVO {
	int userNo; // 유저번호
	int boardNo; // 글번호
	Date dt; // 스크랩 일자
	String categoryId; // 카테고리 아이디
	int scrapNo;
	
	String name; // 병원,장례,숙박,게시판 이름 1004 선희추가
	String title; // 게시판 이름 1004 선희추가
}

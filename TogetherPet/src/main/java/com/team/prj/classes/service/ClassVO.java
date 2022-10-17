package com.team.prj.classes.service;


import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ClassVO {
	int classNo;
	String name;
	String category;
	String intro;
	//Date startDt;
	//Date endDt;
	String day;
	Date timeStart;
	Date timeEnd;
	int price;
	String uploadState;
	Date uploadDate;
	int hit;
	int maxHeadcount;
	int tutorNo;
	int groupNo;
	String address;
	String latitude;
	String longitude;
	String categoryId;
	String returnMessage;
	
	String []categories;
	//String []addresses;
	String searchkey;
	String searchval;
	
	String thumb; //썸네일
	String detail; //상세보기 
	
	int postcode; //우편번호
	String da; //상세주소
	int scrapNo; // 1006 선희 추가
}

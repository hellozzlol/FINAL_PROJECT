package com.team.prj.classes.service;

import java.util.Date;

import lombok.Data;

@Data
public class ClassVO {
	int classNo;
	String name;
	String category;
	String intro;
	Date startDt;
	Date endDt;
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
}

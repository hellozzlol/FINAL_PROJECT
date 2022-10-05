package com.team.prj.tutor.service;

import java.sql.Date;

import lombok.Data;

@Data
public class TutorVO {
	int tutorNo;
	String id;
	String password;
	String name;
	String introduce;
	String email;
	String call;
	String address;
	String author;
	Date dt;
	String snsInsta;
	String snsBlog;
	String snsYoutube;
	String attechDir;
	String attech;
	
	String state; // 상태 0929 JH 추가
	String postcode; // 우편번호  0929 JH 추가
	String da; // 상세주소  0929 JH 추가
}

package com.team.prj.tutor.service;

import java.sql.Date;

import lombok.Data;

@Data
public class TutorVO {
	int tutorNo;
	String id;
	String password;
	String name;
	String company;
	String email;
	String call;
	String address;
	String author;
	int groupNo;
	Date dt;
}

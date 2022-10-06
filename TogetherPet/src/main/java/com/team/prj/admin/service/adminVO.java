package com.team.prj.admin.service;

import java.sql.Date;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@ToString
public class adminVO {
	int adNo;
	String position;
	String dept;
	Date hiredate;
	String password;
	String name;
}

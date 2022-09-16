package com.team.prj.users.service;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsersVO {
	int userNo;
	String id;
	String password;
	String name;
	String nickname;
	String email;
	String call;
	String address;
	String author;
	int money;
	int groupNo;
	Date dt;
}

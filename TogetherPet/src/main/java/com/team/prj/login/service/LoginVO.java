package com.team.prj.login.service;

import lombok.Data;

@Data
public class LoginVO {
	private String id;
	private String password;
	private String name;
	private String author;
	private int no;
}
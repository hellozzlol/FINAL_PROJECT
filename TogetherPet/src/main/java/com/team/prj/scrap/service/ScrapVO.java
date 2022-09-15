package com.team.prj.scrap.service;

import java.sql.Date;

import lombok.Data;

@Data
public class ScrapVO {
	int userNo;
	int boardNo;
	Date dt;
	String categoryId;
}

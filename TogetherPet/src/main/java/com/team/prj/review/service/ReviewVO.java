package com.team.prj.review.service;



import java.sql.Date;

import lombok.Data;

@Data
public class ReviewVO {
		private int reviewNo;
		private String title;
		private String content;
		private String star;
		private Date dt;
		private int boardNo;
		private int categoryId;
		private int groupNo;
		private int userNo;
}

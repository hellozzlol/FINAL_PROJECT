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
		private String categoryId;
		private int groupNo;
		private int userNo;
		
		int rvCnt; // 리뷰 개수 표시하는 거 때문에 희수가 추가
		private String nickname; //리뷰에 닉네임 표시하는 거 때문에 지민 추가
}

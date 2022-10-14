package com.team.prj.review.service;



import java.sql.Date;

import lombok.Data;

@Data
public class ReviewVO {
		private int reviewNo;//리뷰번호
		private String title;//리뷰제목
		private String content;//리뷰내용
		private String star;//리뷰별점
		private Date dt;//리뷰작성일자
		private int boardNo;//글번호
		private String categoryId;//카테고리아이디
		private int groupNo;//그룹번호
		private int userNo;//유저번호
		
		int rvCnt; // 리뷰 개수 표시하는 거 때문에 희수가 추가
		private String nickname; //리뷰에 닉네임 표시하는 거 때문에 지민 추가
}

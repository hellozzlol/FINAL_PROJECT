package com.team.prj.board.service;

import java.util.Date;

import lombok.Data;

@Data

public class BoardVO {
	
	private int boardNo;//게시판번호
	private String title;//게시판제목
	private String content;//게시판내용
	private Date dt;//게시글작성일자
	private int likes;//게시글좋아용
	private int hit;//조회수
	private String category;//말머리 카테고리
	private int groupNo;//그룹번호(사진)
	private int userNo;//유저번호
}

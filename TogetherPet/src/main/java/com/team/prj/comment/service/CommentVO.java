package com.team.prj.comment.service;

import java.sql.Date;

import lombok.Data;

@Data
public class CommentVO {
	private int commentNo; //댓글번호
	private String content; //댓글내용
	private Date dt; //댓글날짜
	private int	boardNo; //게시글번호
	private int userNo; //유저번호
	
}

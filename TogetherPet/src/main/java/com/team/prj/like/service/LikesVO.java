package com.team.prj.like.service;

import lombok.Data;

@Data
public class LikesVO {
	private int userNo;// 유저번호
	private int boardNo;// 게시글번호
	private int classNo; // 클래스번호 0928 선희 DB에 추가
}

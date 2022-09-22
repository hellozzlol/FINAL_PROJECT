package com.team.prj.qna.service;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QnaVO {
	private int qnaNo, userNo, goodsNo, sellerNo;
	private String title, content, answer;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "Asia/Seoul")
	private Date dt;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "Asia/Seoul")
	private Date answerDate;
	
	private String nickname; // 0922 추가
}

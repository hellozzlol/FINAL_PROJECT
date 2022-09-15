package com.team.prj.qna.service;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QnaVO {
	private int qnaNo, userNo, goodsNo, sellerNo;
	private String title, content, answer;
	private Date dt, answerDate;
}

package com.team.prj.notice.service;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NoticeVO {
	private int noticeNo; // 알림번호
	private int userNo; // 알림받는유저
	private String content; // 알림내용
	private Date genTime; // 알림생성시간
	private Date readTime; // 알림 읽음처리 시간
	private String url; // 알림 받으면 이동할 url
	private String type; // 알림타입(0,1,2,3,4)
	private int refNo; // 알림이 있게한 글의 pk
}

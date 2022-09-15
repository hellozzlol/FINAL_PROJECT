package com.team.prj.notice.service;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NoticeVO {
	private int noticeNo, userNo, refNo;
	private String content, url, type;
	private Date getTime, readTime;
}

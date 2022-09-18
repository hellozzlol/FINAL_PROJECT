package com.team.prj.calendar.service;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CalendarVO {
	int calendarNo; // 일정 번호
	String title; // 일정 제목
	String content; // 일정 내용
	Date startDt; // 일정 시작일자
	Date endDt; // 일정 종료일자
	int userNo; // 유저 번호
}

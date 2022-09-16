package com.team.prj.calendar.service;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CalendarVO {
	int calendarNo;
	String title;
	String content;
	Date startDt;
	Date endDt;
	int userNo;
}

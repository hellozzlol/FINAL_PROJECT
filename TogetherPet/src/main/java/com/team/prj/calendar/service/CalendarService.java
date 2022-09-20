package com.team.prj.calendar.service;

import java.util.List;

public interface CalendarService {
	List<CalendarVO> calendarSelectList();
	
	CalendarVO calendarSelect(CalendarVO vo);
	
	int calendarInsert(CalendarVO vo);
	
	int calendarUpdate(CalendarVO vo);
	
	int calendarDelete(CalendarVO vo);
	
}

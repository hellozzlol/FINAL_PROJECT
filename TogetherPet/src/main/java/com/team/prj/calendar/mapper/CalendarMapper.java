package com.team.prj.calendar.mapper;

import java.util.List;

import com.team.prj.calendar.service.CalendarVO;

public interface CalendarMapper {
List<CalendarVO> calendarSelectList();
	
	CalendarVO calendarSelect(CalendarVO vo);
	
	int calendarInsert(CalendarVO vo);
	
	int calendarUpdate(CalendarVO vo);
	
	int calendarDelete(CalendarVO vo);
}

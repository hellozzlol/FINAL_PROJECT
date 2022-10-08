package com.team.prj.calendar.mapper;

import java.util.List;

import com.team.prj.calendar.service.CalendarVO;

public interface CalendarMapper {
	// 전체 일정
	List<CalendarVO> calendarSelectList(CalendarVO vo);

	// 일정 상세조회
	CalendarVO calendarSelect(CalendarVO vo);

	// 일정 등록
	int calendarInsert(CalendarVO vo);

	// 일정 수정
	int calendarUpdate(CalendarVO vo);

	// 일정 삭제
	int calendarDelete(CalendarVO vo);
}

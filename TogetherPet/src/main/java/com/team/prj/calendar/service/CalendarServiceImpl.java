package com.team.prj.calendar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.prj.calendar.mapper.CalendarMapper;

@Service
public class CalendarServiceImpl implements CalendarService {
	@Autowired
	private CalendarMapper map;
	
	// 전체 일정
	@Override
	public List<CalendarVO> calendarSelectList(CalendarVO vo) {
		return map.calendarSelectList(vo);
	}

	// 일정 상세 조회
	@Override
	public CalendarVO calendarSelect(CalendarVO vo) {
		return map.calendarSelect(vo);
	}

	// 일정 등록
	@Override
	public int calendarInsert(CalendarVO vo) {
		return map.calendarInsert(vo);
	}

	// 일정 수정
	@Override
	public int calendarUpdate(CalendarVO vo) {
		return map.calendarUpdate(vo);
	}

	// 일정 삭제
	@Override
	public int calendarDelete(CalendarVO vo) {
		return map.calendarDelete(vo);
	}

}

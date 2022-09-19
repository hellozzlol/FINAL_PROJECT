package com.team.prj.calendar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.prj.calendar.mapper.CalendarMapper;

@Service
public class CalendarServiceImpl implements CalendarService {
	@Autowired
	private CalendarMapper map;
	
	@Override
	public List<CalendarVO> calendarSelectList() {
		return map.calendarSelectList();
	}

	@Override
	public CalendarVO calendarSelect(CalendarVO vo) {
		return map.calendarSelect(vo);
	}

	@Override
	public int calendarInsert(CalendarVO vo) {
		return map.calendarInsert(vo);
	}

	@Override
	public int calendarUpdate(CalendarVO vo) {
		return map.calendarUpdate(vo);
	}

	@Override
	public int calendarDelete(CalendarVO vo) {
		return map.calendarDelete(vo);
	}

}

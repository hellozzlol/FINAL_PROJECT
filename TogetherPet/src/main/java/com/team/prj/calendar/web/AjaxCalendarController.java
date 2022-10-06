package com.team.prj.calendar.web;

import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.team.prj.calendar.service.CalendarService;
import com.team.prj.calendar.service.CalendarVO;
import com.team.prj.users.service.UsersVO;

@RestController
public class AjaxCalendarController {
	@Autowired
	private CalendarService calendar;
	
	// 일정 조회
	@RequestMapping("/calendarSelectList")
	public List<CalendarVO> calendarSelectList(CalendarVO cvo, HttpSession session){
		UsersVO uvo = (UsersVO) session.getAttribute("user");
		return calendar.calendarSelectList();
	}
	
	// 일정 등록
	@RequestMapping("/calendarInsert")
	public int calendarInsert(CalendarVO cvo) {
		calendar.calendarInsert(cvo);
		int calendarNo = cvo.getCalendarNo();
		return calendarNo;
	}
	
	// 일정 삭제
	@RequestMapping("/calendarDelete")
	public int calendarDelete(CalendarVO cvo) {
		
		return 0;
	}
}

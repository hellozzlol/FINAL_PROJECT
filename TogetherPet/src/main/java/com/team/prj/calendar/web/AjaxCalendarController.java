package com.team.prj.calendar.web;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
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
		cvo.setUserNo(uvo.getUserNo());
		return calendar.calendarSelectList(cvo);
	}
	
	// 일정 등록
	@PostMapping("/calendarInsert")
	public int calendarInsert(CalendarVO cvo, HttpSession session) {
		UsersVO uvo = (UsersVO) session.getAttribute("user");
		cvo.setUserNo(uvo.getUserNo());
		int calendarNo = cvo.getCalendarNo();
		calendar.calendarInsert(cvo);
		return calendarNo;
	}
	
	// 일정 삭제
	@PostMapping("/calendarDelete")
	public int calendarDelete(CalendarVO cvo, HttpSession session) {
		UsersVO uvo = (UsersVO) session.getAttribute("user");
		cvo.setUserNo(uvo.getUserNo());
//		System.out.println("==========");
//		System.out.println(cvo.getCalendarNo());
		int calendarNo = cvo.getCalendarNo();
		calendar.calendarDelete(cvo);
		return calendarNo;
	}
	
}

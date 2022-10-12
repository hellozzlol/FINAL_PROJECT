package com.team.prj.calendar.web;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.team.prj.calendar.service.CalendarService;
import com.team.prj.calendar.service.CalendarVO;
import com.team.prj.notice.service.NoticeService;
import com.team.prj.notice.service.NoticeVO;
import com.team.prj.users.service.UsersVO;

@RestController
public class AjaxCalendarController {
	@Autowired
	private CalendarService calendar;
	@Autowired
	private NoticeService notice; // 1010 선희 추가
	
	// 일정 조회
	@RequestMapping("/calendarSelectList")
	public List<CalendarVO> calendarSelectList(CalendarVO cvo, HttpSession session){
		UsersVO uvo = (UsersVO) session.getAttribute("user");
		cvo.setUserNo(uvo.getUserNo());
		return calendar.calendarSelectList(cvo);
	}
	
	// 일정 등록
	@PostMapping("/calendarInsert")
	public int calendarInsert(CalendarVO cvo, NoticeVO nvo, HttpSession session) {
		UsersVO uvo = (UsersVO) session.getAttribute("user");
		cvo.setUserNo(uvo.getUserNo());
		int calendarNo = cvo.getCalendarNo();
		int cnt = calendar.calendarInsert(cvo);
		
		// 알림 테이블에 등록 1010 선희추가
		int refNo = cvo.getCalendarNo();
		String title = cvo.getTitle();
		String type = "1"; // 알림 상태 1번(일정)
		String msg;
		msg = "'" + title + "'" + " 일정이 등록되었습니다.";
		nvo.setRefNo(refNo);
		nvo.setContent(title);
		nvo.setType(type);
		nvo.setContent(msg);
		
		CalendarVO c = new CalendarVO();
		c.setCalendarNo(refNo);
		int userNo = calendar.calendarSelect(cvo).getUserNo();
		nvo.setUserNo(userNo);
		notice.noticeInsert(nvo);
		
		return cnt;
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

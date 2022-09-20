package com.team.prj.calendar.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.team.prj.calendar.service.CalendarService;
import com.team.prj.calendar.service.CalendarVO;

@Controller
public class CalendarController {
	@Autowired
	private CalendarService dao;
	
	// 전체 일정
	@GetMapping("/calendarSelectList")
	public String calendarSelectList() {
		return "calendar/calendarSelectList";
	}
	
	// 일정 상세보기
	@RequestMapping("/calendarSelect")
	public String calendarSelect(CalendarVO vo, Model model) {
		model.addAttribute("cal", dao.calendarSelect(vo));
		return "calendar/calendarSelect";
	}
	
	// 일정 등록
	@PostMapping("/calendarInsert")
	public String calendarInsert(CalendarVO vo) {
		dao.calendarInsert(vo);
		return "redirect:calendarList";
	}
}

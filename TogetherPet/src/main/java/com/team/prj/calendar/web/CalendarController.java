package com.team.prj.calendar.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.team.prj.calendar.service.CalendarService;

@Controller
public class CalendarController {
	@Autowired
	private CalendarService dao;
	
	@GetMapping("/calendarSelectList")
	public String calendarSelectList() {
		return "calendar/calendarSelectList";
	}
}

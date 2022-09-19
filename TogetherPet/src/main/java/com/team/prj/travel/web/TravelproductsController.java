package com.team.prj.travel.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TravelproductsController {
	
	
	@RequestMapping("Trproduct")
	
	public String test (Model model) {
		return "travel/Trproduct";
		
	}
	
	
	
}

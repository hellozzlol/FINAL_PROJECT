package com.team.prj;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	
	@GetMapping("/index")
	public String index() {
		return "index";
	}
	
	@GetMapping("/error403")
	public String error403() {
		return "403";
	}
}

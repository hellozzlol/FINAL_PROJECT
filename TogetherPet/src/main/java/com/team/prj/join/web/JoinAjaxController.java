package com.team.prj.join.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.team.prj.join.service.JoinService;

@RestController
public class JoinAjaxController {
	@Autowired
	private JoinService js;
	
	// id 중복체크
	@ResponseBody
	@RequestMapping("/idCheck")
	public int idCheck(String id){
		System.out.println("====================" + id);
		int result = js.idCheck(id);
		return result;
	}

}

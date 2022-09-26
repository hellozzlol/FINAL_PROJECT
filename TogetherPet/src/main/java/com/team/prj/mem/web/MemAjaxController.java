package com.team.prj.mem.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.team.prj.mem.service.MemService;
import com.team.prj.users.service.UsersVO;

@RestController
public class MemAjaxController {
	@Autowired
	MemService dao;
	
//	@PostMapping("/stateUpdate")
//	public String stateUpdate(UsersVO vo) {
//		dao.stateUpdate(vo);
//		
//		String state = vo.getState();
//		System.out.println("===" + state);
//		
//		return state;
//	}
//	
}

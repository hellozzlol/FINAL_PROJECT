package com.team.prj.admin.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.team.prj.board.service.BoardService;

@RestController
public class AjaxadminController {
	
	@Autowired
	private BoardService board;
	
	

}

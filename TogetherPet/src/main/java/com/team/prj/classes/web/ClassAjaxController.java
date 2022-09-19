package com.team.prj.classes.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.team.prj.classes.service.ClassService;
import com.team.prj.classes.service.ClassVO;

@RestController
public class ClassAjaxController {
	
	@Autowired
	private ClassService ajaxDAO;
	
	@RequestMapping("/classSearch")
	public List<ClassVO> classSearch(ClassVO vo){
		return ajaxDAO.classSearch(vo);
	}
}

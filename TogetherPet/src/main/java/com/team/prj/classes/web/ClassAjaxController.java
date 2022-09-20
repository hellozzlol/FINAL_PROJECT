package com.team.prj.classes.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.team.prj.classes.service.ClassService;
import com.team.prj.classes.service.ClassVO;

@Controller
public class ClassAjaxController {
	
	@Autowired
	private ClassService ajaxDao;
	
	@RequestMapping("classSearch")
	@ResponseBody
	public List<ClassVO> classSearch(Model model, ClassVO vo){
		return ajaxDao.classSearch(vo);
	}
}

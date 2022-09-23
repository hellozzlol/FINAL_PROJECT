package com.team.prj.classes.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.team.prj.classes.service.ClassOptionVO;
import com.team.prj.classes.service.ClassService;
import com.team.prj.classes.service.ClassVO;

@Controller
public class ClassAjaxController {
	
	@Autowired
	private ClassService ajaxDao;
	
	//클래스 리스트에서 검색하는 ajax
	@RequestMapping("classSearch")
	@ResponseBody
	public List<ClassVO> classSearch(Model model, ClassVO vo){
		return ajaxDao.classSearch(vo);
	}
	
	//클래스 단건조회에서 일정 달력 ajax
	@RequestMapping("classDateOption")
	@ResponseBody
	public List<ClassOptionVO> classDateOption(Model model, String sdate, int no, ClassVO vo){
		List<ClassOptionVO> list = ajaxDao.classDateOption(sdate, no);
		model.addAttribute("option", list);
		System.out.println("여기까지오긴하는거니..?");
		return list;
	}
}

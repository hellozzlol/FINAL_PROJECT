package com.team.prj.classes.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.team.prj.classes.mapper.ClassMapper;
import com.team.prj.classes.service.ClassService;
import com.team.prj.classes.service.ClassVO;

@Controller
public class ClassController {
	
	@Autowired ClassMapper dao;
	
	@Autowired
	private ClassService classes;
	
	//소스코드 테스트용입니다
	@RequestMapping("test")
	public String test(Model model) {
		return "class/test";
	}
	
	//클래스 리스트 페이지
	@RequestMapping("classList")
	public String classSelectList(Model model) {
		model.addAttribute("class", dao.classSelectList());
		return "class/classList";
	}
	
	//클래스 단건조회 페이지
	@RequestMapping("classSelect")
	public String classSelect(Model model, ClassVO vo) {
		//클래스 정보
		vo = classes.classSelect(vo);
		model.addAttribute("clas", vo);
		
		//클래스 사진 슬라이드 리스트
		//List<PhotoVO> list = classes.classPhotoList(vo);
		return "class/classSelect";
	}
	

	//클래스 등록페이지
	@GetMapping("classInsert")
	public String classInsert(Model model) {
		//ClassVO vo = new ClassVO();
		//model.addAttribute("class", dao.classInsert(vo));
		return "class/classInsert";
	}
	

}

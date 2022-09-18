package com.team.prj.pet.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.team.prj.pet.service.PetService;
import com.team.prj.pet.service.PetVO;

@Controller
public class PetController {
	@Autowired
	private PetService dao;
	
	// 반려동물 전체 리스트
	@GetMapping("/petSelectList")
	public String petSelect(PetVO vo, Model model) {
		model.addAttribute("petList", dao.petSelectList());
		return "pet/petSelectList";
	}
}

package com.team.prj.pet.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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

	// 정보 수정 폼 호출
	@GetMapping("/petUpdateForm")
	public String petUpdateForm(PetVO vo, Model model) {
		model.addAttribute("petList", dao.petSelect(vo));
		return "pet/petUpdateForm";
	}

	// 정보 수정
	@PostMapping("/petUpdate")
	public String petUpdate(PetVO vo, Model model) {
		model.addAttribute("petList", dao.petSelect(vo));
		return "redirect:petSelectList";
	}
}

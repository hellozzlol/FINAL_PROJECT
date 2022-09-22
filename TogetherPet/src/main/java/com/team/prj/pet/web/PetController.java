package com.team.prj.pet.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.team.prj.pet.service.PetService;
import com.team.prj.pet.service.PetVO;

@Controller
public class PetController {
	@Autowired
	private PetService pet;

	// 반려동물 전체 리스트
	@RequestMapping("/petSelectList")
	public String petSelect(PetVO vo, Model model) {
		model.addAttribute("petList", pet.petSelectList());
		return "pet/petSelectList";
	}

	// 정보 수정 폼 호출
	@RequestMapping("/petUpdateForm")
	public String petUpdateForm(PetVO vo, Model model) {
		model.addAttribute("petList", pet.petSelectList());
		return "pet/petUpdateForm";
	}

	// 정보 수정
	@PostMapping("/petUpdate")
	public String petUpdate(PetVO vo, Model model) {
		model.addAttribute("petList", pet.petSelect(vo));
		return "redirect:petSelectList";
	}
}

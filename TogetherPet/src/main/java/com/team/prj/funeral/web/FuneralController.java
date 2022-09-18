package com.team.prj.funeral.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.team.prj.funeral.mapper.FuneralMapper;
import com.team.prj.funeral.service.FuneralVO;

@Controller
public class FuneralController {

	@Autowired
	private FuneralMapper dao;
	
	
	@RequestMapping("/funeralList")

	public String funeralList(Model model) {
		model.addAttribute("funeral", dao.findAll());
		return "funeral/funeralList";
	}

	/*
	 * @RequestMapping("/funeralSelect/{funeralNo}") public String
	 * funeralSelect(FuneralVO vo,Model model) {
	 * model.addAttribute("funeral",dao.funeralSelect(vo)); return
	 * "funeral/funeralSelect"; }
	 */
	
	@RequestMapping("/funeral")
	public String funeralSelect(FuneralVO vo,Model model) {
		model.addAttribute("funeral",dao.funeralSelect(vo));
		return  "funeral/funeralSelect";
	}
	
	

}

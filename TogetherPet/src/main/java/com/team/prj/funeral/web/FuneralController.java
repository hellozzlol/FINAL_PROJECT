package com.team.prj.funeral.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.team.prj.funeral.mapper.FuneralMapper;
import com.team.prj.funeral.service.FuneralVO;
import com.team.prj.scrap.service.ScrapService;
import com.team.prj.scrap.service.ScrapVO;
import com.team.prj.users.service.UsersService;


@Controller
public class FuneralController {

	@Autowired
	private FuneralMapper dao;
	
	 @Autowired 
	 private ScrapService Service;
	 
	 @Autowired
	 private UsersService Uservice;
	


	@RequestMapping("/funeralList")

	public String funeralList(Model model) {
		model.addAttribute("funeral", dao.findAll());
		return "funeral/funeralList";
	}

	

	@RequestMapping("/funeral")
	public String funeralSelect(FuneralVO vo, Model model) {
		model.addAttribute("funeral", dao.funeralSelect(vo));
		return "funeral/funeralSelect";
	}
	
	
	//소현 스크랩추가 20221006
	 
		 @PostMapping(value = "/scRapInsert.do")
		 @ResponseBody
		 
		 public int scrapInsert(ScrapVO vo) {
			 
			 return Service.scrapInsert(vo);
			 
		 }

}

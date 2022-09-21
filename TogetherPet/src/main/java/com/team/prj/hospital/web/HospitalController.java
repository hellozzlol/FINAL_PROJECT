package com.team.prj.hospital.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.team.prj.hospital.service.HospitalService;
import com.team.prj.hospital.service.HospitalVO;

@Controller
public class HospitalController {
	@Autowired
	private HospitalService dao;
	
	// 개인 회원 => 병원 스크랩 리스트
	@GetMapping("/usersHospitalList")
	public String hospitalSelectList(HospitalVO vo, Model model) {
		model.addAttribute("hospitalList", dao.hospitalSelectList());
		return "users/usersHospitalList";
	}
}

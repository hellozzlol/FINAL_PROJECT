package com.team.prj.admin.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.team.prj.admin.service.hitTableService;
import com.team.prj.admin.service.hitTableVO;

@Controller
public class hitTableController {
	@Autowired
	private hitTableService hit;
	
	// 조회수 테이블
	@RequestMapping("/manager/postCount")
	public String countTable(Model model, hitTableVO vo) {
		List<hitTableVO> hitAll = hit.hitAll(vo);
		List<hitTableVO> hitTable = hit.hitTable(vo);
		model.addAttribute("cnt", hitAll);
		model.addAttribute("cntTb", hitTable);
		return "admin/postCount";
	}
	
}

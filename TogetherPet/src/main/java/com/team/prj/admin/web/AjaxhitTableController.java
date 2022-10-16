package com.team.prj.admin.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.team.prj.admin.service.hitTableService;
import com.team.prj.admin.service.hitTableVO;

@RestController
public class AjaxhitTableController {
	@Autowired
	private hitTableService hit;
	
	// 조회수 차트
	@RequestMapping("/admin/ajaxPostCount")
	public @ResponseBody List<hitTableVO> postCount(Model model, hitTableVO vo) throws Exception {
		List<hitTableVO> count = hit.hitList(vo);
		model.addAttribute("count", count);
		return count;
	}
	
}

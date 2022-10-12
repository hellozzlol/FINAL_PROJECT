package com.team.prj;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.team.prj.goods.service.GoodsService;
import com.team.prj.hospital.service.HospitalService;

@Controller
public class MainController {
	@Autowired
	private GoodsService goods;
	
	@Autowired
	private HospitalService hospital;
	
	

	@GetMapping("/index")
	public String index(String key, Model model) {
		// 0926 희수추가
		if (key == null) {
			key = "1";
		}
		model.addAttribute("goodsList", goods.goodsSelectAll(key));
		model.addAttribute("hospital",hospital.hospitalSelectList(key));//소현 20221012추가 
		model.addAttribute("reviewCount", goods.reviewCount());
		
		return "index";
	}

	@GetMapping("/error403")
	public String error403() {
		return "403";
	}
	
	
	
	
	
	
	
}

package com.team.prj;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.team.prj.classes.service.ClassService;
import com.team.prj.goods.service.GoodsService;

@Controller
public class MainController {
	@Autowired
	private GoodsService goods;
	@Autowired
	private ClassService clas;

	@GetMapping("/index")
	public String index(String key, Model model) {
		// 0926 희수추가
		if (key == null) {
			key = "1";
		}
		model.addAttribute("goodsList", goods.goodsSelectAll(key));
		model.addAttribute("reviewCount", goods.reviewCount());
		model.addAttribute("class", clas.classSelectListMain());
		return "index";
	}

	@GetMapping("/error403")
	public String error403() {
		return "403";
	}
}

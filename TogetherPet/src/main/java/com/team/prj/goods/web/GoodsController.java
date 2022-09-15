package com.team.prj.goods.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.team.prj.goods.service.GoodsService;

@Controller
public class GoodsController {
	@Autowired 
	private GoodsService dao;
	
	@GetMapping("/shop")
	public String goodsSelectAll(Model model) {
		model.addAttribute("goodsList", dao.goodsSelectAll());
		return "shop/goodsSelectAll";
	}
}

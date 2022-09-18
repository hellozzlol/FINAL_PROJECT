package com.team.prj.goods.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.team.prj.goods.service.GoodsService;
import com.team.prj.goods.service.GoodsVO;
import com.team.prj.photo.service.PhotoVO;

@Controller
public class GoodsController {
	@Autowired
	private GoodsService dao;

	@GetMapping("/shop")
	public String goodsSelectAll(Model model, GoodsVO vo) {
		model.addAttribute("goodsList", dao.goodsSelectAll());
		model.addAttribute("photoList", dao.goodsThumbList());
		return "shop/goodsSelectAll";
	}
	
//	@RequestMapping("/shop")
//	public String goodsSelectFiltered(String   Model model)

	@RequestMapping("/goods")
	public String goodsSelectOne(Model model, GoodsVO vo) {
		dao.goodsHitUpdate(vo);
		vo = dao.goodsSelectOne(vo);
		model.addAttribute("goods", vo);

		List<PhotoVO> list = dao.goodsPhotoList(vo);
		model.addAttribute("photoList", list);

		return "shop/goodsSelectOne";
	}

	@RequestMapping("/cart")
	public String cart() {
		return "shop/cart";
	}

	@RequestMapping("/order")
	public String order() {
		return "shop/order";
	}

	@RequestMapping("/orderConfirm")
	public String orderConfirm() {
		return "shop/orderConfirm";
	}

}

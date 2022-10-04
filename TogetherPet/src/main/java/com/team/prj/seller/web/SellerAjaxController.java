package com.team.prj.seller.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.team.prj.goods.service.GoodsService;
import com.team.prj.goods.service.GoodsVO;
import com.team.prj.orders.service.OrderVO;

@RestController
public class SellerAjaxController {
	@Autowired
	GoodsService goods;

	// 상품 검색
	@RequestMapping("/goodsAjaxSearch")
	@ResponseBody
	public List<GoodsVO> goodsAjaxSearch(String key, @RequestParam String val) {
		return goods.goodsSearch(key, val);
	}

	// 상품 검색
	@RequestMapping("/orderAjaxSearch")
	@ResponseBody
	public List<OrderVO> orderAjaxSearch(String key, @RequestParam String val) {
		return goods.orderSearch(key, val);
	}
}

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
import com.team.prj.state.service.StateVO;

@RestController
public class SellerAjaxController {
	@Autowired
	GoodsService goods;

	// 상품 검색 goods
	@RequestMapping("/goodsAjaxSearch")
	@ResponseBody
	public List<GoodsVO> goodsAjaxSearch(String key, @RequestParam String val) {
		return goods.goodsSearch(key, val);
	}

	// 상품 검색 orders
	@RequestMapping("/orderAjaxSearch")
	@ResponseBody
	public List<OrderVO> orderAjaxSearch(String key, @RequestParam String val) {
		return goods.orderSearch(key, val);
	}

	// 상품 검색 state
	@RequestMapping("/stateAjaxSearch")
	@ResponseBody
	public List<StateVO> stateAjaxSearch(String key, @RequestParam String val) {
		return goods.stateSearch(key, val);
	}

	// 판매완료 상품 검색
	@RequestMapping("/goodsSellSearch")
	@ResponseBody
	public List<OrderVO> goodsSellSearch(String key, @RequestParam String val) {
		return goods.goodsSellSearch(key, val);
	}

}

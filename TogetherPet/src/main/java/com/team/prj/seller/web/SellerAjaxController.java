package com.team.prj.seller.web;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.team.prj.admin.service.ProfitVO;
import com.team.prj.goods.service.GoodsService;
import com.team.prj.goods.service.GoodsVO;
import com.team.prj.orders.service.OrderVO;

import com.team.prj.seller.service.SellerService;
import com.team.prj.seller.service.SellerVO;
import com.team.prj.users.service.UsersVO;

import com.team.prj.state.service.StateVO;


@RestController
public class SellerAjaxController {
	@Autowired
	GoodsService goods;

	@Autowired
	private SellerService seller;

	// 상품 검색

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

	// 정산 페이지 // 1005 희수 추가
	@RequestMapping("/ajaxProfitOrderBy")
	public List<ProfitVO> ajaxProfitOrderBy(SellerVO svo, HttpSession session, String key){
		System.out.println(key);
		System.out.println("===============================================");
		svo = (SellerVO) session.getAttribute("seller");
		svo.setSellerNo(svo.getSellerNo());
		List<ProfitVO> list = seller.sellerProfitList(svo, key);

		return list;
	}
}

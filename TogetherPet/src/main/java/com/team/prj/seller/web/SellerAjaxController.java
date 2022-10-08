package com.team.prj.seller.web;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.team.prj.admin.service.ProfitVO;
import com.team.prj.goods.service.GoodsService;
import com.team.prj.goods.service.GoodsVO;
import com.team.prj.orders.service.OrderVO;
import com.team.prj.qna.service.QnaVO;
import com.team.prj.scrap.service.ScrapVO;
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

	// 판매완료 상품 검색
	@RequestMapping("/qnaSearch")
	@ResponseBody
	public List<QnaVO> qnaSearch(String key, @RequestParam String val) {
		return seller.qnaSearch(key, val);
	}

	// 매출 합계와 건수 // 1008 희수 추가
	@RequestMapping("/ajaxGetSumSize")
	public int[] ajaxGetSumSize(SellerVO svo, String key, HttpSession session, String start, String end, String by) {
		
		int[] arr = new int[2];
		int sum = 0;

		if (key == null) {
			key = "2";
		}

		if (start == "") {
			start = null;
		}

		if (end == "") {
			end = null;
		}
		
		if (by == "") {
			by = null;
		}
		System.out.println("======== by =========");
		System.out.println(by);
		svo = (SellerVO) session.getAttribute("seller");
		svo.setSellerNo(svo.getSellerNo());
		
		List<ProfitVO> list = seller.sellerProfitList(svo, key, start, end, by);
		
		for (int i = 0; i < list.size(); i++) {
			sum += list.get(i).getMinusPrice();
		}

		arr[0] = sum;
		arr[1] = list.size();
		return arr;
	}

	// 상품 일괄 삭제
	@RequestMapping("/ajaxGoodsDelete")
	public String ajaxGoodsDelete(GoodsVO gvo) {
		String msg;
		int cnt = goods.deleteGoods(gvo);
		if (cnt > 0) {
			msg = "위시리스트에서 삭제되었습니다.";
		} else {
			msg = "일시적인 오류로 삭제하지 못하였습니다.";
		}
		return msg;
	}
}

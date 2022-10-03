package com.team.prj.goods.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.prj.goods.mapper.GoodsMapper;
import com.team.prj.orders.service.OrderVO;
import com.team.prj.photo.service.PhotoVO;
import com.team.prj.review.service.ReviewVO;

@Service
public class GoodsServiceImpl implements GoodsService {

	@Autowired
	private GoodsMapper map;

	@Override
	public List<GoodsVO> goodsSelectAll(String key) {
		// TODO Auto-generated method stub
		return map.goodsSelectAll(key);
	}

	@Override
	public GoodsVO goodsSelectOne(GoodsVO vo) {
		// TODO Auto-generated method stub
		return map.goodsSelectOne(vo);
	}

	@Override
	public int insertGoods(GoodsVO vo) {
		// TODO Auto-generated method stub
		return map.insertGoods(vo);
	}

	@Override
	public int updateGoods(GoodsVO vo) {
		// TODO Auto-generated method stub
		return map.updateGoods(vo);
	}

	@Override
	public int deleteGoods(GoodsVO vo) {
		// TODO Auto-generated method stub
		return map.deleteGoods(vo);
	}

	@Override
	public List<GoodsVO> goodsSearch(String key, String value) {
		// TODO Auto-generated method stub
		return map.goodsSearch(key, value);
	}

	@Override
	public int goodsHitUpdate(GoodsVO vo) {
		// TODO Auto-generated method stub
		return map.goodsHitUpdate(vo);
	}

	@Override
	public List<PhotoVO> goodsPhotoList(GoodsVO vo) {
		// TODO Auto-generated method stub
		return map.goodsPhotoList(vo);
	}


	@Override
	public List<Map<Integer, Integer>> reviewCount() {
		// TODO Auto-generated method stub
		return map.reviewCount();
	}


	@Override
	public List<ReviewVO> reviewList(GoodsVO vo) {
		// TODO Auto-generated method stub
		return map.reviewList(vo);
	}

	// 배송 조회(1003 선희 추가)
	@Override
	public List<OrderVO> deliveryList(OrderVO vo) {
		return map.deliveryList(vo);
	}

	// 배송 상태 업데이트(1003 선희 추가)
	@Override
	public int sellerDeliUpdate(OrderVO vo) {
		return map.sellerDeliUpdate(vo);
	}

}

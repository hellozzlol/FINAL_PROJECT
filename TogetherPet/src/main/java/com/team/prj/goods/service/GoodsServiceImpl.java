package com.team.prj.goods.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.prj.goods.mapper.GoodsMapper;
import com.team.prj.photo.service.PhotoVO;
import com.team.prj.review.service.ReviewVO;

@Service
public class GoodsServiceImpl implements GoodsService {

	@Autowired
	private GoodsMapper map;

	@Override
	public List<GoodsVO> goodsSelectAll() {
		// TODO Auto-generated method stub
		return map.goodsSelectAll();
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
	public List<PhotoVO> ThumbList() {
		return map.ThumbList();
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
	public PhotoVO goodsPhoto(GoodsVO vo) {
		// TODO Auto-generated method stub
		return map.goodsPhoto(vo);
	}

	@Override
	public List<ReviewVO> reviewList(GoodsVO vo) {
		// TODO Auto-generated method stub
		return map.reviewList(vo);
	}

}

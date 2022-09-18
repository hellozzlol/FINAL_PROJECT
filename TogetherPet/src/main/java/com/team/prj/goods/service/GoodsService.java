package com.team.prj.goods.service;

import java.util.List;

import com.team.prj.photo.service.PhotoVO;

public interface GoodsService {
	
	// 모든 상품 조회
	List<GoodsVO> goodsSelectAll();
	
	// 상세보기
	GoodsVO goodsSelectOne(GoodsVO vo);
	
	// 등록
	int insertGoods(GoodsVO vo);
	
	// 수정
	int updateGoods(GoodsVO vo);
		
	// 삭제
	int deleteGoods(GoodsVO vo);
	
	// 검색 기능
	List<GoodsVO> goodsSearch(String key, String value);
	
	// 조회수 처리
	int goodsHitUpdate(GoodsVO vo);
	
	// 썸네일 불러오기
	List<PhotoVO> goodsThumbList();
	
	// 포토리스트 불러오기
	List<PhotoVO> goodsPhotoList(GoodsVO vo);

}

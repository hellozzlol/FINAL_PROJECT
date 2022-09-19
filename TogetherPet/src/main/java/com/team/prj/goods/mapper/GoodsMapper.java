package com.team.prj.goods.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.team.prj.goods.service.GoodsVO;
import com.team.prj.photo.service.PhotoVO;
import com.team.prj.review.service.ReviewVO;

public interface GoodsMapper {

	// 모든 상품 조회
	@Select("select * from goods order by 1 desc")
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
	List<GoodsVO> goodsSearch(@Param("key") String key, @Param("value") String value);

	// 조회수 처리
	@Update("update goods set hit=hit+1 where goods_no=#{goodsNo}")
	int goodsHitUpdate(GoodsVO vo);

	// 썸네일 불러오기
	List<PhotoVO> ThumbList();

	// 포토리스트 불러오기
	List<PhotoVO> goodsPhotoList(GoodsVO vo);
	
	// 상세 사진 불러오기
	PhotoVO goodsPhoto(GoodsVO vo);

	// 리뷰리스트
	List<Map<Integer, Integer>> reviewCount();

	// 상세보기에 리뷰 뿌리기
	List<ReviewVO> reviewList(GoodsVO vo);

}

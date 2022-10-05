package com.team.prj.goods.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import com.team.prj.goods.service.GoodsVO;
import com.team.prj.orders.service.OrderVO;
import com.team.prj.photo.service.PhotoVO;
import com.team.prj.review.service.ReviewVO;
import com.team.prj.state.service.StateVO;

public interface GoodsMapper {

	// 모든 상품 조회
	List<GoodsVO> goodsSelectAll(@Param("key") String key);

	// 상세보기
	GoodsVO goodsSelectOne(GoodsVO vo);

	// 등록
	int insertGoods(GoodsVO vo);

	// 수정
	int updateGoods(GoodsVO vo);

	// 삭제
	int deleteGoods(GoodsVO vo);

	// 검색 기능(1004 선희 수정 => String value -> String val로 변경)
	List<GoodsVO> goodsSearch(@Param("key") String key, @Param("val") String val);

	// 오더 검색 기능(1004 선희 추가)
	List<OrderVO> orderSearch(@Param("key") String key, @Param("val") String val);

	// 반품교환 검색 기능(1005 선희 추가)
	List<StateVO> stateSearch(@Param("key") String key, @Param("val") String val);

	// 판매완료 상품 검색 기능(1005 선희 추가)
	List<OrderVO> goodsSellSearch(@Param("key") String key, @Param("val") String val);

	// 조회수 처리
	@Update("update goods set hit=hit+1 where goods_no=#{goodsNo}")
	int goodsHitUpdate(GoodsVO vo);

	// 포토리스트 불러오기
	List<PhotoVO> goodsPhotoList(GoodsVO vo);

	// 리뷰리스트
	List<Map<Integer, Integer>> reviewCount();

	// 상세보기에 리뷰 뿌리기
	List<ReviewVO> reviewList(GoodsVO vo);

	// 배송 상품 조회(1003 선희 추가)
	List<OrderVO> deliveryList(OrderVO vo);

	// 배송 상태 업데이트 => 상품준비중(1003 선희 추가)
	int deliveryReadyUpdate(OrderVO vo);

	// 배송 상태 업데이트 => 배송지시(1004 선희 추가)
	int deliveryUpdate(OrderVO vo);

	// 배송 상태 업데이트 => 배송완료(1005 선희 추가)
	int deliveryDone(OrderVO vo);

	// 상품 조회(state=0 (미 승인) 1004 추가 / 지혜)
	List<GoodsVO> goodsList(String key);

	// 반품/교환 상품 조회(1004 선희 추가)
	List<OrderVO> sellerCancelList(OrderVO vo);

	// 판매완료 상품 조회(1004 선희 추가)
	List<OrderVO> sellerDoneList(OrderVO vo);

	// 반품요청 상태 업데이트(1004 선희 추가)
	int cancelUpdate(StateVO vo);

	// 교환요청 상태 업데이트(1004 선희 추가)
	int changeUpdate(StateVO vo);

}

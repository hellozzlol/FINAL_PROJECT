package com.team.prj.seller.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import com.team.prj.admin.service.ProfitVO;
import com.team.prj.goods.service.GoodsVO;
import com.team.prj.orders.service.OrderVO;
import com.team.prj.qna.service.QnaVO;
import com.team.prj.users.service.UsersVO;

public interface SellerService {
	// 판매자 전체 조회
	List<SellerVO> sellerSelectList();

	// 판매자 단건 조회
	SellerVO sellerMyPage(SellerVO vo);

	// 판매자 등록
	int sellerInsert(SellerVO vo);

	// 판매자 정보 수정
	int sellerUpdate(SellerVO vo);

	// 판매자 삭제
	int sellerDelete(SellerVO vo);

	// 판매자 상품 조회
	List<GoodsVO> goodsList(GoodsVO vo);
	
	// 판매자 상품 등록
	int goodsInsert(GoodsVO vo);
	
	// 정산내역조회(1005 희수 추가)
	List<ProfitVO> sellerProfitList(@Param("svo") SellerVO svo, @Param("key") String key, @Param("start") String start, @Param("end") String end);

	// 판매자회원 검색 / 1005 지혜 추가
	List<UsersVO> sUserSearch(@Param("key")String key, @Param("val") String val);
	
	// 고객문의 조회
	List<QnaVO> qnaSelectList(QnaVO vo);
	
	// 문의 상세보기
	QnaVO qnaSelect(QnaVO vo);
	
	// 문의 검색
	List<QnaVO> qnaSearch(@Param("key") String key, @Param("val") String val);

	// 문의 답변
	int qnaAnswer(QnaVO vo);
}

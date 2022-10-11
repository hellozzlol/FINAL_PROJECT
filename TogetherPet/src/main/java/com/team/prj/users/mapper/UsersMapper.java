package com.team.prj.users.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.team.prj.board.service.BoardVO;
import com.team.prj.cart.service.CartVO;
import com.team.prj.classes.service.ClassVO;
import com.team.prj.classreserve.service.ClassReserveVO;
import com.team.prj.comment.service.CommentVO;
import com.team.prj.hospital.service.HospitalVO;
import com.team.prj.like.service.LikesVO;
import com.team.prj.orders.service.OrderVO;
import com.team.prj.photo.service.PhotoVO;
import com.team.prj.scrap.service.ScrapVO;
import com.team.prj.state.service.StateVO;
import com.team.prj.users.service.UsersVO;

public interface UsersMapper {
	// 전체 리스트
	List<UsersVO> usersSelectList();

	// 단건 조회
	UsersVO usersSelect(UsersVO vo);

	// 등록
	int usersInsert(UsersVO vo);

	// 수정
	int usersUpdate(UsersVO vo);

	// 삭제
	int usersDelete(UsersVO vo);

	// 주문 내역 조회
	List<OrderVO> orderList(OrderVO vo);

	// 주문 내역 삭제
	int orderDelete(OrderVO vo);

	// 사진 불러오기
	List<PhotoVO> photoList(PhotoVO vo);

	// 장바구니 조회
	List<CartVO> cartList(CartVO vo);

	// 수강내역 조회
	List<ClassVO> classList(ClassReserveVO vo);

	// 위시리스트 조회
	List<LikesVO> likeList(ScrapVO vo);

	// 위시리스트 삭제
	int likeDelete(ScrapVO vo);

	// 내 스크랩조회
	List<ScrapVO> scrapList(ScrapVO vo);

	// 병원 스크랩 조회
	List<ScrapVO> hospitalScrap(ScrapVO vo);

	// 장례 스크랩 조회
	List<ScrapVO> funeralScrap(ScrapVO vo);

	// 숙박 스크랩 조회
	List<ScrapVO> accomoScrap(ScrapVO vo);

	// 커뮤니티 스크랩 조회
	List<ScrapVO> communityScrap(ScrapVO vo);

	// 작성 글조회
	List<BoardVO> boardList(BoardVO vo);

	// 작성 댓글조회
	List<CommentVO> commentList(CommentVO vo);

	// 일반회원 검색 / 1005 지혜 추가
	List<UsersVO> userSearch(@Param("key") String key, @Param("val") String val);

	// 작성글 삭제
	int usersBoardDelete(BoardVO vo);

	// 작성 댓글 삭제
	int usersCommentDelete(CommentVO vo);

	// 스크랩 삭제
	int usersScrapDelete(ScrapVO vo);
	

}

package com.team.prj.users.service;

import java.util.List;

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

public interface UsersService {
	// 내정보조회(단건 조회)
	UsersVO usersSelect(UsersVO vo);

	// 내정보수정
	int usersUpdate(UsersVO vo);

	// 회원삭제
	int usersDelete(UsersVO vo);

	// 주문 내역 조회
	List<OrderVO> orderList(OrderVO vo);

	// 사진 불러오기
	List<PhotoVO> photoList(PhotoVO vo);

	// 장바구니 조회
	List<CartVO> cartList(CartVO vo);

	// 수강내역 조회
	List<ClassVO> classList(ClassReserveVO vo);

	// 위시리스트 조회
	List<LikesVO> likeList(ScrapVO vo);

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

	// 전체 리스트
	List<UsersVO> usersSelectList();

	// 등록
	int usersInsert(UsersVO vo);

	// 일반회원 상태 변경 / 0929 지혜 추가
	int usersStateUpdate(UsersVO vo);

}

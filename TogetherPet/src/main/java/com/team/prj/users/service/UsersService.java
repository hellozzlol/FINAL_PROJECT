package com.team.prj.users.service;

import java.util.List;

import com.team.prj.board.service.BoardVO;
import com.team.prj.cart.service.CartVO;
import com.team.prj.classes.service.ClassVO;
import com.team.prj.classreserve.service.ClassReserveVO;
import com.team.prj.comment.service.CommentVO;
import com.team.prj.orders.service.OrderVO;
import com.team.prj.pet.service.PetVO;
import com.team.prj.photo.service.PhotoVO;
import com.team.prj.scrap.service.ScrapVO;

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
	
	// 작성 글조회
	List<BoardVO> boardSelectList(int boardNo, int userNo, String category);
	
	// 작성 댓글조회
	List<CommentVO> commentSelectList(int commentNo, int userNo, String category);
	
	// 내 스크랩조회
	List<ScrapVO> scrapSelectList(int boardNo, int userNo, String category);
	
	// 전체 리스트
	List<UsersVO> usersSelectList();
	
	// 등록
	int usersInsert(UsersVO vo);

}

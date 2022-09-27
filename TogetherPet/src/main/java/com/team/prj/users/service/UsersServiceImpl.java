package com.team.prj.users.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.prj.board.service.BoardVO;
import com.team.prj.cart.service.CartVO;
import com.team.prj.classes.service.ClassVO;
import com.team.prj.classreserve.service.ClassReserveVO;
import com.team.prj.comment.service.CommentVO;
import com.team.prj.orders.service.OrderVO;
import com.team.prj.pet.service.PetVO;
import com.team.prj.photo.service.PhotoVO;
import com.team.prj.scrap.service.ScrapVO;
import com.team.prj.users.mapper.UsersMapper;

@Service
public class UsersServiceImpl implements UsersService {
	@Autowired
	private UsersMapper map;
	
	// 전체 유저 조회
	@Override
	public List<UsersVO> usersSelectList() {
		return map.usersSelectList();
	}

	// 유저 단건 조회
	@Override
	public UsersVO usersSelect(UsersVO vo) {
		return map.usersSelect(vo);
	}

	// 유저 등록
	@Override
	public int usersInsert(UsersVO vo) {
		return map.usersInsert(vo);
	}

	// 유저 수정
	@Override
	public int usersUpdate(UsersVO vo) {
		return map.usersUpdate(vo);
	}

	// 유저 삭제
	@Override
	public int usersDelete(UsersVO vo) {
		return map.usersDelete(vo);
	}
	
	// 주문 내역 조회
	@Override
	public List<OrderVO> orderList(OrderVO vo) {
		return map.orderList(vo);
	}
	
	// 사진 불러오기
	@Override
	public List<PhotoVO> photoList(PhotoVO vo) {
		return map.photoList(vo);
	}
	
	// 작성 게시글 조회
	@Override
	public List<BoardVO> boardSelectList(int boardNo, int userNo, String category) {
		return null;
	}

	// 작성 댓글 조회
	@Override
	public List<CommentVO> commentSelectList(int commentNo, int userNo, String category) {
		return null;
	}

	// 내 스크랩 내역 조회
	@Override
	public List<ScrapVO> scrapSelectList(int boardNo, int userNo, String category) {
		return null;
	}

	// 장바구니 조회
	@Override
	public List<CartVO> cartList(CartVO vo) {
		return map.cartList(vo);
	}

	// 수강 내역 조회
	@Override
	public List<ClassVO> classList(ClassReserveVO vo) {
		return map.classList(vo);
	}

	

}

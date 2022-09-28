package com.team.prj.join.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.team.prj.seller.service.SellerVO;
import com.team.prj.tutor.service.TutorVO;
import com.team.prj.users.service.UsersVO;

public interface JoinService {
	
	
	// 일반 회원 등록
	int usersInsert(UsersVO vo);
	
	List<UsersVO> usersList(); // 전체 회원 리스트
	String stateUpdate(UsersVO vo); // 회원 상태 수정
	//UsersVO usersSelect(UsersVO vo); // 회원 단건 상세조회
	
	
	List<TutorVO> tutorList(); // 전체 튜터 리스트
	String stateUpdate(TutorVO vo); // 튜터 상태 수정
//	TutorVO tutorSelect(TutorVO vo); // 튜터 단건 상세조회
	
	
	List<SellerVO> sellerList(); // 전체 판매자 리스트
	String stateUpdate(SellerVO vo); // 판매자 상태 수정
//	SellerVO sellerSelect(SellerVO vo); // 판매자 단건 상세조회
	
	

	int idCheck(String id); // id 중복체크	
	int nickCheck(String nickname); // 닉네임 중복체크
	
	
	// company 중복체크 만들어야함 - 튜터, 판매자

}

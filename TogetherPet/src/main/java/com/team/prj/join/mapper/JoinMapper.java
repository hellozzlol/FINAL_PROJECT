package com.team.prj.join.mapper;


import com.team.prj.seller.service.SellerVO;
import com.team.prj.tutor.service.TutorVO;
import com.team.prj.users.service.UsersVO;

public interface JoinMapper {
	
	
	int usersInsert(UsersVO vo); // 일반 회원 등록
	
	int tutorInsert(TutorVO vo); // 튜터 회원 등록
	
	int sellerInsert(SellerVO vo); // 판매자 회원 등록
	
	
	String stateUpdate(UsersVO vo); // 회원 상태 수정
	
	String stateUpdate(TutorVO vo); // 튜터 상태 수정
	
	String stateUpdate(SellerVO vo); // 판매자 상태 수정
	
	
	int idCheck(String id); // 일반회원 id 중복체크
	int tCheck(String id); // 튜터회원 id 중복체크
	int sCheck(String id); // 판매자회원 id 중복체크
	
	int nickCheck(String nickname); // 닉네임 중복체크
	

}

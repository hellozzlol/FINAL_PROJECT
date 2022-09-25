package com.team.prj.mem.service;

import java.util.List;

import com.team.prj.seller.service.SellerVO;
import com.team.prj.tutor.service.TutorVO;
import com.team.prj.users.service.UsersVO;

public interface MemService {
	List<UsersVO> usersList(); // 전체 회원 리스트
	UsersVO usersSelect(UsersVO vo); // 회원 단건 상세조회
	
	String stateUpdate(UsersVO vo); // 회원 상태 수정
	
	
	
//	List<TutorVO> tutorList(); // 전체 튜터 리스트
//	TutorVO tutorSelect(TutorVO vo); // 튜터 단건 상세조회
//	
//	
//	List<SellerVO> sellerList(); // 전체 판매자 리스트
//	SellerVO sellerSelect(SellerVO vo); // 판매자 단건 상세조회
//	
//
//	String stateUpdate(TutorVO vo); // 튜터 상태 수정
//	String stateUpdate(SellerVO vo); // 판매자 상태 수정
	
}

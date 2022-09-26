package com.team.prj.mem.mapper;

import java.util.List;

import com.team.prj.seller.service.SellerVO;
import com.team.prj.tutor.service.TutorVO;
import com.team.prj.users.service.UsersVO;

public interface MemMapper {

	List<UsersVO> usersList(); // 전체 회원 리스트
	UsersVO usersSelect(UsersVO vo); // 회원 단건 상세조회
	
	String stateUpdate(UsersVO vo); // 회원 상태 수정
	
	
}

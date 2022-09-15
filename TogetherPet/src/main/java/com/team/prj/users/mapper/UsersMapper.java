package com.team.prj.users.mapper;

import java.util.List;

import com.team.prj.users.service.UsersVO;

public interface UsersMapper {
	// 전체 리스트
	List<UsersVO> findAll();
	
	// 단건 조회
	UsersVO usersSelect(UsersVO vo);
	
	// 등록
	int usersInsert(UsersVO vo);
	
	// 수정
	int usersUpdate(UsersVO vo);
	
	// 삭제
	int usersDelete(UsersVO vo);
	
}

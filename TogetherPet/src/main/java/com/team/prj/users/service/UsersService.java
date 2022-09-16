package com.team.prj.users.service;

import java.util.List;

public interface UsersService {
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
}

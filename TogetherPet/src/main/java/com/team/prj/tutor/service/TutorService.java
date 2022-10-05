package com.team.prj.tutor.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.team.prj.users.service.UsersVO;

public interface TutorService {
	List<TutorVO> tutorSelectList();
	TutorVO tutorSelect(TutorVO vo);
	int tutorInsert(TutorVO vo);
	int tutorUpdate(TutorVO vo);
	int tutorDelete(TutorVO vo);
	
	// 튜터회원 검색 / 1005 지혜 추가
	List<TutorVO> tutorSearch(@Param("key")String key, @Param("val") String val);

}

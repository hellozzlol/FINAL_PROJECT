package com.team.prj.tutor.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.team.prj.tutor.service.TutorVO;

public interface TutorMapper {
	List<TutorVO> tutorSelectList();
	TutorVO tutorSelect(TutorVO vo);
	int tutorInsert(TutorVO vo);
	int tutorUpdate(TutorVO vo);
	int tutorDelete(TutorVO vo);
	
	// 튜터회원 검색 / 1005 지혜 추가
	List<TutorVO> tutorSearch(@Param("key")String key, @Param("val") String val);

}

package com.team.prj.tutor.mapper;

import java.util.List;

import com.team.prj.tutor.service.TutorVO;

public interface TutorMapper {
	List<TutorVO> tutorSelectList();
	TutorVO tutorSelect(TutorVO vo);
	int tutorInsert(TutorVO vo);
	int tutorUpdate(TutorVO vo);
	int tutorDelete(TutorVO vo);
}

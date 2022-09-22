package com.team.prj.tutor.service;

import java.util.List;

public interface TutorService {
	List<TutorVO> tutorSelectList();
	TutorVO tutorSelect(TutorVO vo);
	int tutorInsert(TutorVO vo);
	int tutorUpdate(TutorVO vo);
	int tutorDelete(TutorVO vo);
}

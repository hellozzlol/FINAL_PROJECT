package com.team.prj.tutor.service;

import java.util.List;

import com.team.prj.classes.service.ClassVO;

public interface TutorService {
	List<TutorVO> tutorSelectList();
	
	//튜터 단건조회
	TutorVO tutorMyPage(TutorVO vo);
	
	//튜터정보 등록
	int tutorInsert(TutorVO vo);
	
	//튜터정보 수정
	int tutorUpdate(TutorVO vo);
	
	int tutorDelete(TutorVO vo);
	
	//튜터가 생성한 클래스 조회
	List<ClassVO> myClassList(ClassVO vo);
	
}

package com.team.prj.tutor.service;

import java.util.List;


import org.apache.ibatis.annotations.Param;

import com.team.prj.admin.service.ProfitVO;
import com.team.prj.classes.service.ClassOptionVO;
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
	

	// 튜터회원 검색 / 1005 지혜 추가
	List<TutorVO> tutorSearch(@Param("key")String key, @Param("val") String val);


	//튜터가 생성한 클래스 조회
	List<ClassVO> myClassList(ClassVO vo);
	
	//특정 클래스 옵션 리스트
	List<ClassOptionVO> classOptionList(int classNo);
	
	//특정 클래스 옵션의 예약자 조회
	List<ClassOptionVO> optionReserv(int classOptionNo);
	
	//정산내역조회
	List<ProfitVO> tutorProfitList(@Param("tvo") TutorVO tvo, @Param("key") String key);
	

}

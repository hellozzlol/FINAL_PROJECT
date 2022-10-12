package com.team.prj.classes.service;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.team.prj.photo.service.PhotoVO;
import com.team.prj.review.service.ReviewVO;
import com.team.prj.tutor.service.TutorVO;

public interface ClassService {
	List<ClassVO> classSelectList(); //클래스 목록
	ClassVO classSelect(ClassVO vo); //클래스 단건조회
	int classInsert(ClassVO vo); //클래스 입력
	int classUpdate(ClassVO vo); //클래스 수정
	int classDelete(ClassVO vo); //클래스 삭제
	List<ClassVO> classSearch(ClassVO vo); //클래스 검색
	List<PhotoVO> classPhotoList(ClassVO vo);//클래스 상단 그룹사진 불러오기
	
	//클래스 단건조회에서 리뷰 리스트
	List<ReviewVO> classReviewSelectList(ClassVO vo);
	
	//클래스 단건조회에서 리뷰 입력 후 닉네임 포함된 단건 재조회 
	ReviewVO classReviewSelect(ReviewVO vo);
	
	//클래스 단건조회에서 옵션 리스트
	List<ClassOptionVO> classOptionList(ClassVO vo);

	//클래스 단건조회에서 튜터 단건조회
	TutorVO tutorSelect(ClassVO vo);
	
	//클래스 단건조회에서 캘린더 날짜 옵션픽
	List<ClassOptionVO> classDateOption(String sdate, int no);
	
	// 클래스 조회(state=0 (미 승인) 1004 추가 / 지혜)
	List<ClassVO> classList(); 

	//최신 그룹넘버 조회
	int getGroupNo();

	//클래스 옵션 리스트 인서트
	List<Map<String,Object>> classOptionInsert(HashMap<String,Object> maps);

	//그룹사진 리스트 인서트
	List<Map<String,Object>> classPhotoInsert(HashMap<String,Object> maps);

}

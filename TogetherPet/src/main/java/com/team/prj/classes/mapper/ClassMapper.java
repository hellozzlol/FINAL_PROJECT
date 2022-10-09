package com.team.prj.classes.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import com.team.prj.classes.service.ClassOptionVO;
import com.team.prj.classes.service.ClassVO;
import com.team.prj.photo.service.PhotoVO;

public interface ClassMapper {
	List<ClassVO> classSelectList(); //클래스 목록
	ClassVO classSelect(ClassVO vo); //클래스 단건조회
	int classInsert(ClassVO vo); //클래스 입력
	//ClassVO classInsert(ClassVO vo); //클래스 입력
	ClassVO classUpdate(ClassVO vo); //클래스 수정
	int classDelete(ClassVO vo); //클래스 삭제
	List<ClassVO> classSearch(ClassVO vo); //클래스 검색
	List<PhotoVO> classPhotoList(ClassVO vo);//클래스 상단 그룹사진 불러오기
	
	
	//클래스 단건조회에서 날짜픽
	List<ClassOptionVO> classDateOption(String sdate, int no);
	
	//최신 그룹넘버 조회
	int getGroupNo();
	
	//클래스 옵션 리스트 인서트
	List<Map<String,Object>> classOptionInsert(HashMap<String,Object> maps);

	//그룹사진 리스트 인서트
	List<Map<String,Object>> classPhotoInsert(HashMap<String,Object> maps);
	
	
	// 클래스 조회(state=0 (미 승인) 1004 추가 / 지혜)
	List<ClassVO> classList(); 
}

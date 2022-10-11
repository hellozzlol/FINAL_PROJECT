package com.team.prj.classes.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.team.prj.classes.mapper.ClassMapper;
import com.team.prj.photo.service.PhotoVO;
import com.team.prj.review.service.ReviewVO;
import com.team.prj.tutor.service.TutorVO;

@Service
public class ClassServiceImpl implements ClassService {
	@Autowired
	private ClassMapper map;

	@Override
	public List<ClassVO> classSelectList() {
		//클래스 리스트
		return map.classSelectList();
	}

	@Override
	public ClassVO classSelect(ClassVO vo) {
		//클래스 단건조회
		return map.classSelect(vo);
	}


	@Override
	public int classInsert(ClassVO vo) {
		//클래스 입력
		return map.classInsert(vo);
	}


	@Override
	public ClassVO classUpdate(ClassVO vo) {
		//클래스 수정
		return map.classUpdate(vo);
	}


	@Override
	public int classDelete(ClassVO vo) {
		//클래스 삭제
		return 0;
	}

	@Override
	public List<ClassVO> classSearch(ClassVO vo) {
		//ajax 클래스 리스트 검색
		return map.classSearch(vo);
	}

	@Override
	public List<ClassOptionVO> classDateOption(String sdate, int no) {
		//ajax 클래스 단건조회 페이지에서 날짜 선택
		return map.classDateOption(sdate, no);
	}

	@Override
	public List<PhotoVO> classPhotoList(ClassVO vo) {
		//클래스 group사진 리스트
		return map.classPhotoList(vo);
	}


	// 클래스 조회(state=0 (미 승인) 1004 추가 / 지혜)
	@Override
	public List<ClassVO> classList() {
		// TODO Auto-generated method stub
		return map.classList();
	}


	@Override
	public List<Map<String, Object>> classOptionInsert(HashMap<String, Object> maps) {
		//클래스 날짜 옵션 인서트
		return map.classOptionInsert(maps);
	}

	@Override
	public List<Map<String, Object>> classPhotoInsert(HashMap<String, Object> maps) {
		//그룹사진 리스트 인서트
		return map.classPhotoInsert(maps);
	}

	@Override
	public int getGroupNo() {
		//그룹넘버 조회
		return map.getGroupNo();
	}

	@Override
	public TutorVO tutorSelect(ClassVO vo) {
		//클래스 단건조회에서 튜터 단건조회
		return map.tutorSelect(vo);
	}

	@Override
	public List<ReviewVO> classReviewSelectList(ClassVO vo) {
		//클래스 단건조회에서 리뷰 리스트
		return map.classReviewSelectList(vo);
	}

	@Override
	public ReviewVO classReviewSelect(ReviewVO vo) {
		//클래스 단건조회에서 리뷰 입력 후 닉네임 포함된 단건 재조회 
		return map.classReviewSelect(vo);
	}

	@Override
	public List<ClassOptionVO> classOptionList(ClassVO vo) {
		//클래스 단건조회에서 옵션 리스트 (옵션 있는 날짜만 캘린더에 지정용)
		return map.classOptionList(vo);
	}






}

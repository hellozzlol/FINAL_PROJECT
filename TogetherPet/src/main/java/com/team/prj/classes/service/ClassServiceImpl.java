package com.team.prj.classes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.prj.classes.mapper.ClassMapper;

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
		// TODO Auto-generated method stub
		return map.classInsert(vo);
	}

	@Override
	public int classUpdate(ClassVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int classDelete(ClassVO vo) {
		// TODO Auto-generated method stub
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

//	@Override
//	public List<ClassVO> classSearch(String[] categories, String[] addresses, String searchkey, String searchval) {
//		// TODO Auto-generated method stub
//		return null;
//	}

}

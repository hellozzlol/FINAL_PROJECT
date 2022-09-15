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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int classInsert(ClassVO vo) {
		// TODO Auto-generated method stub
		return 0;
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

}

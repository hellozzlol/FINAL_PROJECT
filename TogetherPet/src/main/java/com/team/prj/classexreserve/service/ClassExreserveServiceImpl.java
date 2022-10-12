package com.team.prj.classexreserve.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.prj.classexreserve.mapper.ClassExreserveMapper;

@Service
public class ClassExreserveServiceImpl implements ClassExreserveService {
	@Autowired
	private ClassExreserveMapper map;
	
	@Override
	public List<ClassExreserveVO> exreserveList(ClassExreserveVO vo) {
		// TODO Auto-generated method stub
		return  map.exreserveList(vo);
	}

	@Override
	public ClassExreserveVO classExreserveSelect(int exreserveNo) {
		// TODO Auto-generated method stub
		return map.classExreserveSelect(exreserveNo);
	}

	@Override
	public int classExreserveInsert(ClassExreserveVO vo) {
		// TODO Auto-generated method stub
		return map.classExreserveInsert(vo);
	}

	@Override
	public int classExreserveDelete(ClassExreserveVO vo) {
		// TODO Auto-generated method stub
		return map.classExreserveDelete(vo);
	}



}

package com.team.prj.admin.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.prj.admin.mapper.hitTableMapper;

@Service
public class hitTableServiceImpl implements hitTableService {
	@Autowired
	private hitTableMapper map;

	// 조회수 그래프
	@Override
	public List<hitTableVO> hitList(hitTableVO vo) throws Exception {
		return map.hitList(vo);
	}

	// 조회수 테이블(게시판별 조회수 합산)
	@Override
	public List<hitTableVO> hitAll(hitTableVO vo) {
		return map.hitAll(vo);
	}
	
	// 조회수 테이블(게시판별 최고 조회수)
	@Override
	public List<hitTableVO> hitTable(hitTableVO vo) {
		return map.hitTable(vo);
	}
	
}

package com.team.prj.admin.service;

import java.util.List;
import java.util.Map;

// 1014 선희 추가(조회수 통계)
public interface hitTableService {
	// 조회수 그래프
	List<hitTableVO> hitList(hitTableVO vo) throws Exception;
	
	// 조회수 테이블(게시판별 조회수 합산)
	List<hitTableVO> hitAll(hitTableVO vo);
	
	// 조회수 테이블(게시판별 최고 조회수)
	List<hitTableVO> hitTable(hitTableVO vo);
}

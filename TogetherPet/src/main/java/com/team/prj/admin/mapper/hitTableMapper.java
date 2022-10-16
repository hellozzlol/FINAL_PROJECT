package com.team.prj.admin.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.team.prj.admin.service.hitTableVO;

//1014 선희 추가(조회수 통계)
public interface hitTableMapper {
	// 조회수 그래프
	List<hitTableVO> hitList(hitTableVO vo) throws Exception;

	// 조회수 테이블(게시판별 조회수 합산)
	List<hitTableVO> hitAll(hitTableVO vo);

	// 조회수 테이블(게시판별 최고 조회수)
	List<hitTableVO> hitTable(hitTableVO vo);

}

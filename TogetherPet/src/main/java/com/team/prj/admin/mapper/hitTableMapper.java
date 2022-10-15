package com.team.prj.admin.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.team.prj.admin.service.hitTableVO;

//1014 선희 추가(조회수 통계)
public interface hitTableMapper {
	List<hitTableVO> hitList(hitTableVO vo) throws Exception;

}

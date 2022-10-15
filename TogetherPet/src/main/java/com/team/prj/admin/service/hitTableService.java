package com.team.prj.admin.service;

import java.util.List;
import java.util.Map;

// 1014 선희 추가(조회수 통계)
public interface hitTableService {
	List<hitTableVO> hitList(hitTableVO vo) throws Exception;
}

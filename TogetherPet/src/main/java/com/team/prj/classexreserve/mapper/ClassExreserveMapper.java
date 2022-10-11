package com.team.prj.classexreserve.mapper;

import java.util.List;

import com.team.prj.classexreserve.service.ClassExreserveVO;

public interface ClassExreserveMapper {
	
	List<ClassExreserveVO> exreserveList(ClassExreserveVO vo);
	
	ClassExreserveVO classExreserveSelect(int exreserveNo);
	
	int classExreserveInsert(ClassExreserveVO vo);
	
	int classExreserveDelete(ClassExreserveVO vo);
}

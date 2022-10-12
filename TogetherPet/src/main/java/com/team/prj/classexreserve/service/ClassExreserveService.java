package com.team.prj.classexreserve.service;

import java.util.List;

public interface ClassExreserveService {
	
	List<ClassExreserveVO> exreserveList(ClassExreserveVO vo);
	
	ClassExreserveVO classExreserveSelect(int exreserveNo);
	
	int classExreserveInsert(ClassExreserveVO vo);
	
	int classExreserveDelete(ClassExreserveVO vo);
	
}

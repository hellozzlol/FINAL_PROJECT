package com.team.prj.accomo.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface accomoService {

	List<accomoVO> accomoSelectList();

	accomoVO accomoSelect(accomoVO vo);

	int accomoInsert(accomoVO vo);

	int accomoUpdate(accomoVO vo);

	int accomoDelete(accomoVO vo);
	
	//조회수 증가
	int accomoHitUpdate(accomoVO vo);
	
	//검색기능
	
	List<accomoVO> accomoSearch(@Param("key")String key, @Param("val") String val);

}

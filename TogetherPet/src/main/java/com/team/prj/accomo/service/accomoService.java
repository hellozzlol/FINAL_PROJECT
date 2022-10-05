package com.team.prj.accomo.service;

import java.util.List;



public interface accomoService {

	

	accomoVO accomoSelect(accomoVO vo);

	int accomoInsert(accomoVO vo);

	int accomoUpdate(accomoVO vo);

	int accomoDelete(accomoVO vo);
	
	//조회수 증가
	int accomoHitUpdate(accomoVO vo);
	
	//검색기능	
	List<accomoVO> accomoSearch(String key,String val);

	List<accomoVO> accomoSelectList(String key);

}

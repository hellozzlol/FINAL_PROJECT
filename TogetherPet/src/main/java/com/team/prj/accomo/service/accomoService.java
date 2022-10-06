package com.team.prj.accomo.service;

import java.util.List;

import com.team.prj.scrap.service.ScrapVO;



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
	
	//소현 스크랩 기능추가 1006
	 int scrapInsert(ScrapVO vo);//20221005소현추가

}

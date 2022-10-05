package com.team.prj.scrap.service;

import java.util.List;

public interface ScrapService {
	List<ScrapVO> scrapSelectList();
	
	ScrapVO scrapSelect(ScrapVO vo);//20221005소현추가

	int scrapDelete(ScrapVO vo);//20221005소현추가

	int scrapInsert(ScrapVO vo);//20221005소현추가

	int scrapCount(ScrapVO vo);//20221005소현추가
	
	

	
}

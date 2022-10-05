package com.team.prj.scrap.mapper;

import java.util.List;

import com.team.prj.scrap.service.ScrapVO;

public interface ScrapMapper {
	List<ScrapVO> scrapSelectList();

	ScrapVO scrapSelect(ScrapVO vo);

	int scrapDelete(ScrapVO vo); //20221005소현추가
	
	int scrapInsert(ScrapVO vo);//20221005소현추가
	
	int scrapCount(ScrapVO vo);//20221005소현추가
	
	
	
	
}

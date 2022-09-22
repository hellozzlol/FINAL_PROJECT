package com.team.prj.scrap.service;

import java.util.List;

public interface ScrapService {
	List<ScrapVO> scrapSelectList();
	
	ScrapVO scrapSelect(ScrapVO vo);
	
	int scrapDelete(ScrapVO vo);
}

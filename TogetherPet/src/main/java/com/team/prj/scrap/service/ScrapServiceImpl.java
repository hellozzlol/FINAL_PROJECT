package com.team.prj.scrap.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.prj.scrap.mapper.ScrapMapper;

@Service
public class ScrapServiceImpl implements ScrapService {
	@Autowired
	private ScrapMapper map;

	@Override
	public List<ScrapVO> scrapSelectList() {
		return map.scrapSelectList();
	}

	@Override
	public ScrapVO scrapSelect(ScrapVO vo) {
		return map.scrapSelect(vo);
	}

	@Override
	public int scrapDelete(ScrapVO vo) {
		return map.scrapDelete(vo);
	}
}

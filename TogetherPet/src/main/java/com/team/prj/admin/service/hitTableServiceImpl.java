package com.team.prj.admin.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.prj.admin.mapper.hitTableMapper;

@Service
public class hitTableServiceImpl implements hitTableService {
	@Autowired
	private hitTableMapper map;

	@Override
	public List<hitTableVO> hitList(hitTableVO vo) throws Exception {
		return map.hitList(vo);
	}

}

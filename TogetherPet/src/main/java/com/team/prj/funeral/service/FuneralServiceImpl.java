package com.team.prj.funeral.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.prj.funeral.mapper.FuneralMapper;

@Service
public class FuneralServiceImpl implements FuneralService {
	@Autowired
	FuneralMapper map;

	
	@Override
	public List<FuneralVO> findAll() {
		// 장례리스트
		return map.findAll();
	}

	@Override
	public FuneralVO funeralSelect(FuneralVO vo) {
		// 장례상세보기
		return map.funeralSelect(vo);
	}

	@Override
	public int funeralInsert(FuneralVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int funeralUpdate(FuneralVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int funeralDelete(FuneralVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

}

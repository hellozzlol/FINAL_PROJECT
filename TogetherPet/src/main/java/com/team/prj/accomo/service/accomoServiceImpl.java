package com.team.prj.accomo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.prj.accomo.mapper.accomoMapper;

@Service
public class accomoServiceImpl implements accomoService {

	@Autowired
	private accomoMapper map;
		
	

	@Override
	public accomoVO accomoSelect(accomoVO vo) {
		// 숙소상세보기
		return map.accomoSelect(vo);
	}

	@Override
	public int accomoInsert(accomoVO vo) {
		// 숙소추가
		return map.accomoInsert(vo);
	}

	@Override
	public int accomoUpdate(accomoVO vo) {
		// 숙소수정
		return map.accomoUpdate(vo);
	}

	@Override
	public int accomoDelete(accomoVO vo) {
		// 숙소삭제
		return map.accomoDelete(vo);
	}

	@Override
	public int accomoHitUpdate(accomoVO vo) {
		// 조회수
		return map.accomoHitUpdate(vo);
	}

	@Override
	public List<accomoVO> accomoSearch(String key, String val) {
		// 검색
		return map.accomoSearch(key, val);
	}

	@Override
	public List<accomoVO> accomoSelectList(String key) {
		// 리스트조회
		return map.accomoSelectList(key);
	}

}

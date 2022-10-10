package com.team.prj.funeral.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.prj.funeral.mapper.FuneralMapper;
import com.team.prj.review.service.ReviewVO;
import com.team.prj.scrap.service.ScrapVO;


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

	@Override
	public int scrapInsert(ScrapVO vo) {
		// 소현 스크랩 기능 추가 20221007
		return map.scrapInsert(vo);
	}

	
	//소현 별점리뷰 기능 추가 20221008
	@Override
	public List<ReviewVO> funeralreviewSelectList(FuneralVO vo) {
		// 20221010 장례리뷰리스트
		return map.funeralreviewSelectList(vo);
	}

	@Override
	public ReviewVO funeralreviewSelect(ReviewVO vo) {
		// 20221010 장례리뷰단건
		return map.funeralreviewSelect(vo);
	}

	@Override
	public int reviewInsert(ReviewVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int reviewUpdate(ReviewVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int reviewDelete(ReviewVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	
	
		
}

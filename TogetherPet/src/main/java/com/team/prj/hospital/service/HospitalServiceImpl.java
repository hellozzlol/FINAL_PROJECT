package com.team.prj.hospital.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.prj.hospital.mapper.HospitalMapper;
import com.team.prj.review.service.ReviewVO;
import com.team.prj.scrap.service.ScrapVO;

@Service
public class HospitalServiceImpl implements HospitalService {
	@Autowired
	private HospitalMapper map;
	
	@Override
	public HospitalVO hospitalSelect(HospitalVO vo) {
		return map.hospitalSelect(vo);
	}

	@Override
	public int hospitalInsert(HospitalVO vo) {
		return map.hospitalInsert(vo);
	}

	@Override
	public int hospitalUpdate(HospitalVO vo) {
		return map.hospitalUpdate(vo);
	}

	@Override
	public int hospitalDelete(HospitalVO vo) {
		return map.hospitalDelete(vo);
	}

	@Override
	public int hospitalHitUpdate(HospitalVO vo) {
		// 조회수
		return map.hospitalHitUpdate(vo);
	}

	@Override
	public List<HospitalVO> hospitalSearch(String key, String val) {
		// 검색
		return map.hospitalSearch(key, val);
	}

	@Override
	public List<HospitalVO> hospitalSelectList(String key) {
		// 리스트 조회
		return map.hospitalSelectList(key);
	}

	@Override
	public int scrapInsert(ScrapVO vo) {
		// 소현 스크랩 기능 추가 20221006
		return map.scrapInsert(vo);
	}

	@Override
	public List<ReviewVO> reviewSelectList(ReviewVO vo) {
		// 병원리뷰리스트
		return map.reviewSelectList(vo);
	}

	@Override
	public ReviewVO reviewSelect(ReviewVO vo) {
		// 리뷰상세보기
		return map.reviewSelect(vo);
	}

	@Override
	public int reviewInsert(ReviewVO vo) {
		// 리뷰등록
		return map.reviewInsert(vo);
	}

	@Override
	public int reviewUpdate(ReviewVO vo) {
		// 리뷰수정
		return map.reviewUpdate(vo);
	}

	@Override
	public int reviewDelete(ReviewVO vo) {
		// 리뷰삭제
		return map.reviewDelete(vo);
	}

}

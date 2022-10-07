package com.team.prj.review.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.team.prj.review.mapper.ReviewMapper;

public class ReviewServiceImpl implements ReviewService{

	@Autowired
	private ReviewMapper map;

	@Override
	public List<ReviewVO> reviewSelectList() {
		// 리뷰리스트
		return map.reviewSelectList();
	}

	@Override
	public ReviewVO reviewSelect(ReviewVO vo) {
		// 리뷰단건조회
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

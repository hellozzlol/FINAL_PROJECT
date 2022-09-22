package com.team.prj.like.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.prj.like.mapper.LikesMapper;

@Service
public class LikesServiceImpl implements LikesService {
	@Autowired
	private LikesMapper map;
	
	@Override
	public List<LikesVO> likeSelectList() {
		return map.likeSelectList();
	}

	@Override
	public LikesVO likeSelect(LikesVO vo) {
		return map.likeSelect(vo);
	}

	@Override
	public int likeInsert(LikesVO vo) {
		return map.likeInsert(vo);
	}

	@Override
	public int likeUpdate(LikesVO vo) {
		return map.likeUpdate(vo);
	}

	@Override
	public int likeDelete(LikesVO vo) {
		return map.likeDelete(vo);
	}

}

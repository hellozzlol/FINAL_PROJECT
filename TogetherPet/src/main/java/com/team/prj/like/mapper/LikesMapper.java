package com.team.prj.like.mapper;

import java.util.List;

import com.team.prj.like.service.LikesVO;

public interface LikesMapper {
	List<LikesVO> likeSelectList();

	LikesVO likeSelect(LikesVO vo);

	int likeInsert(LikesVO vo);

	int likeUpdate(LikesVO vo);

	int likeDelete(LikesVO vo);
}

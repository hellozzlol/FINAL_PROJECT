package com.team.prj.like.service;

import java.util.List;

public interface LikesService {
	List<LikesVO> likeSelectList();
	
	LikesVO likeSelect(LikesVO vo);
	
	int likeInsert(LikesVO vo);
	
	int likeUpdate(LikesVO vo);
	
	int likeDelete(LikesVO vo);
}

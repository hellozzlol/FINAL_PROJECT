package com.team.prj.comment.service;

import java.util.List;

public interface CommentService {
	List<CommentVO> commentSelectList();
	
	CommentVO commentSelect(CommentVO vo);
	
	int commentInsert(CommentVO vo);
	
	int commentUpdate(CommentVO vo);
	
	int commentDelete(CommentVO vo);
}

package com.team.prj.comment.mapper;

import java.util.List;

import com.team.prj.comment.service.CommentVO;

public interface CommentMapper {
	List<CommentVO> commentSelectList();

	CommentVO commentSelect(CommentVO vo);

	int commentInsert(CommentVO vo);

	int commentUpdate(CommentVO vo);

	int commentDelete(CommentVO vo);
}

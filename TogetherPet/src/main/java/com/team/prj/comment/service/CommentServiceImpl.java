package com.team.prj.comment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.prj.comment.mapper.CommentMapper;

@Service
public class CommentServiceImpl implements CommentService {
	@Autowired
	private CommentMapper map;
	
	@Override
	public List<CommentVO> commentSelectList() {
		return map.commentSelectList();
	}

	@Override
	public CommentVO commentSelect(CommentVO vo) {
		return map.commentSelect(vo);
	}

	@Override
	public int commentInsert(CommentVO vo) {
		return map.commentInsert(vo);
	}

	@Override
	public int commentUpdate(CommentVO vo) {
		return map.commentUpdate(vo);
	}

	@Override
	public int commentDelete(CommentVO vo) {
		return map.commentDelete(vo);
	}

}

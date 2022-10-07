package com.team.prj.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.team.prj.board.mapper.BoardMapper;
import com.team.prj.comment.service.CommentVO;
import com.team.prj.scrap.service.ScrapVO;


@Service
public class BoardServiceImpl implements BoardService {
	@Autowired
	private BoardMapper map;
	

	@Override
	public List<BoardVO> boardSelectList() {
		return map.boardSelectList();
	}

	@Override
	public BoardVO boardSelect(BoardVO vo) {
		return map.boardSelect(vo);
	}

	public int boardInsert(BoardVO vo) {
		return map.boardInsert(vo);
	}

	@Override
	public int boardUpdate(BoardVO vo) {
		return map.boardUpdate(vo);
	}

	@Override
	public int boardDelete(BoardVO vo) {
		return map.boardDelete(vo);
	}

	@Override
	public int boardHitUpdate(BoardVO vo) {
		
		return map.boardHitUpdate(vo);
	}

	@Override
	public List<BoardVO> boardSearch(String key, String val) {
		// 검색기능
		return map.boardSearch(key, val);
	}

	
	@Override
	public int commentInsert(CommentVO vo) {
		// 댓글입력
		return map.commentInsert(vo);
	}

	@Override
	public int commentUpdate(CommentVO vo) {
		// 댓글수정인데 수정은 안핼래
		return map.commentUpdate(vo);
	}

	@Override
	public int commentDelete(CommentVO vo) {
		// 댓글삭제
		return map.commentDelete(vo);
	}

	@Override
	public List<CommentVO> commentSelectList(CommentVO vo) {
		// TODO Auto-generated method stub
		return map.commentSelectList(vo);
	}


	

	

}

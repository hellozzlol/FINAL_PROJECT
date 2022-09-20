package com.team.prj.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.prj.board.mapper.BoardMapper;

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

	@Override
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

}

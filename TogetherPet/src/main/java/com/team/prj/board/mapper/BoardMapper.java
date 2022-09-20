package com.team.prj.board.mapper;

import java.util.List;

import com.team.prj.board.service.BoardVO;

public interface BoardMapper {
	List<BoardVO> boardSelectList();

	BoardVO boardSelect(BoardVO vo);

	int boardInsert(BoardVO vo);

	int boardUpdate(BoardVO vo);

	int boardDelete(BoardVO vo);
}

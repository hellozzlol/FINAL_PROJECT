package com.team.prj.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;


import com.team.prj.board.service.BoardVO;


public interface BoardMapper {
	List<BoardVO> boardSelectList();

	BoardVO boardSelect(BoardVO vo);

	int boardInsert(BoardVO vo);

	int boardUpdate(BoardVO vo);

	int boardDelete(BoardVO vo);
	
	//조회수 증가
	int boardHitUpdate(BoardVO vo);
		
	//검색기능
	List<BoardVO> boardSearch (@Param("key")String key, @Param("val") String val);
	
	/*
	 * //페이징 처리 List<BoardVO> findAll(BoardVO vo);
	 */
	
		
}

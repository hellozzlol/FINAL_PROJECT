package com.team.prj.board.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;





public interface BoardService {
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
		 * 
		 */
	
	
	
	
		
}

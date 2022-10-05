package com.team.prj.board.service;

import java.util.List;



import com.team.prj.comment.service.CommentVO;





public interface BoardService {
	List<BoardVO> boardSelectList();

	
	BoardVO boardSelect(BoardVO vo);
	
	int boardInsert(BoardVO vo);
	
	int boardUpdate(BoardVO vo);
	
	int boardDelete(BoardVO vo);
	
	//조회수 증가
	int boardHitUpdate(BoardVO vo);
	
	//검색기능
		List<BoardVO> boardSearch (String key,String val);

		
	
	//댓글기능
		List<CommentVO> commentSelectList (CommentVO vo);
		
		int commentInsert(CommentVO vo);
		
		int commentUpdate(CommentVO vo);
		
		int commentDelete(CommentVO vo);
		
		
	
	
		
}

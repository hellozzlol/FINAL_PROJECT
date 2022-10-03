package com.team.prj.board.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.team.prj.board.service.BoardService;
import com.team.prj.board.service.BoardVO;
import com.team.prj.comment.service.CommentService;
import com.team.prj.comment.service.CommentVO;
import com.team.prj.users.service.UsersService;

//@controller + @responseBody 합쳐진것 호출한페이지로 결과를돌려준다.
@RestController
public class BoardAjaxController {

	@Autowired
	private BoardService ajaxdao;
	
	@Autowired
	private UsersService user; // 개인회원
	
	
	
	@RequestMapping("/boardajaxSearch")
	@ResponseBody
	public List<BoardVO> ajaxSearch(String key, @RequestParam String val){
		return ajaxdao.boardSearch(key, val);
	}
	
		//댓글 등록
		@PostMapping(value="/commentInsert.do")
		@ResponseBody
		public int commentInsert(CommentVO vo) {
			
			return ajaxdao.commentInsert(vo);
		}
		
		//댓글 삭제 
		@RequestMapping("/commentDelete")
		public int commentDelete(CommentVO vo) {
			
			return ajaxdao.commentDelete(vo);
		}
	
	
	
}

package com.team.prj.board.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.team.prj.board.service.BoardService;
import com.team.prj.board.service.BoardVO;

@Controller
public class BoardController {
	@Autowired
	private BoardService dao;

	// 유저 게시판 전체 조회
	@GetMapping("/boardSelectList")
	public String boardSelectList(Model model) {
		model.addAttribute("boardList", dao.boardSelectList());
		return "users/boardSelectList";
	}

	// 유저 게시판 단건 조회
	@GetMapping("/boardSelect")
	public String boardSelect(BoardVO vo, Model model) {
		model.addAttribute("boardList", dao.boardSelect(vo));
		return "users/boardSelect";
	}
	
	//유저  글등록 폼 호출
	@RequestMapping("/boardForm")
	public String boardForm() {
		return "users/boardForm";
	}
	
	// 유저  글등록
	@PostMapping("/boardInsert")
	public String boardInsert() {
		return "redirect:boardSelectList";
	}
	
	
	
	/////////////////////이 밑으론 커뮤니티 //////////////////
	
	
	//커뮤니티게시판조회
	@GetMapping("/boardList")
	public String boardList(Model model) {
		model.addAttribute("boardList", dao.boardSelectList());
		return "board/boardList";
	}

	//커뮤니티게시판상세조회
		@GetMapping("/boardSel")
		public String boardselect(BoardVO vo, Model model) {
			model.addAttribute("boardSel",dao.boardSelect(vo));
			dao.boardHitUpdate(vo);//조회수증가
			return "board/boardSel";
		}
	
	//커뮤니티글쓰기폼호출
		@RequestMapping("/boardFom")
		public String boardform() {
			return "board/boardFom";
		}
	//커뮤니티 글 등록	
			
	
	/*
	 * @PostMapping("/boardInsert") public String boardInsart() { return
	 * "redirect:boardList"; }
	 */
		
	
}

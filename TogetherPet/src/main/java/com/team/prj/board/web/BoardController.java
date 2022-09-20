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

	// 게시판 전체 조회
	@GetMapping("/boardSelectList")
	public String boardSelectList(BoardVO vo, Model model) {
		model.addAttribute("boardList", dao.boardSelectList());
		return "users/boardSelectList";
	}

	// 게시판 단건 조회
	@GetMapping("/boardSelect")
	public String boardSelect(BoardVO vo, Model model) {
		model.addAttribute("boardList", dao.boardSelect(vo));
		return "users/boardSelect";
	}
	
	// 글등록 폼 호출
	@RequestMapping("/boardForm")
	public String boardForm() {
		return "users/boardForm";
	}
	
	// 글등록
	@PostMapping("/boardInsert")
	public String boardInsert() {
		return "redirect:boardSelectList";
	}
	
}

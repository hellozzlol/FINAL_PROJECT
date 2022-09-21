package com.team.prj.comment.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.team.prj.comment.service.CommentService;
import com.team.prj.comment.service.CommentVO;

@Controller
public class CommentController {
	@Autowired
	private CommentService dao;
	
	// 댓글 전체 조회
	@GetMapping("/commentSelectList")
	public String commentSelectList(CommentVO vo, Model model) {
		model.addAttribute("commentList", dao.commentSelectList());
		return "users/commentSelectList";
	}
	
}

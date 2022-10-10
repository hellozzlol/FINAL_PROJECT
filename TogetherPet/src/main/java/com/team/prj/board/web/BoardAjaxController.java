package com.team.prj.board.web;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;


import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.team.prj.board.service.BoardService;
import com.team.prj.board.service.BoardVO;

import com.team.prj.comment.service.CommentVO;
import com.team.prj.scrap.service.ScrapService;
import com.team.prj.scrap.service.ScrapVO;
import com.team.prj.users.service.UsersService;

//@controller + @responseBody 합쳐진것 호출한페이지로 결과를돌려준다.
@RestController
public class BoardAjaxController {

	@Autowired
	private BoardService Service;

	@Autowired
	private UsersService user; // 개인회원
	
	
	@Value("${file.dir}")
	private String fileDir;

	@RequestMapping("/boardajaxSearch")
	@ResponseBody
	public List<BoardVO> ajaxSearch(String key, @RequestParam String val) {
		return Service.boardSearch(key, val);
	}

	// 댓글 등록
	@PostMapping(value = "/commentInsert.do")
	@ResponseBody
	public int commentInsert(CommentVO vo) {

		return Service.commentInsert(vo);
	}

	// 댓글 삭제
	@PostMapping(value = "/commentDelete.do")
	@ResponseBody
	public int commentDelete(CommentVO vo) {
		vo.getCommentNo();
		return Service.commentDelete(vo);
	}
	
	// 댓글 리스트
	@RequestMapping("/commentSelectList.do")
	public List<CommentVO> commentList(CommentVO vo){
		return Service.commentSelectList(vo);
	}

	
		
			

}

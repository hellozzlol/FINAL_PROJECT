package com.team.prj.board.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.team.prj.board.service.BoardService;
import com.team.prj.board.service.BoardVO;

//@controller + @responseBody 합쳐진것 호출한페이지로 결과를돌려준다.
@RestController
public class BoardAjaxController {

	@Autowired
	private BoardService ajaxdao;
	
	@RequestMapping("/boardajaxSearch")
	@ResponseBody
	public List<BoardVO> ajaxSearch(String key, @RequestParam String val){
		return ajaxdao.boardSearch(key, val);
	}
	
	
	
}

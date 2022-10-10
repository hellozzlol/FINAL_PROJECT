package com.team.prj.qna.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.team.prj.notice.service.NoticeService;
import com.team.prj.notice.service.NoticeVO;
import com.team.prj.qna.service.QnaService;
import com.team.prj.qna.service.QnaVO;

@RestController
public class AjaxQnaController {
	@Autowired
	private QnaService dao;

	@RequestMapping("/ajaxQnaList")
	public List<QnaVO> qnaList(QnaVO vo) {
		return dao.selectQnaAll(vo);
	}

	@RequestMapping("/ajaxQnaSelect")
	public QnaVO qnaSelect(QnaVO vo) {
		return dao.selectQnaOne(vo);
	}

	@RequestMapping("/ajaxQnaInsert")
	public int qnaInsert(QnaVO vo) {
		System.out.println("??" + vo.getTitle());
		return dao.insertQna(vo);
	}

	@RequestMapping("/ajaxQnaDelete")
	public int qnaDelete(QnaVO vo) {
		return dao.deleteQna(vo);
	}

	@RequestMapping("/ajaxSelectNick")
	public String selectNick(QnaVO vo) {
		return dao.selectUserNick(vo);
	}

}

package com.team.prj.notice.web;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.team.prj.notice.service.NoticeService;
import com.team.prj.notice.service.NoticeVO;
import com.team.prj.users.service.UsersVO;

@RestController
public class AjaxNoticeController {
	@Autowired
	NoticeService notice;
	
	// 알림 페이지
	@RequestMapping("/noticeList")
	public List<NoticeVO> noticeList(NoticeVO vo, Model model, HttpSession session) {
		//UsersVO u = (UsersVO) session.getAttribute("user");
		//vo.setUserNo(u.getUserNo());
		System.out.println("==========" + vo.toString());
		return notice.noticeSelectList(vo);
	}
	
	// 알림 카운트
	@RequestMapping("/ajaxNoticeCount")
	public int ajaxNoticeCount(NoticeVO vo) {
		int cnt = notice.noticeCount(vo);
		return cnt;
	}
	
	// 알림 등록(0번 댓글, 1번 일정, 2번 문의, 3번 배송)
	@RequestMapping("/ajaxNoticeInsert")
	public int ajaxNoticeInsert(NoticeVO vo) {
		int noticeNo = vo.getNoticeNo();
		notice.noticeInsert(vo);
		return noticeNo;
	}
	
	// 알림 상태 수정(읽은시간)
//	@RequestMapping("/ajaxNoticeUpdate")
//	public int ajaxNoticeUpdate(NoticeVO vo) {
//		int cnt = notice.noticeUpdate(vo);
//		return cnt;
//	}

}

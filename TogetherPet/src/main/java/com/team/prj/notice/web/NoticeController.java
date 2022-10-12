package com.team.prj.notice.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.team.prj.notice.service.NoticeService;
import com.team.prj.notice.service.NoticeVO;

@Controller
public class NoticeController {
	@Autowired
	NoticeService notice;

	// 알림 상태 수정(읽은시간)
	@RequestMapping("/noticeUpdate")
	public int noticeUpdate(NoticeVO vo) {
		return notice.noticeUpdate(vo);
	}
}

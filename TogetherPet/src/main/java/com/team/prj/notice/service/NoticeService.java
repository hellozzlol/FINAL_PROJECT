package com.team.prj.notice.service;

import java.util.List;

public interface NoticeService {
	// 알림 전체 조회
	List<NoticeVO> noticeSelectList();
	
	// 알림 단건 조회
	NoticeVO noticeSelect(NoticeVO vo);
	
	// 알림 등록
	int noticeInsert(NoticeVO vo);
	
	// 알림 삭제
	int noticeDelete(NoticeVO vo);
	
	// 알림 수정
	int noticeUpdate(NoticeVO vo);
}

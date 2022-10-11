package com.team.prj.notice.mapper;

import java.util.List;

import com.team.prj.notice.service.NoticeVO;

public interface NoticeMapper {
	// 알림 조회
	List<NoticeVO> noticeSelectList(NoticeVO vo);

	// 알림 등록
	int noticeInsert(NoticeVO vo);

	// 알림 수정(상태 업데이트)
	int noticeUpdate(NoticeVO vo);

	// 알림 카운트
	int noticeCount(NoticeVO vo);
}

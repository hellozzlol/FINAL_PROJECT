package com.team.prj.notice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.team.prj.notice.mapper.NoticeMapper;

public class NoticeServiceImpl implements NoticeService {
	@Autowired
	NoticeMapper map;

	// 알림 전체 조회
	@Override
	public List<NoticeVO> noticeSelectList() {
		return map.noticeSelectList();
	}

	// 알림 단건 조회
	@Override
	public NoticeVO noticeSelect(NoticeVO vo) {
		return map.noticeSelect(vo);
	}

	// 알림 등록
	@Override
	public int noticeInsert(NoticeVO vo) {
		return map.noticeInsert(vo);
	}

	// 알림 삭제
	@Override
	public int noticeDelete(NoticeVO vo) {
		return map.noticeDelete(vo);
	}

	// 알림 수정
	@Override
	public int noticeUpdate(NoticeVO vo) {
		return map.noticeUpdate(vo);
	}

}

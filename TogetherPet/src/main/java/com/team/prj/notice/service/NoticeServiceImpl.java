package com.team.prj.notice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.prj.notice.mapper.NoticeMapper;

@Service
public class NoticeServiceImpl implements NoticeService {
	@Autowired
	NoticeMapper map;

	// 알림 전체 조회
	@Override
	public List<NoticeVO> noticeSelectList(NoticeVO vo) {
		return map.noticeSelectList(vo);
	}

	// 알림 등록
	@Override
	public int noticeInsert(NoticeVO vo) {
		return map.noticeInsert(vo);
	}

	// 알림 수정(상태 업데이트)
	@Override
	public int noticeUpdate(NoticeVO vo) {
		return map.noticeUpdate(vo);
	}

	// 알림 카운트
	@Override
	public int noticeCount(NoticeVO vo) {
		return map.noticeCount(vo);
	}

}

package com.team.prj.qna.service;

import java.util.List;

public interface QnaService {
	
	// 모두 조회
	List<QnaVO> selectQnaAll(QnaVO vo);
	
	// 단건 조회 - 상세보기
	QnaVO selectQnaOne(QnaVO vo);

	// 유저 닉네임
	String selectUserNick(QnaVO vo);
	// 등록
	int insertQna(QnaVO vo);
	// 삭제
	int deleteQna(QnaVO vo);
}

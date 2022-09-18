package com.team.prj.qna.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.team.prj.qna.service.QnaVO;

public interface QnaMapper {
	// 모두 조회
	List<QnaVO> selectQnaAll(QnaVO vo);

	// 단건 조회 - 상세보기
	QnaVO selectQnaOne(QnaVO vo);

	// 등록
	int insertQna(QnaVO vo);

	// 삭제
	int deleteQna(QnaVO vo);
	
	// 닉네임
	@Select("select nickname from users where user_no=#{userNo}")
	String selectUserNick(QnaVO vo);

}

package com.team.prj.visit.service;

import java.util.List;

public interface visitService {
	List<visitVO> visitSelectList(); // 유입경로 전체 목록
	
	visitVO visitSelect(visitVO vo);  // 단건 조회
	
	// 입력
	
}

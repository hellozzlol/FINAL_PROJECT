package com.team.prj.classreserve.service;

import java.util.List;

public interface ClassReserveService {
	List<ClassReserveVO> classReserveSelectList(); //클래스예약내역 목록
	int classReserveInsert(ClassReserveVO vo); //클래스예약 입력
	//int classReserveUpdate(ClassReserveVO vo); //클래스예약내역 수정 필요없음
	int classReserveDelete(ClassReserveVO vo); //클래스예약내역 삭제
}

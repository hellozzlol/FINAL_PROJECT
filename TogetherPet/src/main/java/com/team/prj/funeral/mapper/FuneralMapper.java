package com.team.prj.funeral.mapper;

import java.util.List;

import com.team.prj.funeral.service.FuneralVO;

public interface FuneralMapper {

	List<FuneralVO> findAll();//장례목록
	
	FuneralVO funeralSelect(FuneralVO vo); //장례 단건조회
	int funeralInsert(FuneralVO vo);// 장례 입력
	int funeralUpdate(FuneralVO vo);//장례수정
	int funeralDelete(FuneralVO vo);//장례 삭제
	
	
}

package com.team.prj.hospital.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface HospitalService {
	List<HospitalVO> hospitalSelectList();
	
	HospitalVO hospitalSelect(HospitalVO vo);
	
	int hospitalInsert(HospitalVO vo);
	
	int hospitalUpdate(HospitalVO vo);
	
	int hospitalDelete(HospitalVO vo);
	
	//조회수 증가
	int hospitalHitUpdate(HospitalVO vo);
	
	//검색기능(어떤내용이 들어있든 다 불러와라 내용도 마찬가지) 
	List<HospitalVO> hospitalSearch(@Param("key")String key, @Param("val") String val);
}

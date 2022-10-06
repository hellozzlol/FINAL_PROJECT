package com.team.prj.hospital.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.team.prj.scrap.service.ScrapVO;

public interface HospitalService {
	List<HospitalVO> hospitalSelectList(@Param("key") String key);

	HospitalVO hospitalSelect(HospitalVO vo);
	
	int hospitalInsert(HospitalVO vo);
	
	int hospitalUpdate(HospitalVO vo);
	
	int hospitalDelete(HospitalVO vo);
	
	//조회수 증가
	int hospitalHitUpdate(HospitalVO vo);
	
	//검색기능(어떤내용이 들어있든 다 불러와라 내용도 마찬가지) 
	List<HospitalVO> hospitalSearch(@Param("key")String key, @Param("val") String val);

	//소현 스크랩 기능추가 1006
	int scrapInsert(ScrapVO vo);//20221005소현추가
	
	
}

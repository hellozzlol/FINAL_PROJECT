package com.team.prj.hospital.service;

import java.util.List;

public interface HospitalService {
	List<HospitalVO> hospitalSelectList();
	
	HospitalVO hospitalSelect(HospitalVO vo);
	
	int hospitalInsert(HospitalVO vo);
	
	int hospitalUpdate(HospitalVO vo);
	
	int hospitalDelete(HospitalVO vo);
	
	//조회수 증가
	int hospitalHitUpdate(HospitalVO vo);
}

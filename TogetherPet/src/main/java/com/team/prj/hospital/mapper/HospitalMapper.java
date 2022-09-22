package com.team.prj.hospital.mapper;

import java.util.List;

import com.team.prj.hospital.service.HospitalService;
import com.team.prj.hospital.service.HospitalVO;

public interface HospitalMapper {
	List<HospitalVO> hospitalSelectList();

	HospitalVO hospitalSelect(HospitalVO vo);

	int hospitalInsert(HospitalVO vo);

	int hospitalUpdate(HospitalVO vo);

	int hospitalDelete(HospitalVO vo);
	//조회수 증가
	int hospitalHitUpdate(HospitalVO vo);
}

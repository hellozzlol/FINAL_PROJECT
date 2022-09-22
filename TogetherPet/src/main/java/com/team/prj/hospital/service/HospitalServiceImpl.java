package com.team.prj.hospital.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.prj.hospital.mapper.HospitalMapper;

@Service
public class HospitalServiceImpl implements HospitalService {
	@Autowired
	private HospitalMapper map;
	
	@Override
	public List<HospitalVO> hospitalSelectList() {
		return map.hospitalSelectList();
	}

	@Override
	public HospitalVO hospitalSelect(HospitalVO vo) {
		return map.hospitalSelect(vo);
	}

	@Override
	public int hospitalInsert(HospitalVO vo) {
		return map.hospitalInsert(vo);
	}

	@Override
	public int hospitalUpdate(HospitalVO vo) {
		return map.hospitalUpdate(vo);
	}

	@Override
	public int hospitalDelete(HospitalVO vo) {
		return map.hospitalDelete(vo);
	}

	@Override
	public int hospitalHitUpdate(HospitalVO vo) {
		// 조회수
		return map.hospitalHitUpdate(vo);
	}

}

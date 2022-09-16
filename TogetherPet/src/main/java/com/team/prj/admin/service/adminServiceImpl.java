package com.team.prj.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.prj.admin.service.mapper.adminMapper;
@Service
public class adminServiceImpl implements adminService {
	@Autowired
	private adminMapper map;
	
	@Override
	public List<adminVO> adminSelectList() {
		// 관리자 리스트
		return map.adminSelectList();
	}

	@Override
	public adminVO adminSelect(adminVO vo) {
		// 관리자 단건조회
		return null;
	}

	@Override
	public int adminUpdate(adminVO vo) {
		// 관리자 수정
		return 0;
	}

}

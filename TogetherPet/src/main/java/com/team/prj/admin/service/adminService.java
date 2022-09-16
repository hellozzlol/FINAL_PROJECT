package com.team.prj.admin.service;

import java.util.List;

public interface adminService {
	List<adminVO> adminSelectList(); // 관리자 목록?
	adminVO adminSelect(adminVO vo); // 관리자 단건조회
	int adminUpdate(adminVO vo); // 관리자 수정
	
}

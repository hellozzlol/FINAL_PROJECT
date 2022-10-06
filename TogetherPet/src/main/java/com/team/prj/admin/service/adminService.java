package com.team.prj.admin.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.team.prj.classes.service.ClassVO;
import com.team.prj.goods.service.GoodsVO;

public interface adminService {
	List<adminVO> adminSelectList(); // 관리자 목록
	adminVO adminSelect(adminVO vo); // 관리자 단건조회
	int adminUpdate(adminVO vo); // 관리자 수정
	
	int postUpdate(GoodsVO vo); // 상품 상태 업데이트
	int cpostUpdate(ClassVO vo); // 클래스 상태 업데이트
}

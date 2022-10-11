package com.team.prj.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.prj.admin.mapper.adminMapper;
import com.team.prj.classes.service.ClassVO;
import com.team.prj.goods.service.GoodsVO;
import com.team.prj.users.service.UsersVO;
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
		return map.adminSelect(vo);
	}

	@Override
	public int adminUpdate(adminVO vo) {
		// 관리자 수정
		return map.adminUpdate(vo);
	}

	@Override
	public int postUpdate(GoodsVO vo) {
		// 상품 상태 업데이트 - 승인
		return map.postUpdate(vo);
	}

	@Override
	public int cpostUpdate(ClassVO vo) {
		// 클래스 상태 업데이트 - 승인
		return map.cpostUpdate(vo);
	}

	@Override
	public int goodsRefuse(GoodsVO vo) {
		// 상품 상태 업데이트 - 반려
		return map.goodsRefuse(vo);
	}

	@Override
	public int classRefuse(ClassVO vo) {
		// 클래스 상태 업데이트 - 반려
		return map.classRefuse(vo);
	}

	@Override
	public int uStateUpdate(UsersVO vo) {
		// 일반회원 상태 업데이트
		return map.uStateUpdate(vo);
	}



}

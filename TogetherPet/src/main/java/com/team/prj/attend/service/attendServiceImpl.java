package com.team.prj.attend.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.prj.attend.mapper.attendMapper;


import java.util.HashMap;
import java.util.List;


@Service
public class attendServiceImpl implements attendService {
	@Autowired
	private attendMapper map;
	
	@Override
	public List<HashMap<String,Object>> attendSelectList(int ad_no) {
		// 근태 리스트 받아오기
		return map.attendSelectList(ad_no);
	}

	@Override
	public attendVO attendSelect(attendVO tvo) {
		// 출퇴근 시간 단건 조회
		return null;
	}

	@Override
	public attendVO attendUpdate(attendVO tvo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public attendVO attendInsert(attendVO tvo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertWorkIn(attendVO ato) {
		map.insertWorkIn(ato);
	}

	@Override
	public void updateWorkIn(attendVO ato) {
		map.updateWorkIn(ato);
	}

}

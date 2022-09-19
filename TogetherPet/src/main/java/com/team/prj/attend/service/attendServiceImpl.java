package com.team.prj.attend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.prj.attend.mapper.attendMapper;
@Service
public class attendServiceImpl implements attendService {
	@Autowired
	private attendMapper map;
	
	@Override
	public List<attendVO> attendSelectList(attendVO tvo) {
		// 출퇴근 시간 리스트..?
		return map.attendSelectList(tvo);
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

}

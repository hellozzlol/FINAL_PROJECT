package com.team.prj.mem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.prj.mem.mapper.MemMapper;
import com.team.prj.users.service.UsersVO;

@Service
public class MemServiceImpl implements MemService{
	@Autowired
	MemMapper mm;
	
	@Override
	public List<UsersVO> usersList() {
		return mm.usersList();
	}

	@Override
	public UsersVO usersSelect(UsersVO vo) {
		return mm.usersSelect(vo);
	}

	@Override
	public String stateUpdate(UsersVO vo) {
		return mm.stateUpdate(vo);
	}

}

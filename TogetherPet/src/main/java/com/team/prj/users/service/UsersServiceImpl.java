package com.team.prj.users.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.prj.users.mapper.UsersMapper;

@Service
public class UsersServiceImpl implements UsersService {
	@Autowired
	private UsersMapper map;
	
	@Override
	public List<UsersVO> usersSelectList() {
		return map.usersSelectList();
	}

	@Override
	public UsersVO usersSelect(UsersVO vo) {
		return map.usersSelect(vo);
	}

	@Override
	public int usersInsert(UsersVO vo) {
		return map.usersInsert(vo);
	}

	@Override
	public int usersUpdate(UsersVO vo) {
		return map.usersUpdate(vo);
	}

	@Override
	public int usersDelete(UsersVO vo) {
		return map.usersDelete(vo);
	}

}

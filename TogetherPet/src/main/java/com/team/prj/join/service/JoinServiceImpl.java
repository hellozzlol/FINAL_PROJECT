package com.team.prj.join.service;

import org.springframework.stereotype.Service;

@Service
public class JoinServiceImpl implements JoinService {

	@Override
	public int idCheck(String id) throws Exception {
		int result = idCheck(id);
		return result;
	}

	@Override
	public int emailCheck(String email) throws Exception {
		int result = emailCheck(email);
		return result;
	}

}

package com.team.prj.classreserve.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.prj.classes.service.ClassOptionVO;
import com.team.prj.classexreserve.service.ClassExreserveVO;
import com.team.prj.classreserve.mapper.ClassReserveMapper;
import com.team.prj.users.service.UsersVO;

@Service
public class ClassReserveServiceImpl implements ClassReserveService {

	@Autowired
	private ClassReserveMapper map;


	@Override
	public int classReserveInsert(ClassReserveVO vo) {
		// TODO Auto-generated method stub
		/*map.classReserveInsert(vo)*/
		return map.classReserveInsert(vo);
	}

	@Override
	public UsersVO userInfo(ClassExreserveVO vo) {
		// TODO Auto-generated method stub
		return map.userInfo(vo);
	}

	@Override
	public List<ClassReserveVO> classReserveSelectList(ClassReserveVO vo) {
		// TODO Auto-generated method stub
		return map.classReserveSelectList(vo);
	}

	@Override
	public int updateMoney(UsersVO vo) {
		// TODO Auto-generated method stub
		return map.updateMoney(vo);
	}

	@Override
	public int updateHeadCount(ClassOptionVO vo) {
		// TODO Auto-generated method stub
		return map.updateHeadCount(vo);
	}

}

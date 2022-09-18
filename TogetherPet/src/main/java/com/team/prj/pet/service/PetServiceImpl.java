package com.team.prj.pet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.prj.pet.mapper.PetMapper;

@Service
public class PetServiceImpl implements PetService {
	@Autowired
	private PetMapper map;
	
	@Override
	public List<PetVO> petSelectList() {
		return map.petSelectList();
	}

	@Override
	public PetVO petSelect(PetVO vo) {
		return map.petSelect(vo);
	}

	@Override
	public int petInsert(PetVO vo) {
		return map.petInsert(vo);
	}

	@Override
	public int petUpdate(PetVO vo) {
		return map.petUpdate(vo);
	}

	@Override
	public int petDelete(PetVO vo) {
		return map.petDelete(vo);
	}

}

package com.team.prj.pet.mapper;

import java.util.List;

import com.team.prj.pet.service.PetVO;

public interface PetMapper {
List<PetVO> petSelectList();
	
	PetVO petSelect(PetVO vo);
	
	int petInsert(PetVO vo);
	
	int petUpdate(PetVO vo);
	
	int petDelete(PetVO vo);
}

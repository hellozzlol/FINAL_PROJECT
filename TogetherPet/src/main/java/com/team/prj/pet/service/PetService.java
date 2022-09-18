package com.team.prj.pet.service;

import java.util.List;

public interface PetService {
	List<PetVO> petSelectList();
	
	PetVO petSelect(PetVO vo);
	
	int petInsert(PetVO vo);
	
	int petUpdate(PetVO vo);
	
	int petDelete(PetVO vo);
}

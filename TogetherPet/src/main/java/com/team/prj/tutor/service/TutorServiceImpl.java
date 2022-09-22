package com.team.prj.tutor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.prj.tutor.mapper.TutorMapper;

@Service
public class TutorServiceImpl implements TutorService {
	@Autowired
	private TutorMapper map;
	
	@Override
	public List<TutorVO> tutorSelectList() {
		return map.tutorSelectList();
	}

	@Override
	public TutorVO tutorSelect(TutorVO vo) {
		return map.tutorSelect(vo);
	}

	@Override
	public int tutorInsert(TutorVO vo) {
		return map.tutorInsert(vo);
	}

	@Override
	public int tutorUpdate(TutorVO vo) {
		return map.tutorUpdate(vo);
	}

	@Override
	public int tutorDelete(TutorVO vo) {
		return map.tutorDelete(vo);
	}

}

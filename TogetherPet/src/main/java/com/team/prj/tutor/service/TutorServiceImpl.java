package com.team.prj.tutor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.prj.admin.service.ProfitVO;
import com.team.prj.classes.service.ClassOptionVO;
import com.team.prj.classes.service.ClassVO;
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

	@Override

	public List<TutorVO> tutorSearch(String key, String val) {
		return map.tutorSearch(key, val);
	}



	public TutorVO tutorMyPage(TutorVO vo) {
		// TODO Auto-generated method stub
		return map.tutorMyPage(vo);
	}

	@Override
	public List<ClassVO> myClassList(ClassVO vo) {
		// TODO Auto-generated method stub
		return map.myClassList(vo);
	}

	@Override
	public List<ClassOptionVO> classOptionList(int classNo) {
		// TODO Auto-generated method stub
		return map.classOptionList(classNo);
	}

	@Override
	public List<ClassOptionVO> optionReserv(int classOptionNo) {
		// TODO Auto-generated method stub
		return map.optionReserv(classOptionNo);
	}

	@Override
	public List<ProfitVO> tutorProfitList(TutorVO tvo, String key) {
		// TODO Auto-generated method stub
		return map.tutorProfitList(tvo, key);
	}


}

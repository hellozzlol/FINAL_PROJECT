package com.team.prj.qna.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.prj.qna.mapper.QnaMapper;

@Service
public class QnaServiceImpl implements QnaService {
	
	@Autowired
	private QnaMapper map;
	
	@Override
	public List<QnaVO> selectQnaAll(QnaVO vo) {
		// TODO Auto-generated method stub
		return map.selectQnaAll(vo);
	}

	@Override
	public QnaVO selectQnaOne(QnaVO vo) {
		
		return map.selectQnaOne(vo);
	}

	@Override
	public int insertQna(QnaVO vo) {
		// TODO Auto-generated method stub
		return map.insertQna(vo);
	}

	@Override
	public int deleteQna(QnaVO vo) {
		// TODO Auto-generated method stub
		return map.deleteQna(vo);
	}

	@Override
	public String selectUserNick(QnaVO vo) {
		// TODO Auto-generated method stub
		return map.selectUserNick(vo);
	}

}

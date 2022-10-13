package com.team.prj.join.service;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.team.prj.join.mapper.JoinMapper;
import com.team.prj.seller.service.SellerVO;
import com.team.prj.tutor.service.TutorVO;
import com.team.prj.users.service.UsersVO;

@Service
public class JoinServiceImpl implements JoinService {
	
	@Autowired
	private JoinMapper jm;

	
	// 일반회원 id 중복체크
	@Override
	public int idCheck(String id){
		return jm.idCheck(id);
	}
	
	// 튜터회원 id 중복체크
	@Override
	public int tCheck(String id){
		return jm.tCheck(id);
	}

	// 판매자회원 id 중복체크
	@Override 
	public int sCheck(String id) {
		return jm.sCheck(id);
	}	

	// 닉네임 중복체크
	@Override
	public int nickCheck(String nickname) {
		return jm.nickCheck(nickname);
	}


	// 일반회원 등록
	@Override
	public int usersInsert(UsersVO vo) {
		// 비밀번호 암호화 (DB)
		BCryptPasswordEncoder Pencoder = new BCryptPasswordEncoder();
		String result = Pencoder.encode(vo.getPassword());
		vo.setPassword(result);
				
		return jm.usersInsert(vo);
	}
	
	// 튜터회원 등록
	@Override
	public int tutorInsert(TutorVO vo) {
		// 비밀번호 암호화 (DB)
		BCryptPasswordEncoder Pencoder = new BCryptPasswordEncoder();
		String result = Pencoder.encode(vo.getPassword());
		vo.setPassword(result);
				
		return jm.tutorInsert(vo);
	}

	// 판매자회원 등록
	@Override
	public int sellerInsert(SellerVO vo) {
		// 비밀번호 암호화 (DB)
		BCryptPasswordEncoder Pencoder = new BCryptPasswordEncoder();
		String result = Pencoder.encode(vo.getPassword());
		vo.setPassword(result);
				
		return jm.sellerInsert(vo);
	}

	
	// 회원 상태 업데이트
	@Override
	public String stateUpdate(UsersVO vo) {
		// TODO Auto-generated method stub
		return null;
	}
	
	// 튜터 상태 업데이트
	@Override
	public String stateUpdate(TutorVO vo) {
		// TODO Auto-generated method stub
		return null;
	}
	
	// 판매자 상태 업데이트
	@Override
	public String stateUpdate(SellerVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	// 비밀번호 재설정
	@Override
	public int pwUpdate(UsersVO vo) {
		BCryptPasswordEncoder Pencoder = new BCryptPasswordEncoder();
		String result = Pencoder.encode(vo.getPassword());
		vo.setPassword(result);
		System.out.println("impl 암호화됐나요                     " +vo.getPassword());
		return jm.pwUpdate(vo);
	}
}


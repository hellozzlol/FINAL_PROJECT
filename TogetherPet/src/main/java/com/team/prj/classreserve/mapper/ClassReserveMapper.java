package com.team.prj.classreserve.mapper;

import java.util.List;

import com.team.prj.classes.service.ClassOptionVO;
import com.team.prj.classexreserve.service.ClassExreserveVO;
import com.team.prj.classreserve.service.ClassReserveVO;
import com.team.prj.users.service.UsersVO;

public interface ClassReserveMapper {
	UsersVO userInfo(ClassExreserveVO vo);
	List<ClassReserveVO> classReserveSelectList(ClassReserveVO vo); //클래스예약내역 목록
	int classReserveInsert(ClassReserveVO vo); //클래스예약 입력
	//int classReserveUpdate(ClassReserveVO vo); //클래스예약내역 수정 필요없음
	//int classReserveDelete(ClassReserveVO vo); //클래스예약내역 삭제
	int updateMoney(UsersVO vo);
	int updateHeadCount(ClassOptionVO vo);//클래스 옵션에 정원 카운트 +1
	
	//0927 희수가 정산때문에 추가
	int updateMinusYN();
}

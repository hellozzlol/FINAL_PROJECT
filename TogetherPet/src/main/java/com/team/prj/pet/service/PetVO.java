package com.team.prj.pet.service;



import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PetVO {
	int petNo; // 펫 번호
	String type; // 펫 종류
	String name; // 펫 이름
	String breed; // 펫 품종
	String weight; // 펫 몸무게
	String gender; // 펫 성별
	String birth; // 펫 생일 0928 선희 수정(date -> string 변경)
	String neu; // 펫 중성화여부
	int groupNo; // 그룹번호
	int userNo; // 유저번호
	String attach; // 사진 0928 선희 추가
	String attachDir; // 사진 위치 0928 선희 추가
}

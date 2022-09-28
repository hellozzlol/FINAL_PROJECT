package com.team.prj.users.service;

import java.util.Date;

import com.team.prj.board.service.BoardVO;
import com.team.prj.calendar.service.CalendarVO;
import com.team.prj.cart.service.CartVO;
import com.team.prj.classes.service.ClassVO;
import com.team.prj.classreserve.service.ClassReserveVO;
import com.team.prj.comment.service.CommentVO;
import com.team.prj.goods.service.GoodsVO;
import com.team.prj.like.service.LikesVO;
import com.team.prj.orders.service.OrderVO;
import com.team.prj.pet.service.PetVO;
import com.team.prj.photo.service.PhotoVO;
import com.team.prj.scrap.service.ScrapVO;
import com.team.prj.tutor.service.TutorVO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsersVO {
	int userNo; // 유저 번호
	String id; // 유저 아이디
	String password; // 유저 비밀번호
	String name; // 유저 이름
	String nickname; // 유저 닉네임
	String email; // 유저 이메일
	String call; // 유저 전화번호
	String address; // 유저 주소
	String author; // 유저 권한('USER')
	int money; // 적립금
	int groupNo; // 그룹번호
	Date dt; // 가입일자
	String attach; // 사진 0928 선희 추가
	String attachDir; // 사진 위치 0928 선희 추가
	String state; // 0924/JH / 0925 DB에 추가함

	private OrderVO order;
	private CartVO cart;
	private BoardVO board;
	private CommentVO comment;
	private ClassVO classes;
	private LikesVO like;
	private PhotoVO photo;
	private GoodsVO goods;
	private CalendarVO cal;
	private TutorVO tutor;
	private ClassReserveVO cr;
	private ScrapVO scrap;

	//0927 희수가 추가
	private String postcode; // 우편번호
	private String da; // 상세주소
	
	private String pay; // 0927 선희 추가
	private PetVO pet; // 0927 선희 추가
	private int petNo; // 0928 선희 추가
	private int classNo; // 0928 선희 추가
}

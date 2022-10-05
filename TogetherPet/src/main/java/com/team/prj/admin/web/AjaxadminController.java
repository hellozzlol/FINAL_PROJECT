package com.team.prj.admin.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.team.prj.seller.service.SellerService;
import com.team.prj.tutor.service.TutorService;
import com.team.prj.tutor.service.TutorVO;
import com.team.prj.users.service.UsersService;
import com.team.prj.users.service.UsersVO;

@RestController
//@RequestMapping("/search")
public class AjaxadminController {
	
	@Autowired
	UsersService user;
	
	@Autowired
	SellerService seller;
	
	@Autowired
	TutorService tutor;
	

	// 일반회원 검색
	@ResponseBody
	@RequestMapping("userSearchAjax")
	public List<UsersVO> userSearch(String key, @RequestParam String val){
		return user.userSearch(key, val);
	}
	
	// 판매자 회원 검색 
	@ResponseBody
	@RequestMapping("sUserSearchAjax")
	public List<UsersVO> sUserSearch(String key, @RequestParam String val){
		return seller.sUserSearch(key, val) ;
	}
	
	// 튜터 회원 검색 
	@ResponseBody
	@RequestMapping("tUserSearchAjax")
	public List<TutorVO> tutorSearch(String key, @RequestParam String val){
		return tutor.tutorSearch(key, val) ;
	}
	
	

}

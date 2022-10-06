package com.team.prj.users.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.team.prj.scrap.service.ScrapVO;
import com.team.prj.users.service.UsersService;

@RestController
public class AjaxUsersController {
	@Autowired
	private UsersService user; // 개인회원
	
	// 위시리스트 삭제
	@RequestMapping("/ajaxLikeDelete")
	public String likeDelete(ScrapVO svo) {
		String msg;
		int cnt = user.likeDelete(svo);
		if (cnt > 0) {
			msg = "위시리스트에서 삭제되었습니다.";
		} else {
			msg = "일시적인 오류로 삭제하지 못하였습니다.";
		}
		return msg;
	}

}

package com.team.prj.join.service;

import com.team.prj.seller.service.SellerVO;
import com.team.prj.tutor.service.TutorVO;
import com.team.prj.users.service.UsersVO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JoinVO {

	private UsersVO users;
	private TutorVO tutor;
	private SellerVO seller;
}

package com.team.prj;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.team.prj.admin.mapper.adminMapper;
import com.team.prj.admin.service.adminVO;
import com.team.prj.login.mapper.LoginMapper;
import com.team.prj.login.service.LoginVO;
import com.team.prj.seller.mapper.SellerMapper;
import com.team.prj.seller.service.SellerVO;
import com.team.prj.tutor.mapper.TutorMapper;
import com.team.prj.tutor.service.TutorVO;
import com.team.prj.users.mapper.UsersMapper;
import com.team.prj.users.service.UsersVO;

public class CustomLoginSuccessHandler implements AuthenticationSuccessHandler {

	@Autowired
	UsersMapper user;
	@Autowired
	LoginMapper login;
	@Autowired
	adminMapper admin;
	@Autowired
	SellerMapper seller;
	@Autowired
	TutorMapper tutor;

	@SuppressWarnings("unlikely-arg-type")
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		HttpSession session = request.getSession();

		String auth = authentication.getAuthorities().toString();
		String id = authentication.getName();

		// No 추출
		LoginVO lvo = new LoginVO();
		lvo.setId(id);
		lvo = login.login(lvo);
		int no = lvo.getNo();
		
		//String userType = "user";
		
		if (auth.equals("[ROLE_USER]")) {

			// UsersVO 추출
			UsersVO uvo = new UsersVO();
			uvo.setUserNo(no);
			uvo = user.usersSelect(uvo);
			session.setAttribute("user", uvo);
			//session.setAttribute(userType, uvo);

		} else if (auth.equals("[ROLE_SELLER]")) {
			// SellerVO 추출
			SellerVO svo = new SellerVO();
			svo.setSellerNo(no);
			svo = seller.sellerMyPage(svo);
			session.setAttribute("seller", svo);
			//session.setAttribute(userType, svo);
			
		} else if (auth.equals("[ROLE_TUTOR]")) {
			// TutorVO 추출
			TutorVO tvo = new TutorVO();
			tvo.setTutorNo(no);
			tvo = tutor.tutorMyPage(tvo);
			session.setAttribute("tutor", tvo);
			//session.setAttribute(userType, tvo);
			
		} else if (auth.equals("[ROLE_ADMIN]")) {
			// AdminVO 추출
			adminVO avo = new adminVO();
			avo.setAdNo(no);
			avo = admin.adminSelect(avo);
			session.setAttribute("admin", avo);
			//session.setAttribute(userType, avo);
		}

		String cpath = request.getContextPath();
		
		response.sendRedirect(cpath + "/index");
	}

}

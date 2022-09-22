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
import com.team.prj.users.mapper.UsersMapper;
import com.team.prj.users.service.UsersVO;

public class CustomLoginSuccessHandler implements AuthenticationSuccessHandler {

	@Autowired
	UsersMapper user;
	@Autowired
	LoginMapper login;
	@Autowired
	adminMapper admin;

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

		if (auth.equals("[ROLE_USER]")) {

			// UsersVO 추출
			UsersVO uvo = new UsersVO();
			uvo.setUserNo(no);
			uvo = user.usersSelect(uvo);
			session.setAttribute("user", uvo);

		} else if (auth.equals("[ROLE_SELLER]")) {
			//
		} else if (auth.equals("[ROLE_TUTOR]")) {
			//
		} else if (auth.equals("[ROLE_ADMIN]")) {
			//
			adminVO avo = new adminVO();
			avo.setAdNo(no);
			avo = admin.adminSelect(avo);
			session.setAttribute("admin", avo);
		}

		String cpath = request.getContextPath();

		response.sendRedirect(cpath + "/index");
	}

}

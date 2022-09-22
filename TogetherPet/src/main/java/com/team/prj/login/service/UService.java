package com.team.prj.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.team.prj.login.mapper.LoginMapper;

public class UService implements UserDetailsService {
	
	@Autowired LoginMapper mapper;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		 LoginVO vo =  new LoginVO();
	      vo.setId(username);
	      vo = mapper.login(vo);
	      if(vo == null) {
	         throw new UsernameNotFoundException("no user");
	      }
	      return new CustomUser(vo);
	}
}

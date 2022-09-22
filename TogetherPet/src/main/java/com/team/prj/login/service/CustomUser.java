package com.team.prj.login.service;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import lombok.Getter;

@Getter
public class CustomUser extends User {
	private LoginVO login;   
	   public CustomUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
	      super(username, password, authorities);
	   }   
	   public CustomUser(LoginVO vo) {
	      super(vo.getId(), 
	            vo.getPassword(), 
	            Collections.singletonList(new SimpleGrantedAuthority(vo.getAuthor())));
	      this.login = vo;
	   }
	
	
}

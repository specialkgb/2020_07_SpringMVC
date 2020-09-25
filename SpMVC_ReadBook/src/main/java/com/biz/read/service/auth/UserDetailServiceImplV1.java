package com.biz.read.service.auth;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.biz.read.mapper.AuthorityDao;
import com.biz.read.mapper.UserDao;
import com.biz.read.model.UserDetailsVO;

import lombok.RequiredArgsConstructor;

/*
 * spring security 프로젝트에서 사용자 인가와 권한을 관리하는 클래스
 * UserDetailsService를 Customizing
 */

@RequiredArgsConstructor
public class UserDetailServiceImplV1 implements UserDetailsService {
	
	
	private final UserDao userDao;
	private final AuthorityDao authDao;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		UserDetailsVO userDetail = userDao.findById(username);
		if(userDetail == null ) {
			throw new UsernameNotFoundException(username + " 정보를 찾을 수 없음 ");
			
		}
		
		
		return userDetail;
	}
	
	

}

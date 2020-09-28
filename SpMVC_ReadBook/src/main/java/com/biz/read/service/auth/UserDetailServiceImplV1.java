package com.biz.read.service.auth;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.biz.read.mapper.AuthorityDao;
import com.biz.read.mapper.UserDao;
import com.biz.read.model.UserDetailsVO;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/*
 * spring security 프로젝트에서 사용자 인가와 권한을 관리하는 클래스
 * UserDetailsService를 Customizing
 */

@Slf4j
@RequiredArgsConstructor
@Service("userDetailServiceV1")
public class UserDetailServiceImplV1 implements UserDetailsService {

	private final UserDao userDao;
	private final AuthorityDao authDao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		UserDetailsVO userDetail = userDao.findById(username);
		
		/* 테스트를 위한 임시 정보 주입
		userDetail = UserDetailsVO.builder().username(username).password("12341234").enabled(true).build();
		 */
		if (userDetail == null) {

			throw new UsernameNotFoundException(username + " 정보를 찾을 수 없음 ");
		}

		log.debug("USER:" + userDetail.toString());
		
		userDetail.setEnabled(true);
		return userDetail;
	}

}

package com.biz.read.auth;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.biz.read.model.AuthorityVO;
import com.biz.read.model.UserDetailsVO;

public class AuthProviderImpl implements AuthenticationProvider{

	
	@Autowired
	@Qualifier("userDetailServiceV1")
	private UserDetailsService userService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		
		String username = (String) authentication.getPrincipal();
		String password = (String) authentication.getCredentials();
		
		UserDetailsVO userVO = (UserDetailsVO) userService.loadUserByUsername(username);
		
		// 비밀번호 검사
		// 암호화 하지 않았을 경우 문자열 비교
//		if(!password.equals(userVO.getPassword())) {
//			
//			throw new BadCredentialsException("비밀번호 오류");
//			
//		}
		
		// PasswordEncoder로 암호화된 비번 비교
		/*
		 * 사용자가 입력한 password 평문 문자열을 내부에서 암호화하여
		 * DB에 저장되어 있는 암호화된 비번(userVO.getPassword())을 비교하여 일치하는지 검사한다.
		 */
		if(!passwordEncoder.matches(password, userVO.getPassword())) {
			throw new BadCredentialsException("비밀번호가 일치하지 않음");
		}
		
		
		// 유효한 사용자 정보 비교
		if(!userVO.isEnabled()) {
			throw new BadCredentialsException(username + "사용자 정보 사용불가!!");
		}
		
		// 4. 사용자의 권한 리스트를 생성
		// 가. 권한을 지정하여 add
		List<AuthorityVO> authList = new ArrayList<AuthorityVO>();
		authList.add(AuthorityVO.builder().m_role("ROLE_ADMIN").build());
		authList.add(AuthorityVO.builder().m_role("ROLE_USER").build());
		
		// 나. spring security의 hasRole() method에서 사용할 자료형으로 변환
		List<GrantedAuthority> rollList = new ArrayList<>();
		
		for(AuthorityVO auth : authList) {
			rollList.add(new SimpleGrantedAuthority(auth.getM_role()));
		}
		
		
		rollList.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
		rollList.add(new SimpleGrantedAuthority("ROLL_USER"));
		
		// 로그인한 사용자에게 인증 token을 발생
		return new UsernamePasswordAuthenticationToken(userVO, null, rollList);
	}

	@Override
	public boolean supports(Class<?> authentication) {
		// TODO Auto-generated method stub
		return true;
	}

}

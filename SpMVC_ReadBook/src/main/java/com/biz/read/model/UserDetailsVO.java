package com.biz.read.model;

import java.util.Collection;

import org.apache.ibatis.type.Alias;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Alias("UserDetail")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserDetailsVO implements UserDetails {
	
	private static final long serialVersionUID = 1L;
	
	private long id;
	
	private String username;
	private String password;
	
	private boolean enabled;
	private boolean accountNonExpired;
	private boolean accountNonLocked;
	private boolean credentialsNonExpired;
	
	private Collection<? extends GrantedAuthority> authorities;
	
	private String m_name;
	private String m_tel;
	private String m_email;
	private String m_address;

}

package com.biz.read.model;

import java.util.Collection;

import org.apache.ibatis.type.Alias;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Getter;
import lombok.Setter;

@Alias("UserDetail")
@Getter
@Setter
public class UserDetailsVO implements UserDetails {
	
	private static final long serialVersionUID = 1L;
	
	private long id;
	
	private String username;
	private String password;
	
	private boolean isEnabled;
	private boolean isAccountNonExpired;
	private boolean isAccountNonLocked;
	private boolean isCredentialsNonExpired;
	
	private Collection<? extends GrantedAuthority> authorities;
	
	String email;
	String phone;
	String address;

}

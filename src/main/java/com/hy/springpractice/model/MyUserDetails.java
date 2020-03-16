package com.hy.springpractice.model;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class MyUserDetails implements UserDetails {
	
	private List<GrantedAuthority> authorities = null;
	private String password;
	private String username;
	private Long id;
	private boolean nonExpired = true;
	private boolean nonLocked = true;
	private boolean credentialsNonExpired = true;
	private boolean enable = true;
	
	
	
	public MyUserDetails(User user) {
		password = user.getThepassword();
		username = user.getTheusername();
		id = user.getId();
	}
	

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return authorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return nonExpired;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return nonLocked;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return credentialsNonExpired;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return enable;
	}


	public Long getId() {
		return id;
	}
	
	

}

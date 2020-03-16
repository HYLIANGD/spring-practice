package com.hy.springpractice.provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

@Component
public class MyAuthenticationProvider implements AuthenticationProvider {
	
	@Autowired
	UserDetailsService myUserDetailService;
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		System.out.println("MyAuthenticationProvider開始執行");
		UserDetails userDetails = myUserDetailService.loadUserByUsername(authentication.getName());
		if(userDetails.getPassword().equals(authentication.getCredentials().toString())) {
			return new UsernamePasswordAuthenticationToken(userDetails.getUsername(),userDetails.getPassword(), userDetails.getAuthorities());
		}else {
			return null;
		}
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

}

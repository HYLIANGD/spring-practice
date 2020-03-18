package com.hy.springpractice.filter;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.hy.springpractice.token.IpAuthenticationToken;

public class IpAuthenticationProcessingFilter extends AbstractAuthenticationProcessingFilter {

	public IpAuthenticationProcessingFilter() {
		super(new AntPathRequestMatcher("/iplogin"));
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException, IOException, ServletException {
		System.out.println("IP filter開始執行");
		String host = request.getRemoteHost();
		System.out.println("host:" + host);
		Authentication authentication = getAuthenticationManager().authenticate(new IpAuthenticationToken(host));
		System.out.println("filter done: " + authentication);
		return  authentication;
	}

}

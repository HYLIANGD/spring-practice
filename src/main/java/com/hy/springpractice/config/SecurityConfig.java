package com.hy.springpractice.config;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.assertj.core.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@EnableWebSecurity
@ComponentScan("com.hy.springpractice.provider")
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private DataSource dataSource;
	@Autowired
	private UserDetailsService myUserDetailsService;
	@Autowired
	private AuthenticationProvider myAuthenticationProvider;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
//		in memory authentication
//		auth.inMemoryAuthentication()
//			.withUser("john")
//			.password("123")
//			.roles("admin");
		System.out.println();
		
		auth.userDetailsService(myUserDetailsService)
			.and()
			.authenticationProvider(myAuthenticationProvider);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http
		.authorizeRequests()
			.antMatchers("/css/**").permitAll()
			.antMatchers("/js/**").permitAll()
			.antMatchers("/").permitAll()
			.antMatchers("/cities/**").permitAll()
			.antMatchers("/countries/**").permitAll()
			.antMatchers("/motos/**").hasRole("STAFF")
			.anyRequest().authenticated()
		.and()
			.formLogin()
		.and()
			.logout().permitAll();
		
	}

//	@Override
//	protected AuthenticationManager authenticationManager() throws Exception {
//		
//		List<AuthenticationProvider> list = new ArrayList<>();
//		list.add(myAuthenticationProvider);
//		AuthenticationManager authenticationManager = new ProviderManager(list);
//		return authenticationManager;
//	}
	
	
	

}



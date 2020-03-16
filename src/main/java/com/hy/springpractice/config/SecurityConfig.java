package com.hy.springpractice.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	@Qualifier("securityDataSource")
	private DataSource dataSource;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
//		in memory authentication
//		auth.inMemoryAuthentication()
//			.withUser("john")
//			.password("123")
//			.roles("admin");
		
		auth.jdbcAuthentication().dataSource(dataSource).usersByUsernameQuery(query);
		
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
			.anyRequest().authenticated()
		.and()
			.formLogin()
		.and()
			.logout().permitAll();
		
	}
	
	
		
}



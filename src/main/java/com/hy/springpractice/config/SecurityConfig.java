package com.hy.springpractice.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.hy.springpractice.filter.IpAuthenticationProcessingFilter;

@EnableWebSecurity
@ComponentScan("com.hy.springpractice.provider")
//@PreAuthorize需要開啟
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private DataSource dataSource;
	@Autowired
	private UserDetailsService myUserDetailsService;
	@Autowired
	private AuthenticationProvider ipAuthenticationProvider;
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
			.authenticationProvider(myAuthenticationProvider)
			.authenticationProvider(ipAuthenticationProvider);
		
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http
		.authorizeRequests()
			.antMatchers("/css/**").permitAll()
			.antMatchers("/js/**").permitAll()
			.antMatchers("/").permitAll()
			.antMatchers("/denied").permitAll()
			.antMatchers("/countries/**").permitAll()
			.antMatchers("/iplogin/**").permitAll()
//			.antMatchers("/cities/search**").access("hasRole('STAFF') and hasAuthority('LEVEL_A') ")
//			.antMatchers("/cities/**").hasAnyRole("STAFF","MANAGER")
			.anyRequest().authenticated()
		.and()
			.formLogin()
			.defaultSuccessUrl("/function")
		.and()
			.logout().permitAll()
		.and()
			.exceptionHandling().accessDeniedPage("/denied");
			//.accessDeniedHandler(accessDeniedHandler);
		//cors
		//header
		//entrypoint
		http.addFilterBefore(getIpAuthenticationProcessingFilter(authenticationManager()), UsernamePasswordAuthenticationFilter.class);
		//add before at after
	}
	
	public IpAuthenticationProcessingFilter getIpAuthenticationProcessingFilter(AuthenticationManager authenticationManager) {
        IpAuthenticationProcessingFilter ipAuthenticationProcessingFilter = new IpAuthenticationProcessingFilter();
        ipAuthenticationProcessingFilter.setAuthenticationManager(authenticationManager);
        ipAuthenticationProcessingFilter.setAuthenticationFailureHandler(new SimpleUrlAuthenticationFailureHandler("/?error=ipFail"));
        ipAuthenticationProcessingFilter.setAuthenticationSuccessHandler(new SimpleUrlAuthenticationSuccessHandler("/function"));
        return ipAuthenticationProcessingFilter;
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



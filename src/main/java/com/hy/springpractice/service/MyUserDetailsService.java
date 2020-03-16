package com.hy.springpractice.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.hy.springpractice.model.MyUserDetails;
import com.hy.springpractice.model.User;
import com.hy.springpractice.repository.UserRepository;

@Service
public class MyUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("MyUserDetailsService開始執行");
		Optional<User> user = userRepository.findByTheusername(username);

		user.orElseThrow(()-> new UsernameNotFoundException("Can't find " + username));
		
		return new MyUserDetails(user.get());
	}

}

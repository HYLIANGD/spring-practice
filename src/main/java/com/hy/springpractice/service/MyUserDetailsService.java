package com.hy.springpractice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.hy.springpractice.model.Level;
import com.hy.springpractice.model.MyUserDetails;
import com.hy.springpractice.model.Role;
import com.hy.springpractice.model.User;
import com.hy.springpractice.repository.UserRepository;

@Service
public class MyUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	RoleService roleService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("MyUserDetailsService開始執行");
		Optional<User> user = userRepository.findByTheusername(username);

		user.orElseThrow(()-> new UsernameNotFoundException("Can't find " + username));	
		
		List<Role> roles = roleService.findByUser(user.get());
		List<GrantedAuthority> authorities = new ArrayList<>();
		for(Role role : roles) {
			authorities.add(new SimpleGrantedAuthority(role.getTherole()));
		}
		
		List<Level> levels = user.get().getLevels();
		for(Level level : levels) {
			authorities.add(new SimpleGrantedAuthority(level.getThelevel()));
		}
		
		return new MyUserDetails(user.get(), authorities);
		
	}

}

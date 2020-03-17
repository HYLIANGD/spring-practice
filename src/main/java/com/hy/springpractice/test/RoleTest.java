package com.hy.springpractice.test;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.hy.springpractice.model.Role;
import com.hy.springpractice.model.User;
import com.hy.springpractice.repository.RoleRepository;
import com.hy.springpractice.repository.UserRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RoleTest {
	
	@Autowired
	RoleRepository roleRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Test
	public void test() {
		Optional<User> user = userRepository.findById(2L);
		Role role = new Role(user.get(), "JustForTest");
		roleRepository.save(role);
	}
	
	
}

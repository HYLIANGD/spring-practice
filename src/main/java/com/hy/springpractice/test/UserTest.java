package com.hy.springpractice.test;

import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.hy.springpractice.model.Level;
import com.hy.springpractice.model.User;
import com.hy.springpractice.repository.UserRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTest {

	@Autowired
	UserRepository userRepository;
	
	@Test
	public void test() {
		Optional<User> user = userRepository.findById(1l);
		List<Level> list = user.get().getLevels();
		for(Level level: list) {
			System.out.println(level.getThelevel());
		}
	}
	
}

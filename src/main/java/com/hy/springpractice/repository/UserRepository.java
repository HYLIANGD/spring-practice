package com.hy.springpractice.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.hy.springpractice.model.User;

public interface UserRepository extends CrudRepository<User, Long> {

	Optional<User> findByTheusername(String username);
	
}

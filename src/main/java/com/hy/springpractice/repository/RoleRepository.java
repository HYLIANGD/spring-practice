package com.hy.springpractice.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.hy.springpractice.model.Role;
import com.hy.springpractice.model.User;

public interface RoleRepository extends CrudRepository<Role, Long> {
	
	public List<Role> findByUser(User user);
	
}

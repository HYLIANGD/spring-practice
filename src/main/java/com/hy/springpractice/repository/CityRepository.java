package com.hy.springpractice.repository;

import org.springframework.data.repository.RepositoryDefinition;

import com.hy.springpractice.model.City;

@RepositoryDefinition(domainClass = City.class, idClass = Long.class)
public interface CityRepository {
	
	City findById(Long id);
	City getById(Long id);
	
}

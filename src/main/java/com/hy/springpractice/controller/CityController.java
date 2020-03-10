package com.hy.springpractice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hy.springpractice.model.City;
import com.hy.springpractice.repository.CityRepository;

@RestController
@RequestMapping("/city")
public class CityController {
	
	@Autowired
	private CityRepository cityRepository;

	@GetMapping("{id}")
	public City findCityById(@PathVariable("id") Long id) {

		return cityRepository.getById(id);
	}
	
	
}

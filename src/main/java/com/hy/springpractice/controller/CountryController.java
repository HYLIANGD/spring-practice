package com.hy.springpractice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hy.springpractice.model.Country;
import com.hy.springpractice.service.CountryService;

@RestController
@RequestMapping("/countries")
public class CountryController {

	@Autowired
	private CountryService countryService;
	
	@GetMapping("/{code}")
	public Country getCountryByCode(@PathVariable("code") String code) {
		return countryService.getCountryByCode(code);
	}
	
	
}

package com.hy.springpractice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.hy.springpractice.model.Country;
import com.hy.springpractice.repository.CountryRepository;

@Service
@CacheConfig(cacheNames = "countryCache")
public class CountryService {

	@Autowired
	private CountryRepository countryRepository;
	
	@Cacheable(key = "#code")
	public Country getCountryByCode(String code) {
		return countryRepository.getOne(code);
	}
	
}

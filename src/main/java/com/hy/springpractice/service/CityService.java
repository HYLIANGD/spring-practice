package com.hy.springpractice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import com.hy.springpractice.model.City;
import com.hy.springpractice.repository.CityRepository;

@Service
@CacheConfig(cacheNames = "cityCache", cacheManager = "cityCacheManager")
public class CityService {
	
	@Autowired
	CityRepository cityRepository;
	
	public List<City> listCity(){
		return cityRepository.findAll();
	}
	
	@Cacheable(key = "#id")
	public City getCity(Long id) {
		System.out.println("執行尋找ID = " + id);
		return cityRepository.getById(id);
	}
	
	@CachePut(key = "#result.id")
	public City updateCity(City city) {
		System.out.println("執行更新City, ID = " + city.getId());
		System.out.println(city.getId());
		return cityRepository.save(city);
	}
	
	@CacheEvict(key = "#id")
	public void deleteCity(Long id) {
		System.out.println("執行delete city");
		//cityRepository.delete(id);
	}
	
	@Caching(
			cacheable = {
					@Cacheable(key = "#name")
			},
			put = {
					@CachePut(key = "#result.id"),
					@CachePut(key = "#result.district"),
			}
	)
	public City getCityByName(String name){
		return cityRepository.findByName(name);
	}
	
}

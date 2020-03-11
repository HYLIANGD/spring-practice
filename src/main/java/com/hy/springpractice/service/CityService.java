package com.hy.springpractice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.hy.springpractice.model.City;
import com.hy.springpractice.repository.CityRepository;

@Service
public class CityService {
	
	@Autowired
	CityRepository cityRepository;
	
	public List<City> listCity(){
		return cityRepository.findAll();
	}
	
	@Cacheable(cacheNames =  "cityCache", key = "#id")
	public City getCity(Long id) {
		System.out.println("執行尋找ID = " + id);
		return cityRepository.getById(id);
	}
	
	public City updateCity(City city) {
		System.out.println("執行更新City, ID = " + city.getId());
		System.out.println(city.getId());
		return cityRepository.save(city);
	}
	
	public void deleteCity(Long id) {
		System.out.println("執行delete city");
		//cityRepository.delete(id);
	}
	
}

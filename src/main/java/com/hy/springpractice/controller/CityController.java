package com.hy.springpractice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hy.springpractice.model.City;
import com.hy.springpractice.service.CityService;

@RestController
@PreAuthorize("hasRole('STAFF')")
@RequestMapping("/cities")
public class CityController {
	
	/*
	 * JPA練習的code
	 */
//	@Autowired
//	private CityRepository cityRepository;
//
//	@GetMapping("{id}")
//	public City findCityById(@PathVariable("id") Long id) {
//
//		return cityRepository.getById(id);
//	}
//	
//	@GetMapping("/lessandorder")
//	public List<City> findCityLessThanAndOrderbyId(@Param("val") Long val) {
//		
//		return cityRepository.findByIdLessThanOrderByNameDesc(val);
//	}
//	
//	@GetMapping("/count")
//	public Long countCityByNameContaining(@Param("name") String name) {
//		
//		return cityRepository.countByNameContaining(name);
//	}
//	
//	@GetMapping
//	public Page<City> findAllCity(@Param("page") Integer page){
//		Sort sort = Sort.by("name").descending().and(Sort.by("id").ascending());
//		if(page == null) {
//			Pageable pageable = PageRequest.of(0, 5000, sort);
//			return cityRepository.findAll(pageable);
//		}
//		Pageable pageable = PageRequest.of(page, 10, sort);
//		return cityRepository.findAll(pageable);
//	}
//	
//	@GetMapping("/search")
//	public List<City> findCityOrDistrict(@Param("name")String name){
//		return cityRepository.searchByCitynameAndDistrictLike(name);
//	}
	
	/*
	 * cache練習的code
	 */
	@Autowired
	CityService cityService;
	
	@GetMapping
	public List<City> listCity(){
		return cityService.listCity();
	}
	
	@GetMapping("/{id}")
	public City getCity(@PathVariable("id") Long id) {
		return cityService.getCity(id);
	}
	
	@GetMapping("/{id}/update")
	public City updateCity(@PathVariable("id") Long id, @Param("name")String name) {
		City city = cityService.getCity(id);
		city.setName(name);
		return cityService.updateCity(city);
	}
	
	@GetMapping("/{id}/delete")
	public String deleteCity(@PathVariable("id") Long id) {
		cityService.deleteCity(id);
		return "Delete done";
	}
	
	@PreAuthorize("hasAuthority('LEVEL_A')")
	@GetMapping("/search")
	public City getCityByName(@Param("name") String name){
		return cityService.getCityByName(name);
	}
	
}

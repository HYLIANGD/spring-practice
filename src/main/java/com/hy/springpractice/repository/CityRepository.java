package com.hy.springpractice.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hy.springpractice.model.City;

public interface CityRepository extends JpaRepository<City,Long>{
	
	City getById(Long id);
	
	List<City> findByIdLessThanOrderByNameDesc(Long val);
	
	Long countByNameContaining(String name);
	
	Page<City> findAll(Pageable pageable);
	
	@Query(nativeQuery=true,
			value="SELECT * FROM world.city c WHERE c.name LIKE %:title% OR c.district LIKE %:title%")
	List<City> searchByCitynameAndDistrictLike(@Param("title") String title);
	
}

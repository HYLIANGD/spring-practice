package com.hy.springpractice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hy.springpractice.model.Country;

public interface CountryRepository extends JpaRepository<Country, String> {

}

package com.hy.springpractice.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hy.springpractice.model.autowired.MotoAutowired;
import com.hy.springpractice.model.autowired.SportBikeAutowired;


@RequestMapping("/motos")
@RestController
public class MotoController {

//	@GetMapping
//	public MotoAutowired getOneSportBike(@Param(value ="displacement")Integer displacement) {
//		MotoAutowired moto = new SportBikeAutowired();
//		UserDetails principal = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//		moto.setBrand(principal.getUsername());
//		if(displacement == null) {
//			return moto;
//		}
//		moto.setDisplacement(displacement);
//		return moto;
//	}
	
	@GetMapping
	public MotoAutowired getOneSportBike(@RequestParam(value ="displacement", required = false)Integer displacement, Authentication authentication) {
		MotoAutowired moto = new SportBikeAutowired();
		moto.setBrand(authentication.getName());
		if(displacement == null) {
			return moto;
		}
		moto.setDisplacement(displacement);
		return moto;
	}
	
	
	
}

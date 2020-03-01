package com.hy.springpractice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.hy.springpractice.model.autowired.MotoAutowired;
import com.hy.springpractice.model.autowired.SportBikeAutowired;

/**
 * @author henry.liang
 *
 */
@RequestMapping("/moto")
@RestController
public class MotoController {

	@GetMapping
	public MotoAutowired getOneSportBike() {
		return new SportBikeAutowired();
	}
	
	@GetMapping("/{displacement}")
	public MotoAutowired getTestingBike(@PathVariable(value = "displacement") int displacement) {
		MotoAutowired moto = new SportBikeAutowired();
		moto.setBrand("test");
		moto.setDisplacement(displacement);
		return moto;
	}
	
}

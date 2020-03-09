package com.hy.springpractice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hy.springpractice.model.autowired.MotoAutowired;
import com.hy.springpractice.model.autowired.SportBikeAutowired;

/**
 * @author henry.liang
 *
 */
@RequestMapping("/motos")
@RestController
public class MotoController {

	@GetMapping
	public MotoAutowired getOneSportBike(@RequestParam(value ="displacement")int displacement) {
		MotoAutowired moto = new SportBikeAutowired();
		if(displacement < 0) {
			return moto;
		}
		moto.setBrand("test");
		moto.setDisplacement(displacement);
		return moto;
	}
	

	
}

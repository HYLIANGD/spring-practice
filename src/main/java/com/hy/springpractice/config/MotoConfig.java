package com.hy.springpractice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.hy.springpractice.model.Insurance;
import com.hy.springpractice.model.Moto;
import com.hy.springpractice.model.Scooter;
import com.hy.springpractice.model.SportBike;
import com.hy.springpractice.model.SuperInsurance;
import com.hy.springpractice.model.TrafficInsurance;

@Configuration
@ComponentScan("com.hy")
public class MotoConfig {
	
	@Bean
	public Insurance trafficInsurance() {
		Insurance insurance = new TrafficInsurance();
		return insurance;
	}
	
	@Bean
	public Insurance superInsurance() {
		Insurance insurance = new SuperInsurance();
		return insurance;
	}
	
	@Bean
	public Moto ducatiSportBike() {
		SportBike bike = new SportBike(superInsurance());
		bike.setBrand("Ducati");
		bike.setCertificationLevel("A");
		bike.setDisplacement(1199);
		bike.setModelName("Panigale");
		bike.setTrackRecord("50sec");
		return bike;
	}
	
	@Bean
	public Moto hondaSportBike() {
		SportBike bike = new SportBike(superInsurance());
		bike.setBrand("Honda");
		bike.setCertificationLevel("A");
		bike.setDisplacement(999);
		bike.setModelName("CBR");
		bike.setTrackRecord("51sec");
		return bike;
	}
	
	@Bean
	public Moto scooter() {
		Scooter bike = new Scooter(trafficInsurance());
		bike.setBrand("YAMAHA");
		bike.setDisplacement(125);
		bike.setModelName("GTR");
		bike.setTrunk(25);
		return bike;
	}
	
}

package com.hy.springpractice.test;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.hy.springpractice.config.autowired.MotoConfig;
import com.hy.springpractice.model.autowired.Moto;
import com.hy.springpractice.model.autowired.Scooter;
import com.hy.springpractice.model.autowired.SportBike;

public class IOCUsIngAutowired {

	@Test
	public void test() {
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(MotoConfig.class);
		Moto johnSportBike = context.getBean(SportBike.class);
		System.out.print("Sport bike insurance: ");
		System.out.println(johnSportBike.getInsurance().getInsuranceContent());
		
		Moto johnScooter = context.getBean(Scooter.class);
		System.out.print("Scooter insurance: ");
		System.out.println(johnScooter.getInsurance().getInsuranceContent());
		
		//bean scope test
		System.out.println("johnSportBike brand = " + johnSportBike.getBrand() );
		
		System.out.println("Add brand in John's bike");
		johnSportBike.setBrand("Ducati");
		System.out.println("johnSportBike brand = " + johnSportBike.getBrand() );
		
		System.out.println("Container created new bike to Ray");
		Moto raySportBike = context.getBean(SportBike.class);
		System.out.println("raySportBike brand = " + raySportBike.getBrand());
		
		
		context.close();
	}
	
}

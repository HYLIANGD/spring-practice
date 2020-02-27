package com.hy.springpractice.test;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.hy.springpractice.config.autowired.MotoConfigAutowired;
import com.hy.springpractice.model.autowired.MotoAutowired;
import com.hy.springpractice.model.autowired.ScooterAutowired;
import com.hy.springpractice.model.autowired.SportBikeAutowired;

public class IOCUsIngAutowired {

	@Test
	public void test() {
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(MotoConfigAutowired.class);
		MotoAutowired johnSportBike = context.getBean(SportBikeAutowired.class);
		System.out.print("Sport bike insurance: ");
		System.out.println(johnSportBike.getInsurance().getInsuranceContent());
		
		MotoAutowired johnScooter = context.getBean(ScooterAutowired.class);
		System.out.print("Scooter insurance: ");
		System.out.println(johnScooter.getInsurance().getInsuranceContent());
		
		//bean scope test
		System.out.println("johnSportBike brand = " + johnSportBike.getBrand() );
		
		System.out.println("Add brand in John's bike");
		johnSportBike.setBrand("Ducati");
		System.out.println("johnSportBike brand = " + johnSportBike.getBrand() );
		
		System.out.println("Container created new bike to Ray");
		MotoAutowired raySportBike = context.getBean(SportBikeAutowired.class);
		System.out.println("raySportBike brand = " + raySportBike.getBrand());
		
		
		context.close();
	}
	
}

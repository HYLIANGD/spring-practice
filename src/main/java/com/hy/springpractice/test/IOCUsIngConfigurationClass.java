package com.hy.springpractice.test;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.hy.springpractice.config.MotoConfig;
import com.hy.springpractice.model.Scooter;
import com.hy.springpractice.model.SportBike;

public class IOCUsIngConfigurationClass {

	@Test
	public void test() {
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(MotoConfig.class);

		SportBike johnDucatiSportBike = context.getBean("ducatiSportBike",SportBike.class);
		System.out.print("First bike:");
		System.out.println(johnDucatiSportBike.toString());
		
		System.out.print("Second bike:");
		SportBike johnHondaSportBike = context.getBean("hondaSportBike",SportBike.class);
		System.out.println(johnHondaSportBike.toString());
		
		System.out.print("Third bike:");
		Scooter johnScooter = context.getBean(Scooter.class);
		System.out.println(johnScooter.toString());
		
		context.close();
	}
	
}

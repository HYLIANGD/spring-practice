package com.hy.springpractice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.hy.springpractice.config.MotoConfig;
import com.hy.springpractice.model.Scooter;
import com.hy.springpractice.model.SportBike;

@SpringBootApplication
public class SpringPracticeApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringPracticeApplication.class, args);
		
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

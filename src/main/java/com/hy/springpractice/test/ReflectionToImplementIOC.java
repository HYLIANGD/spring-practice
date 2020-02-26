package com.hy.springpractice.test;

import org.junit.Test;

import com.hy.springpractice.container.CustomBeanFactory;
import com.hy.springpractice.container.CustomContext;
import com.hy.springpractice.model.autowired.Insurance;
import com.hy.springpractice.model.autowired.Moto;
import com.hy.springpractice.model.autowired.Scooter;
import com.hy.springpractice.model.autowired.SportBike;
import com.hy.springpractice.model.autowired.TrafficInsurance;

public class ReflectionToImplementIOC {
	
	/*
	 * 用Reflection and Factory pattern自己造一個簡易的IoC
	 * @Autowire只能用在Constructor上, 並且argument只能有一個(可使用Qualifier)
	 * getBean(String, Class<T>), 第一個argument String目前沒任何作用...只是要仿造Spring IoC而寫的
	 * 此IoC沒有Bean scope, life cycle, 僅練習使用
	 */
	
	@Test
	public void test() throws Exception {
		CustomBeanFactory context = new CustomContext();
		
		Moto mySportBike = context.getBean("BeanId", SportBike.class);
		System.out.println(mySportBike.getClass());
		System.out.println(mySportBike.getInsurance());
		
		Moto myScooter = context.getBean("BeanId", Scooter.class);
		System.out.println(myScooter.getClass());
		System.out.println(myScooter.getInsurance());
		
		Insurance insurance = context.getBean("insurance", TrafficInsurance.class);
		System.out.println(insurance);
	}
	
	
}

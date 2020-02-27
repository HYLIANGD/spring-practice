package com.hy.springpractice.test;

import org.junit.Test;

import com.hy.springpractice.container.CustomBeanFactory;
import com.hy.springpractice.container.CustomContext;
import com.hy.springpractice.model.autowired.InsuranceAutowired;
import com.hy.springpractice.model.autowired.MotoAutowired;
import com.hy.springpractice.model.autowired.ScooterAutowired;
import com.hy.springpractice.model.autowired.SportBikeAutowired;
import com.hy.springpractice.model.autowired.TrafficInsuranceAutowired;

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
		
		MotoAutowired mySportBike = context.getBean("BeanId", SportBikeAutowired.class);
		System.out.println(mySportBike.getClass());
		System.out.println(mySportBike.getInsurance());
		
		MotoAutowired myScooter = context.getBean("BeanId", ScooterAutowired.class);
		System.out.println(myScooter.getClass());
		System.out.println(myScooter.getInsurance());
		
		InsuranceAutowired insurance = context.getBean("insurance", TrafficInsuranceAutowired.class);
		System.out.println(insurance);
	}
	
	
}

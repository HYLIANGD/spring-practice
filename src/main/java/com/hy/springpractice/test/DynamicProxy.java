package com.hy.springpractice.test;

import org.junit.Test;

import com.hy.springpractice.container.CustomBeanFactory;
import com.hy.springpractice.container.CustomBeanFactoryImpl;
import com.hy.springpractice.container.DynamicProxyUtil;
import com.hy.springpractice.model.autowired.Insurance;
import com.hy.springpractice.model.autowired.Moto;
import com.hy.springpractice.model.autowired.SportBike;
import com.hy.springpractice.model.autowired.SuperInsurance;

public class DynamicProxy {
	
	@Test
	public void test() throws Exception {
		CustomBeanFactory dynamicProxy = (CustomBeanFactory) DynamicProxyUtil.getDynamicProxy(new CustomBeanFactoryImpl());
		Moto sportBike = dynamicProxy.getBean("bike", SportBike.class);
		System.out.println(sportBike.getClass());
		System.out.println(sportBike.getInsurance());
		
		Insurance dynamicProxy2 = (Insurance) DynamicProxyUtil.getDynamicProxy(new SuperInsurance());
		String insuranceContent = dynamicProxy2.getInsuranceContent();
		System.out.println(insuranceContent);
	}

}

package com.hy.springpractice.test;

import org.junit.Test;

import com.hy.springpractice.container.CustomBeanFactory;
import com.hy.springpractice.container.CustomBeanFactoryImpl;
import com.hy.springpractice.model.autowired.InsuranceAutowired;
import com.hy.springpractice.model.autowired.MotoAutowired;
import com.hy.springpractice.model.autowired.SportBikeAutowired;
import com.hy.springpractice.model.autowired.SuperInsuranceAutowired;
import com.hy.springpractice.proxy.JDKProxyUtil;

public class JDKProxy {
	
	@Test
	public void test() throws Exception {
		CustomBeanFactory jDKProxy = (CustomBeanFactory) JDKProxyUtil.getJDKProxy(new CustomBeanFactoryImpl());
		MotoAutowired sportBike = jDKProxy.getBean("bike", SportBikeAutowired.class);
		System.out.println(sportBike.getClass());
		System.out.println(sportBike.getInsurance());
		
		InsuranceAutowired dynamicProxy2 = (InsuranceAutowired) JDKProxyUtil.getJDKProxy(new SuperInsuranceAutowired());
		String insuranceContent = dynamicProxy2.getInsuranceContent();
		System.out.println(insuranceContent);
	}

}

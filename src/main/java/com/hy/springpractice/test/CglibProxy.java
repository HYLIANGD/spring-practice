package com.hy.springpractice.test;

import org.junit.Test;

import com.hy.springpractice.model.Person;
import com.hy.springpractice.proxy.CglibProxyUtil;

public class CglibProxy {
	
	@Test
	public void test() {
		CglibProxyUtil cglibProxyUtil = new CglibProxyUtil(new Person());
		Person cglibProxyInstance = (Person) cglibProxyUtil.getCglibProxyInstance();
		cglibProxyInstance.ride();
	}
	
	
}

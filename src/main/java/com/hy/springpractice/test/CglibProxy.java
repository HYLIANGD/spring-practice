package com.hy.springpractice.test;

import org.junit.Test;

import com.hy.springpractice.container.CglibProxyUtil;
import com.hy.springpractice.model.Person;

public class CglibProxy {
	
	@Test
	public void test() {
		CglibProxyUtil cglibProxyUtil = new CglibProxyUtil(new Person());
		Person cglibProxyInstance = (Person) cglibProxyUtil.getCglibProxyInstance();
		cglibProxyInstance.ride();
	}
	
	
}

package com.hy.springpractice.proxy;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

public class CglibProxyUtil implements MethodInterceptor{
	
	Object realSubject;
	
	public CglibProxyUtil(Object realSubject) {
		super();
		this.realSubject = realSubject;
	}


	public Object getCglibProxyInstance() {
		return Enhancer.create(realSubject.getClass(), this);
	}
	
	
	@Override
	public Object intercept(Object arg0, Method method, Object[] args, MethodProxy arg3) throws Throwable {
		
		System.out.println("Call method by cglib");
		Object returnValue = method.invoke(realSubject, args);
		return returnValue;
	}

}

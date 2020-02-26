package com.hy.springpractice.container;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


public class DynamicProxyUtil{
	
	public static Object getDynamicProxy(Object realSubject) {
		
		CustomInvocationHandler customInvocationHandler = new CustomInvocationHandler(realSubject);
		
		return Proxy.newProxyInstance(realSubject.getClass().getClassLoader(), 
				realSubject.getClass().getInterfaces(), 
				customInvocationHandler);
	}	
}

class CustomInvocationHandler implements InvocationHandler{
	
	Object realSubject;
	
	public CustomInvocationHandler(Object realSubject) {
		super();
		this.realSubject = realSubject;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("Call method by DynamicProxy");
		Object returnValue = method.invoke(realSubject, args);
		return returnValue;
	}
}

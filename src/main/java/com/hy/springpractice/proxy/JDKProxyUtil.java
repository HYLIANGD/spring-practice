package com.hy.springpractice.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JDKProxyUtil {

	public static Object getJDKProxy(Object realSubject) {

		CustomInvocationHandler customInvocationHandler = new CustomInvocationHandler(realSubject);

		return Proxy.newProxyInstance(realSubject.getClass().getClassLoader(), realSubject.getClass().getInterfaces(),
				customInvocationHandler);
	}
}

class CustomInvocationHandler extends JDKProxyUtil implements InvocationHandler {

	Object realSubject;

	public CustomInvocationHandler(Object realSubject) {
		super();
		this.realSubject = realSubject;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("Call method by JDKProxy");
		Object returnValue = method.invoke(realSubject, args);
		return returnValue;
	}
}

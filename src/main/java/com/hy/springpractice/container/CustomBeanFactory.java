package com.hy.springpractice.container;

public interface CustomBeanFactory {
	
	public <T> T getBean(String id, Class<T> clazz) throws Exception;
	
}

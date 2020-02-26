package com.hy.springpractice.container;

public class CustomContext implements CustomBeanFactory{
	
	private CustomBeanFactory customBeanFactory;

	public CustomContext() {
		this.customBeanFactory = new CustomBeanFactoryImpl();
	}
	
	public <T> T getBean(String id, Class<T> clazz) throws Exception{
		return customBeanFactory.getBean(id, clazz);
	}
	
	
	
	
	
}

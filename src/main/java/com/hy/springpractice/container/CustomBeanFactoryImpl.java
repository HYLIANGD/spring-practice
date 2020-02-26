package com.hy.springpractice.container;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Parameter;

import org.springframework.beans.factory.annotation.Qualifier;


public class CustomBeanFactoryImpl implements CustomBeanFactory {
	/*
	 * Reflection creates bean. 
	 */
	@Override
	public <T> T getBean(String id, Class<T> clazz) throws Exception{
		T bean = null;
		Constructor<?>[] constructors = clazz.getConstructors();
		for(Constructor<?> constructor : constructors) {
			Annotation[] annotations = constructor.getAnnotations();
			if(annotations.length > 0) {
				for(Annotation annotation : annotations) {
					if(annotation.toString().contains("Autowired")){
						Parameter[] parameters = constructor.getParameters();
						for(Parameter parameter : parameters) {
							if(parameter.getType().isInterface()) {
								if(parameter.getAnnotation(Qualifier.class) != null) {
									String value = parameter.getAnnotation(Qualifier.class).value();
									value = value.toUpperCase().charAt(0) + value.substring(1);
									value = "com.hy.springpractice.model.autowired." + value;
									Class<?> parameterClass = Class.forName(value);
									Object newInstance = parameterClass.getDeclaredConstructor().newInstance();
									Object constructorBean = getBean("pointless", newInstance.getClass());
									
									bean = (T) constructor.newInstance(constructorBean);
									return bean;
								}
							}
						}
					}
				}
			}
		}
		return clazz.getDeclaredConstructor().newInstance();
	}

	

}

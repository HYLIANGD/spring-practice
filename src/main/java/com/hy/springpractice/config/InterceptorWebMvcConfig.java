package com.hy.springpractice.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.hy.springpractice.interceptor.MotoInterceptor;

@Configuration
@EnableWebMvc
public class InterceptorWebMvcConfig implements WebMvcConfigurer {
	
	@Autowired
    private MotoInterceptor motoInterceptor;
    
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(motoInterceptor).addPathPatterns("/moto/**");
    }
	
}

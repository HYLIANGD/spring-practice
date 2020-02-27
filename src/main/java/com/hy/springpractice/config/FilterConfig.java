//package com.hy.springpractice.config;
//
//import org.springframework.boot.web.servlet.FilterRegistrationBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import com.hy.springpractice.filter.TransactionFilter;
//
//@Configuration
//public class FilterConfig {
//	
//	@Bean
//	public FilterRegistrationBean<TransactionFilter> testFilter(){
//		
//		FilterRegistrationBean<TransactionFilter> filterRegistrationBean = new FilterRegistrationBean<TransactionFilter>();
//		
//		filterRegistrationBean.setFilter(new TransactionFilter());
//		filterRegistrationBean.addUrlPatterns("/moto/*");
//		
//		return filterRegistrationBean;
//	}
//	
//	
//}

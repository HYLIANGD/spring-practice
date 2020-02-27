package com.hy.springpractice.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebFilter(filterName = "firstFilter",
	displayName = "firstFilter",
	urlPatterns = {"*"},
	initParams = @WebInitParam(name = "firstIndexFilterInitParam",
	        value = "com.hy.springpractice.filter.FirstFilter")
)
public class FirstFilter implements Filter {
	
	Logger logger = LoggerFactory.getLogger(FirstFilter.class);

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		logger.info("Register a new filter {}", filterConfig.getFilterName());
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		logger.info("pre first: " +  httpRequest.getRequestURI());
		
		chain.doFilter(request, response);
		logger.info("post first: " +  httpRequest.getRequestURI());

	}

	@Override
	public void destroy() {
		logger.info("filter destroy method");
	}
}

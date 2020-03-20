package com.hy.springpractice.entrypoint;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class MyAuthEntryPoint implements AuthenticationEntryPoint {

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException, ServletException {

		
		System.out.println("MyAuthEntryPoint開始執行");
		ObjectMapper mapper = new ObjectMapper();
        Map<String, String> map = Map.of("error", "請先登入才能進行此操作");
        String error = mapper.writeValueAsString(map);
        response.setContentType("application/json;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setStatus(response.SC_UNAUTHORIZED);
        PrintWriter writer = response.getWriter();
        writer.write(error);
        writer.flush();
        writer.close();
		

	}

}

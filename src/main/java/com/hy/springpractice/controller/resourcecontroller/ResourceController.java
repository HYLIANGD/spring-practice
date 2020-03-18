package com.hy.springpractice.controller.resourcecontroller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class ResourceController {
	
	@GetMapping
	public String getIndex(Authentication authentication) {
		return "index";
	}
	
	@GetMapping("/function")
	public String getFunction(Authentication authentication) {
		return "function";
	}
	
	@GetMapping("/denied")
	public String getDenied(Authentication authentication) {
		return "accessdenied";
	}
	
}

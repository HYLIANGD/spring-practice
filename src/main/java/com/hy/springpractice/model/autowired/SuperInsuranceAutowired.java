package com.hy.springpractice.model.autowired;

import org.springframework.stereotype.Component;

@Component
public class SuperInsuranceAutowired implements InsuranceAutowired{
	
	public SuperInsuranceAutowired() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String getInsuranceContent() {
		return "Cover everything";
	}

	@Override
	public Integer getInsuraceFee() {
		return 100000;
	}

}

package com.hy.springpractice.model.autowired;

import org.springframework.stereotype.Component;

@Component
public class TrafficInsurance implements Insurance {
	
	@Override
	public String getInsuranceContent() {
		return "This insurance only include traffic accident";
	}

	@Override
	public Integer getInsuraceFee() {
		return 1000;
	}

	

}

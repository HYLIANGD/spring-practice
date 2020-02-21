package com.hy.springpractice.model;




public class SuperInsurance implements Insurance{

	@Override
	public String getInsuranceContent() {
		return "Cover everything";
	}

	@Override
	public Integer getInsuraceFee() {
		return 100000;
	}

}

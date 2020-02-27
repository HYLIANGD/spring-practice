package com.hy.springpractice.model.autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class ScooterAutowired extends MotoAutowired{
	
	private int trunk;
	
	public ScooterAutowired() {
	}
	
	@Autowired
	public ScooterAutowired(@Qualifier("trafficInsuranceAutowired") InsuranceAutowired insurance) {
		super(insurance);
	}

	public int getTrunk() {
		return trunk;
	}

	public void setTrunk(int trunk) {
		this.trunk = trunk;
	}

	@Override
	public String toString() {
		return "Scooter [Brand = " + getBrand() + ", Model = " + getModelName() + ", Displacement = "
				+ getDisplacement() + ", Insurance = " + getInsurance().getInsuranceContent() + ", Trunk = "
				+ trunk + "]";
	}
	
	
	
}

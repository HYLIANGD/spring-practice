package com.hy.springpractice.model;

public class Scooter extends Moto{
	
	private int trunk;
	
	public Scooter() {
	}
	
	public Scooter(Insurance insurance) {
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

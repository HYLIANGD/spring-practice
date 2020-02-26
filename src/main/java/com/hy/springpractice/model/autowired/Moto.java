package com.hy.springpractice.model.autowired;




public abstract class Moto {
	
	private String brand;
	private String modelName;
	private int displacement;
	private Insurance insurance;
	
	public Moto() {
		super();
	}
	
	public Moto(Insurance insurance) {
		super();
		this.insurance = insurance;
	}

	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getModelName() {
		return modelName;
	}
	public void setModelName(String modelName) {
		this.modelName = modelName;
	}
	public int getDisplacement() {
		return displacement;
	}
	public void setDisplacement(int displacement) {
		this.displacement = displacement;
	}
	public Insurance getInsurance() {
		return insurance;
	}
	public void setInsurance(Insurance insurance) {
		this.insurance = insurance;
	}
	
	
	
	
}

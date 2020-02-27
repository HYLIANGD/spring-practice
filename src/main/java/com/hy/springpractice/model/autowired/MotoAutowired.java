package com.hy.springpractice.model.autowired;




public abstract class MotoAutowired {
	
	private String brand;
	private String modelName;
	private int displacement;
	private InsuranceAutowired insurance;
	
	public MotoAutowired() {
		super();
	}
	
	public MotoAutowired(InsuranceAutowired insurance) {
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
	public InsuranceAutowired getInsurance() {
		return insurance;
	}
	public void setInsurance(InsuranceAutowired insurance) {
		this.insurance = insurance;
	}
	
	
	
	
}

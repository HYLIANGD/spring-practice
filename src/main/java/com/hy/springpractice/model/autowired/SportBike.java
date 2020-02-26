package com.hy.springpractice.model.autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
//@Scope("prototype")
public class SportBike extends Moto {

	private String trackRecord;
	private String certificationLevel;

	public SportBike() {
	}
	
	@Autowired
	public SportBike(@Qualifier("superInsurance") Insurance insurance) {
		super(insurance);
	}

	public String getTrackRecord() {
		return trackRecord;
	}

	public void setTrackRecord(String trackRecord) {
		this.trackRecord = trackRecord;
	}

	public String getCertificationLevel() {
		return certificationLevel;
	}

	public void setCertificationLevel(String certificationLevel) {
		this.certificationLevel = certificationLevel;
	}


	@Override
	public String toString() {
		return "SportBike [Brand = " + getBrand() + ", Model = " + getModelName() + ", Displacement = "
				+ getDisplacement() + ", Insurance = " + getInsurance().getInsuranceContent() + ", Level = "
				+ certificationLevel + ", Track record =" + trackRecord + "]";
	}

	

	
	
	
	
	

}

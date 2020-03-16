package com.hy.springpractice.model;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "country")
//問題: 反序列化fail
@JsonIgnoreProperties(value={"hibernateLazyInitializer","handler","fieldHandler"})
public class Country {
	
	@Id
	private String code;
	private String name;
	private String continent;
	private String region;
	@Column(name = "surfacearea")
	private Double surfaceArea;
	@Column(name = "indepyear")
	private Double indepYear;
	private Integer population;
	@Column(name = "lifeexpectancy")
	private Double lifeExpectancy;
	@Column(name = "gnp")
	private Double gNP;
	@Column(name = "gnpold")
	private Double gNPOld;
	@Column(name = "localname")
	private String localName;
	@Column(name = "governmentform")
	private String governmentForm;
	@Column(name = "headofstate")
	private String headOfState;
	private Integer capital;
	private String code2;

	/**
	 * No args constructor for use in serialization
	 *
	 */
	public Country() {
	}

	/**
	 *
	 * @param continent
	 * @param capital
	 * @param code2
	 * @param code
	 * @param surfaceArea
	 * @param governmentForm
	 * @param indepYear
	 * @param gNP
	 * @param gNPOld
	 * @param population
	 * @param lifeExpectancy
	 * @param localName
	 * @param headOfState
	 * @param name
	 * @param region
	 */
	public Country(String code, String name, String continent, String region, Double surfaceArea, Double indepYear,
			Integer population, Double lifeExpectancy, Double gNP, Double gNPOld, String localName,
			String governmentForm, String headOfState, Integer capital, String code2) {
		super();
		this.code = code;
		this.name = name;
		this.continent = continent;
		this.region = region;
		this.surfaceArea = surfaceArea;
		this.indepYear = indepYear;
		this.population = population;
		this.lifeExpectancy = lifeExpectancy;
		this.gNP = gNP;
		this.gNPOld = gNPOld;
		this.localName = localName;
		this.governmentForm = governmentForm;
		this.headOfState = headOfState;
		this.capital = capital;
		this.code2 = code2;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContinent() {
		return continent;
	}

	public void setContinent(String continent) {
		this.continent = continent;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public Double getSurfaceArea() {
		return surfaceArea;
	}

	public void setSurfaceArea(Double surfaceArea) {
		this.surfaceArea = surfaceArea;
	}

	public Double getIndepYear() {
		return indepYear;
	}

	public void setIndepYear(Double indepYear) {
		this.indepYear = indepYear;
	}

	public Integer getPopulation() {
		return population;
	}

	public void setPopulation(Integer population) {
		this.population = population;
	}

	public Double getLifeExpectancy() {
		return lifeExpectancy;
	}

	public void setLifeExpectancy(Double lifeExpectancy) {
		this.lifeExpectancy = lifeExpectancy;
	}

	public Double getGNP() {
		return gNP;
	}

	public void setGNP(Double gNP) {
		this.gNP = gNP;
	}

	public Double getGNPOld() {
		return gNPOld;
	}

	public void setGNPOld(Double gNPOld) {
		this.gNPOld = gNPOld;
	}

	public String getLocalName() {
		return localName;
	}

	public void setLocalName(String localName) {
		this.localName = localName;
	}

	public String getGovernmentForm() {
		return governmentForm;
	}

	public void setGovernmentForm(String governmentForm) {
		this.governmentForm = governmentForm;
	}

	public String getHeadOfState() {
		return headOfState;
	}

	public void setHeadOfState(String headOfState) {
		this.headOfState = headOfState;
	}

	public Integer getCapital() {
		return capital;
	}

	public void setCapital(Integer capital) {
		this.capital = capital;
	}

	public String getCode2() {
		return code2;
	}

	public void setCode2(String code2) {
		this.code2 = code2;
	}

	

}
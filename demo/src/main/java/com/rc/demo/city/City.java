package com.rc.demo.city;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="city")
public class City implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7039125797592925743L;
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String name;
	
	@Column(name="code")
	private String countryCode;
	
	private String district;
	
	private int population;
	
	public City() {
		
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(final String countryCode) {
		this.countryCode = countryCode;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(final String district) {
		this.district = district;
	}

	public int getPopulation() {
		return population;
	}

	public void setPopulation(final int population) {
		this.population = population;
	}
}
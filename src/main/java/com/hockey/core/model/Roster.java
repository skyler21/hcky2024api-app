package com.hockey.core.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // This tells Hibernate to make a table out of this class
public class Roster {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private Integer rosterId;
	private String firstName;
	private String lastName;
	private Integer sweaterNumber;
	private String positionCode;
	private String shootsCatches;
	private Integer heightInches;
	private Integer weightPounds;
	private String birthDate;
	private String birthCity;
	private String birthCountry;
	private String birthStateProvince;

	public Roster() {
	}

	public Roster(Integer id, Integer rosterId, String firstName, String lastName, Integer sweaterNumber, String positionCode, String shootsCatches, Integer heightInches, Integer weightPounds, String birthDate, String birthCity, String birthCountry, String birthStateProvince) {
		super();
		this.id = id;
		this.rosterId = rosterId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.sweaterNumber = sweaterNumber;
		this.positionCode = positionCode;
		this.shootsCatches = shootsCatches;
		this.heightInches = heightInches;
		this.weightPounds = weightPounds;
		this.birthDate = birthDate;
		this.birthCity = birthCity;
		this.birthCountry = birthCountry;
		this.birthStateProvince = birthStateProvince;
	
	}

	@Override
	public String toString() {
		return "Roster [id=" + id + ", rosterId=" + rosterId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", sweaterNumber=" + sweaterNumber + ", positionCode=" + positionCode + ", shootsCatches="
				+ shootsCatches + ", heightInches=" + heightInches + ", weightPounds=" + weightPounds + ", birthDate="
				+ birthDate + ", birthCity=" + birthCity + ", birthCountry=" + birthCountry + ", birthStateProvince="
				+ birthStateProvince + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getRosterId() {
		return rosterId;
	}

	public void setRosterId(Integer rosterId) {
		this.rosterId = rosterId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getSweaterNumber() {
		return sweaterNumber;
	}

	public void setSweaterNumber(Integer sweaterNumber) {
		this.sweaterNumber = sweaterNumber;
	}

	public String getPositionCode() {
		return positionCode;
	}

	public void setPositionCode(String positionCode) {
		this.positionCode = positionCode;
	}

	public String getShootsCatches() {
		return shootsCatches;
	}

	public void setShootsCatches(String shootsCatches) {
		this.shootsCatches = shootsCatches;
	}

	public Integer getHeightInches() {
		return heightInches;
	}

	public void setHeightInches(Integer heightInches) {
		this.heightInches = heightInches;
	}

	public Integer getWeightPounds() {
		return weightPounds;
	}

	public void setWeightPounds(Integer weightPounds) {
		this.weightPounds = weightPounds;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public String getBirthCity() {
		return birthCity;
	}

	public void setBirthCity(String birthCity) {
		this.birthCity = birthCity;
	}

	public String getBirthCountry() {
		return birthCountry;
	}

	public void setBirthCountry(String birthCountry) {
		this.birthCountry = birthCountry;
	}

	public String getBirthStateProvince() {
		return birthStateProvince;
	}

	public void setBirthStateProvince(String birthStateProvince) {
		this.birthStateProvince = birthStateProvince;
	}

	
}

package com.hockey.core.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // This tells Hibernate to make a table out of this class
public class Franchise {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private Integer franchiseId;
	private String fullName;
	private String teamCommonName;
	private String teamPlaceName;

	public Franchise() {
	}

	public Franchise(Integer id, Integer franchiseId, String fullNname, String teamCommonName, String teamPlaceName) {
		super();
		this.id = id;
		this.franchiseId = franchiseId;
		this.fullName = fullNname;
		this.teamCommonName = teamCommonName;
		this.teamPlaceName = teamPlaceName;

	}

	@Override
	public String toString() {
		return "Franchise [id=" + id  + ", franchiseId= " + franchiseId + ", fullName=" + fullName + ", teamCommonName=" + teamCommonName + ", teamPlaceName=" + teamPlaceName + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getFranchiseId() {
		return franchiseId;
	}

	public void setFranchiseId(Integer franchiseId) {
		this.franchiseId = franchiseId;
	}
    public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getTeamCommonName() {
		return teamCommonName;
	}

	public void setTeamCommonName(String teamCommonName) {
		this.teamCommonName = teamCommonName;
	}

	public String getTeamPlaceName() {
		return teamPlaceName;
	}

	public void setTeamPlaceName(String teamPlaceName) {
		this.teamPlaceName = teamPlaceName;
	}

}

package com.hockey.core.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // This tells Hibernate to make a table out of this class
public class Team {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private Integer teamId;
	private Integer franchiseId;
	private String fullName;
	private Integer leagueId;
	private String rawTricode;
	private String triCode;

	public Team() {
	}

	public Team(Integer id, Integer teamId, Integer franchiseId, String fullNname, Integer leagueId, String rawTricode,
			String triCode) {
		super();
		this.id = id;
		this.teamId = teamId;
		this.franchiseId = franchiseId;
		this.fullName = fullNname;
		this.leagueId = leagueId;
		this.rawTricode = rawTricode;
		this.triCode = triCode;

	}

	@Override
	public String toString() {
		return "Team [id=" + id  + ", teamId=" + teamId +  ", franchiseId= " + franchiseId + ", fullName=" + fullName + ", leagueId=" + leagueId
				+ ", rawTricode=" + rawTricode + ", triCode=" + triCode + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getTeamId() {
		return teamId;
	}

	public void setTeamId(Integer teamId) {
		this.teamId = teamId;
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

	public Integer getLeagueId() {
		return leagueId;
	}

	public void setLeagueId(Integer leagueId) {
		this.leagueId = leagueId;
	}

	public String getRawTricode() {
		return rawTricode;
	}

	public void setRawTricode(String rawTricode) {
		this.rawTricode = rawTricode;
	}

	public String getTriCode() {
		return triCode;
	}

	public void setTriCode(String triCode) {
		this.triCode = triCode;
	}

}

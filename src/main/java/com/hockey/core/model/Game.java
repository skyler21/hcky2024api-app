package com.hockey.core.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity // This tells Hibernate to make a table out of this class
public class Game {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private Integer gameId;
	private String easternStartTime;
	private String gameDate;
	private Integer gameNumber;
	private Integer gameScheduleStateId;
	private Integer gameStateId;
	private Integer gameType;
	private String  gameTypeDesc;
	private Integer homeScore;
	private Integer homeTeamId;
	private String  homeTeamFullName;
	private Integer period;
	private Integer season;
	private Integer visitingScore;
	private Integer visitingTeamId;
	private String  visitingTeamFullName;
	private String  lastPeriodType;
	
	public Game() {
	}

	public Game(Integer id, Integer gameId, String easternStartTime, String gameDate, Integer gameNumber, Integer gameScheduleStateId, Integer gameStateId, Integer gameType, String gameTypeDesc, Integer homeScore, Integer homeTeamId, String homeTeamFullName, Integer period, Integer season, Integer visitingScore, Integer visitingTeamId, String visitingTeamFullName, String lastPeriodType) {
		super();
		this.id = id;
		this.gameId = gameId;
	    this.easternStartTime =easternStartTime;
    	this.gameDate = gameDate;
		this.gameNumber = gameNumber;
		this.gameScheduleStateId = gameScheduleStateId;
		this.gameStateId = gameStateId;
		this.gameType = gameType;
		this.gameTypeDesc = gameTypeDesc;
		this.homeScore = homeScore;
		this.homeTeamId = homeTeamId;
		this.homeTeamFullName = homeTeamFullName;
		this.period = period;
		this.season = season;
		this.visitingScore = visitingScore;
		this.visitingTeamId = visitingTeamId;
		this.visitingTeamFullName = visitingTeamFullName;
		this.lastPeriodType = lastPeriodType; 
		
	}

	@Override
	public String toString() {
		return "Game [id=" + id + ", gameId=" + gameId + ", easternStartTime=" + easternStartTime + ", gameDate="
				+ gameDate + ", gameNumber=" + gameNumber + ", gameScheduleStateId=" + gameScheduleStateId
				+ ", gameStateId=" + gameStateId + ", gameType=" + gameType + ", gameTypeDesc=" + gameTypeDesc + ", homeScore=" + homeScore
				+ ", homeTeamId=" + homeTeamId + ", homeTeamFullName=" + homeTeamFullName + ", period=" + period + ", season=" + season + ", visitingScore="
				+ visitingScore + ", visitingTeamId=" + visitingTeamId + ", visitingTeamFullName=" + visitingTeamFullName + ", lastPeriodType=" + lastPeriodType +  "]" ;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getGameId() {
		return gameId;
	}

	public void setGameId(Integer gameId) {
		this.gameId = gameId;
	}

	public String getEasternStartTime() {
		return easternStartTime;
	}

	public void setEasternStartTime(String easternStartTime) {
		this.easternStartTime = easternStartTime;
	}

	public String getGameDate() {
		return gameDate;
	}

	public void setGameDate(String gameDate) {
		this.gameDate = gameDate;
	}

	public Integer getGameNumber() {
		return gameNumber;
	}

	public void setGameNumber(Integer gameNumber) {
		this.gameNumber = gameNumber;
	}

	public Integer getGameScheduleStateId() {
		return gameScheduleStateId;
	}

	public void setGameScheduleStateId(Integer gameScheduleStateId) {
		this.gameScheduleStateId = gameScheduleStateId;
	}

	public Integer getGameStateId() {
		return gameStateId;
	}

	public void setGameStateId(Integer gameStateId) {
		this.gameStateId = gameStateId;
	}

	public Integer getGameType() {
		return gameType;
	}

	public void setGameType(Integer gameType) {
		this.gameType = gameType;
	}

	public String getGameTypeDesc() {
		return gameTypeDesc;
	}

	public void setGameTypeDesc(String gameTypeDesc) {
		this.gameTypeDesc = gameTypeDesc;
	}

	public Integer getHomeScore() {
		return homeScore;
	}

	public void setHomeScore(Integer homeScore) {
		this.homeScore = homeScore;
	}

	public Integer getHomeTeamId() {
		return homeTeamId;
	}

	public void setHomeTeamId(Integer homeTeamId) {
		this.homeTeamId = homeTeamId;
	}

	public String getHomeTeamFullName() {
		return homeTeamFullName;
	}

	public void setHomeTeamFullName(String homeTeamFullName) {
		this.homeTeamFullName = homeTeamFullName;
	}

	public Integer getPeriod() {
		return period;
	}

	public void setPeriod(Integer period) {
		this.period = period;
	}

	public Integer getSeason() {
		return season;
	}

	public void setSeason(Integer season) {
		this.season = season;
	}

	public Integer getVisitingScore() {
		return visitingScore;
	}

	public void setVisitingScore(Integer visitingScore) {
		this.visitingScore = visitingScore;
	}

	public Integer getVisitinfTeamId() {
		return visitingTeamId;
	}

	public void setVisitingTeamId(Integer visitingTeamId) {
		this.visitingTeamId = visitingTeamId;
	}

	public String getVisitingTeamFullName() {
		return visitingTeamFullName;
	}

	public void setVisitingTeamFullName(String visitingTeamFullName) {
		this.visitingTeamFullName = visitingTeamFullName;
	}

	public String getLastPeriodType() {
		return lastPeriodType;
	}

	public void setLastPeriodType(String lastPeriodType) {
		this.lastPeriodType = lastPeriodType;
	}


}

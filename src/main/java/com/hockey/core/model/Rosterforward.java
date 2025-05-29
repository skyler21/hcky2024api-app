package com.hockey.core.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
//import jakarta.persistence.criteria.CriteriaBuilder.In;

@Entity // This tells Hibernate to make a table out of this class
public class Rosterforward {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private Integer rosterId;
	private Boolean isActive;
	private Integer currentTeamId;
	private Integer seasonYear;
	private String seasonType;
    private Integer gamesAssists;
    private Integer gameWinningGoals;
	private Integer gamesPlayed;
	private Integer gameGoals;
	private Integer gameOtGoals;
	private Integer gamePim;
	private Integer gamePlusMinus; 
	private Integer gamePoints; 
	private Integer gamePowerPlayGoals; 
	private Integer gamePowerPlayPoints; 
	private Integer gameShorthandedGoals; 
	private Integer gameShorthandedPoints; 
	private Integer gameShots;
	private Integer last5games01Assists; 
	private String last5games01Date; 
	private Integer last5games01GameId; 
	private Integer last5games01GameTypeId; 
	private Integer last5games01Goals; 
	private String last5games01HomeRoadFlag; 
	private String last5games01OpponentAbbrv; 
	private Integer last5games01Pim; 
	private Integer last5games01PlusMinus; 
	private Integer last5games01Points; 
	private Integer last5games01PowerplayGoals; 
	private Integer last5games01Shifts; 
	private Integer last5games01ShorthandedGoals; 
	private Integer last5games01Shots;
	private String last5games01Toi; 
	private Integer last5games02Assists; 
	private String last5games02Date; 
	private Integer last5games02GameId; 
	private Integer last5games02GameTypeId; 
	private Integer last5games02Goals; 
	private String last5games02HomeRoadFlag; 
	private String last5games02OpponentAbbrv; 
	private Integer last5games02Pim; 
	private Integer last5games02PlusMinus; 
	private Integer last5games02Points; 
	private Integer last5games02PowerplayGoals; 
	private Integer last5games02Shifts; 
	private Integer last5games02ShorthandedGoals; 
	private Integer last5games02Shots;
	private String last5games02Toi;
	private Integer last5games03Assists; 
	private String last5games03Date; 
	private Integer last5games03GameId; 
	private Integer last5games03GameTypeId; 
	private Integer last5games03Goals; 
	private String last5games03HomeRoadFlag; 
	private String last5games03OpponentAbbrv; 
	private Integer last5games03Pim; 
	private Integer last5games03PlusMinus; 
	private Integer last5games03Points; 
	private Integer last5games03PowerplayGoals; 
	private Integer last5games03Shifts; 
	private Integer last5games03ShorthandedGoals; 
	private Integer last5games03Shots;
	private String last5games03Toi;  
	private Integer last5games04Assists; 
	private String last5games04Date; 
	private Integer last5games04GameId; 
	private Integer last5games04GameTypeId; 
	private Integer last5games04Goals; 
	private String last5games04HomeRoadFlag; 
	private String last5games04OpponentAbbrv; 
	private Integer last5games04Pim; 
	private Integer last5games04PlusMinus; 
	private Integer last5games04Points; 
	private Integer last5games04PowerplayGoals; 
	private Integer last5games04Shifts; 
	private Integer last5games04ShorthandedGoals; 
	private Integer last5games04Shots;
	private String last5games04Toi;
	private Integer last5games05Assists; 
	private String last5games05Date; 
	private Integer last5games05GameId; 
	private Integer last5games05GameTypeId; 
	private Integer last5games05Goals; 
	private String last5games05HomeRoadFlag; 
	private String last5games05OpponentAbbrv; 
	private Integer last5games05Pim; 
	private Integer last5games05PlusMinus; 
	private Integer last5games05Points; 
	private Integer last5games05PowerplayGoals; 
	private Integer last5games05Shifts; 
	private Integer last5games05ShorthandedGoals; 
	private Integer last5games05Shots;
	private String last5games05Toi;  
	private String firstName;
	private String lastName;
	private String teamAbbr;
    private Integer gameNumber;
	
	public Rosterforward() {
	}

	public Rosterforward(Integer id, Integer rosterId, Boolean isActive, Integer currentTeamId, Integer seasonYear, String seasonType, Integer gamesAssists, 
	                     Integer gameWinningGoals, Integer gamesPlayed, Integer gameGoals, Integer gameOtGoals, Integer gamePim, Integer gamePlusMinus, 
						 Integer gamePoints, Integer gamePowerPlayGoals, Integer gamePowerPlayPoints, Integer gameShorthandedGoals, Integer gameShorthandedPoints, 
						 Integer gameShots, Integer last5games01Assists, String last5games01Date, Integer last5games01GameId, Integer last5games01GameTypeId, 
						 Integer last5games01Goals, String last5games01HomeRoadFlag, String last5games01OpponentAbbrv, Integer last5games01Pim, 
						 Integer last5games01PlusMinus, Integer last5games01Points, Integer last5games01PowerplayGoals, Integer last5games01Shifts, 
						 Integer last5games01ShorthandedGoals, Integer last5games01Shots, String last5games01Toi, Integer last5games02Assists, 
						 String last5games02Date, Integer last5games02GameId, Integer last5games02GameTypeId, Integer last5games02Goals, 
						 String last5games02HomeRoadFlag, String last5games02OpponentAbbrv, Integer last5games02Pim, Integer last5games02PlusMinus, 
						 Integer last5games02Points, Integer last5games02PowerplayGoals, Integer last5games02Shifts, Integer last5games02ShorthandedGoals, 
						 Integer last5games02Shots, String last5games02Toi, Integer last5games03Assists, String last5games03Date, Integer last5games03GameId, 
						 Integer last5games03GameTypeId, Integer last5games03Goals, String last5games03HomeRoadFlag, String last5games03OpponentAbbrv, 
						 Integer last5games03Pim, Integer last5games03PlusMinus, Integer last5games03Points, Integer last5games03PowerplayGoals, 
						 Integer last5games03Shifts, Integer last5games03ShorthandedGoals, Integer last5games03Shots, String last5games03Toi, 
						 Integer last5games04Assists, String last5games04Date, Integer last5games04GameId, Integer last5games04GameTypeId, 
						 Integer last5games04Goals, String last5games04HomeRoadFlag, String last5games04OpponentAbbrv, Integer last5games04Pim, 
						 Integer last5games04PlusMinus, Integer last5games04Points, Integer last5games04PowerplayGoals, Integer last5games04Shifts, 
						 Integer last5games04ShorthandedGoals, Integer last5games04Shots, String last5games04Toi, Integer last5games05Assists, 
						 String last5games05Date, Integer last5games05GameId, Integer last5games05GameTypeId, Integer last5games05Goals, 
						 String last5games05HomeRoadFlag, String last5games05OpponentAbbrv, Integer last5games05Pim, Integer last5games05PlusMinus, 
						 Integer last5games05Points, Integer last5games05PowerplayGoals, Integer last5games05Shifts, Integer last5games05ShorthandedGoals, 
						 Integer last5games05Shots, String last5games05Toi, String firstName, String lastName, String teamAbbr, Integer gameNumber)   {
		super();
		this.id = id;
		this.rosterId = rosterId;
		this.isActive = isActive ;
		this.currentTeamId = currentTeamId;
		this.seasonYear = seasonYear;
		this.seasonType = seasonType;
		this.gamesAssists = gamesAssists;
		this.gameWinningGoals = gameWinningGoals;
		this.gamesPlayed = gamesPlayed;
		this.gameGoals = gameGoals;
		this.gameOtGoals = gameOtGoals;
		this.gamePim = gamePim;
		this.gamePlusMinus = gamePlusMinus; 
		this.gamePoints = gamePoints; 
		this.gamePowerPlayGoals = gamePowerPlayGoals; 
		this.gamePowerPlayPoints = gamePowerPlayPoints; 
		this.gameShorthandedGoals = gameShorthandedGoals; 
		this.gameShorthandedPoints = gameShorthandedPoints ; 
		this.gameShots = gameShots;
		this.last5games01Assists = last5games01Assists; 
		this.last5games01Date = last5games01Date; 
		this.last5games01GameId = last5games01GameId ; 
		this.last5games01GameTypeId = last5games01GameTypeId; 
		this.last5games01Goals = last5games01Goals; 
		this.last5games01HomeRoadFlag = last5games01HomeRoadFlag; 
		this.last5games01OpponentAbbrv = last5games01OpponentAbbrv; 
		this.last5games01Pim = last5games01Pim; 
		this.last5games01PlusMinus = last5games01PlusMinus; 
		this.last5games01Points = last5games01Points; 
		this.last5games01PowerplayGoals = last5games01PowerplayGoals; 
		this.last5games01Shifts = last5games01Shifts; 
		this.last5games01ShorthandedGoals = last5games01ShorthandedGoals; 
		this.last5games01Shots = last5games01Shots;
		this.last5games01Toi = last5games01Toi; 
		this.last5games02Assists = last5games02Assists; 
		this.last5games02Date = last5games02Date; 
		this.last5games02GameId = last5games02GameId; 
		this.last5games02GameTypeId = last5games02GameTypeId; 
		this.last5games02Goals = last5games02Goals; 
		this.last5games02HomeRoadFlag = last5games02HomeRoadFlag; 
		this.last5games02OpponentAbbrv = last5games02OpponentAbbrv; 
		this.last5games02Pim = last5games02Pim; 
		this.last5games02PlusMinus = last5games02PlusMinus; 
		this.last5games02Points = last5games02Points; 
		this.last5games02PowerplayGoals = last5games02PowerplayGoals; 
		this.last5games02Shifts = last5games02Shifts; 
		this.last5games02ShorthandedGoals = last5games02ShorthandedGoals; 
		this.last5games02Shots = last5games02Shots;
		this.last5games02Toi = last5games02Toi;
		this.last5games03Assists = last5games03Assists; 
		this.last5games03Date = last5games03Date; 
		this.last5games03GameId = last5games03GameId; 
		this.last5games03GameTypeId = last5games03GameTypeId; 
		this.last5games03Goals = last5games03Goals; 
		this.last5games03HomeRoadFlag = last5games03HomeRoadFlag; 
		this.last5games03OpponentAbbrv = last5games03OpponentAbbrv; 
		this.last5games03Pim = last5games03Pim; 
		this.last5games03PlusMinus = last5games03PlusMinus; 
		this.last5games03Points = last5games03Points; 
		this.last5games03PowerplayGoals = last5games03PowerplayGoals; 
		this.last5games03Shifts = last5games03Shifts; 
		this.last5games03ShorthandedGoals = last5games03ShorthandedGoals; 
		this.last5games03Shots = last5games03Shots;
		this.last5games03Toi = last5games03Toi;  
		this.last5games04Assists = last5games04Assists; 
		this.last5games04Date = last5games04Date; 
		this.last5games04GameId = last5games04GameId; 
		this.last5games04GameTypeId = last5games04GameTypeId; 
		this.last5games04Goals = last5games04Goals; 
		this.last5games04HomeRoadFlag = last5games04HomeRoadFlag; 
		this.last5games04OpponentAbbrv = last5games04OpponentAbbrv; 
		this.last5games04Pim = last5games04Pim; 
		this.last5games04PlusMinus = last5games04PlusMinus; 
		this.last5games04Points = last5games04Points; 
		this.last5games04PowerplayGoals = last5games04PowerplayGoals; 
		this.last5games04Shifts = last5games04Shifts; 
		this.last5games04ShorthandedGoals = last5games04ShorthandedGoals; 
		this.last5games04Shots = last5games04Shots;
		this.last5games04Toi = last5games04Toi;
		this.last5games05Assists = last5games05Assists; 
		this.last5games05Date = last5games05Date; 
		this.last5games05GameId = last5games05GameId; 
		this.last5games05GameTypeId = last5games05GameTypeId; 
		this.last5games05Goals = last5games05Goals; 
		this.last5games05HomeRoadFlag = last5games05HomeRoadFlag; 
		this.last5games05OpponentAbbrv = last5games05OpponentAbbrv; 
		this.last5games05Pim = last5games05Pim; 
		this.last5games05PlusMinus = last5games05PlusMinus; 
		this.last5games05Points = last5games05Points; 
		this.last5games05PowerplayGoals = last5games05PowerplayGoals; 
		this.last5games05Shifts = last5games05Shifts; 
		this.last5games05ShorthandedGoals = last5games05ShorthandedGoals; 
		this.last5games05Shots = last5games05Shots;
		this.last5games05Toi = last5games05Toi; 
		this.firstName = firstName;
		this.lastName = lastName;
		this.teamAbbr = teamAbbr; 
		this.gameNumber = gameNumber;

	}

	@Override
	public String toString() {
		return "Rosterforward [id=" + id + ", rosterId=" + rosterId + ", isActive=" + isActive + ", currentTeamId="
				+ currentTeamId + ", seasonYear=" + seasonYear + ", seasonType=" + seasonType + ", gamesAssists="
				+ gamesAssists + ", gameWinningGoals=" + gameWinningGoals + ", gamesPlayed=" + gamesPlayed
				+ ", gameGoals=" + gameGoals + ", gameOtGoals=" + gameOtGoals + ", gamePim=" + gamePim
				+ ", gamePlusMinus=" + gamePlusMinus + ", gamePoints=" + gamePoints + ", gamePowerPlayGoals="
				+ gamePowerPlayGoals + ", gamePowerPlayPoints=" + gamePowerPlayPoints + ", gameShorthandedGoals="
				+ gameShorthandedGoals + ", gameShorthandedPoints=" + gameShorthandedPoints + ", gameShots=" + gameShots
				+ ", last5games01Assists=" + last5games01Assists + ", last5games01Date=" + last5games01Date
				+ ", last5games01GameId=" + last5games01GameId + ", last5games01GameTypeId=" + last5games01GameTypeId
				+ ", last5games01Goals=" + last5games01Goals + ", last5games01HomeRoadFlag=" + last5games01HomeRoadFlag
				+ ", last5games01OpponentAbbrv=" + last5games01OpponentAbbrv + ", last5games01Pim=" + last5games01Pim
				+ ", last5games01PlusMinus=" + last5games01PlusMinus + ", last5games01Points=" + last5games01Points
				+ ", last5games01PowerplayGoals=" + last5games01PowerplayGoals + ", last5games01Shifts="
				+ last5games01Shifts + ", last5games01ShorthandedGoals=" + last5games01ShorthandedGoals
				+ ", last5games01Shots=" + last5games01Shots + ", last5games01Toi=" + last5games01Toi
				+ ", last5games02Assists=" + last5games02Assists + ", last5games02Date=" + last5games02Date
				+ ", last5games02GameId=" + last5games02GameId + ", last5games02GameTypeId=" + last5games02GameTypeId
				+ ", last5games02Goals=" + last5games02Goals + ", last5games02HomeRoadFlag=" + last5games02HomeRoadFlag
				+ ", last5games02OpponentAbbrv=" + last5games02OpponentAbbrv + ", last5games02Pim=" + last5games02Pim
				+ ", last5games02PlusMinus=" + last5games02PlusMinus + ", last5games02Points=" + last5games02Points
				+ ", last5games02PowerplayGoals=" + last5games02PowerplayGoals + ", last5games02Shifts="
				+ last5games02Shifts + ", last5games02ShorthandedGoals=" + last5games02ShorthandedGoals
				+ ", last5games02Shots=" + last5games02Shots + ", last5games02Toi=" + last5games02Toi
				+ ", last5games03Assists=" + last5games03Assists + ", last5games03Date=" + last5games03Date
				+ ", last5games03GameId=" + last5games03GameId + ", last5games03GameTypeId=" + last5games03GameTypeId
				+ ", last5games03Goals=" + last5games03Goals + ", last5games03HomeRoadFlag=" + last5games03HomeRoadFlag
				+ ", last5games03OpponentAbbrv=" + last5games03OpponentAbbrv + ", last5games03Pim=" + last5games03Pim
				+ ", last5games03PlusMinus=" + last5games03PlusMinus + ", last5games03Points=" + last5games03Points
				+ ", last5games03PowerplayGoals=" + last5games03PowerplayGoals + ", last5games03Shifts="
				+ last5games03Shifts + ", last5games03ShorthandedGoals=" + last5games03ShorthandedGoals
				+ ", last5games03Shots=" + last5games03Shots + ", last5games03Toi=" + last5games03Toi
				+ ", last5games04Assists=" + last5games04Assists + ", last5games04Date=" + last5games04Date
				+ ", last5games04GameId=" + last5games04GameId + ", last5games04GameTypeId=" + last5games04GameTypeId
				+ ", last5games04Goals=" + last5games04Goals + ", last5games04HomeRoadFlag=" + last5games04HomeRoadFlag
				+ ", last5games04OpponentAbbrv=" + last5games04OpponentAbbrv + ", last5games04Pim=" + last5games04Pim
				+ ", last5games04PlusMinus=" + last5games04PlusMinus + ", last5games04Points=" + last5games04Points
				+ ", last5games04PowerplayGoals=" + last5games04PowerplayGoals + ", last5games04Shifts="
				+ last5games04Shifts + ", last5games04ShorthandedGoals=" + last5games04ShorthandedGoals
				+ ", last5games04Shots=" + last5games04Shots + ", last5games04Toi=" + last5games04Toi
				+ ", last5games05Assists=" + last5games05Assists + ", last5games05Date=" + last5games05Date
				+ ", last5games05GameId=" + last5games05GameId + ", last5games05GameTypeId=" + last5games05GameTypeId
				+ ", last5games05Goals=" + last5games05Goals + ", last5games05HomeRoadFlag=" + last5games05HomeRoadFlag
				+ ", last5games05OpponentAbbrv=" + last5games05OpponentAbbrv + ", last5games05Pim=" + last5games05Pim
				+ ", last5games05PlusMinus=" + last5games05PlusMinus + ", last5games05Points=" + last5games05Points
				+ ", last5games05PowerplayGoals=" + last5games05PowerplayGoals + ", last5games05Shifts="
				+ last5games05Shifts + ", last5games05ShorthandedGoals=" + last5games05ShorthandedGoals
				+ ", last5games05Shots=" + last5games05Shots + ", last5games05Toi=" + last5games05Toi + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", teamAbbr=" + teamAbbr + ", gameNumber=" + gameNumber + "]";
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

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Integer getCurrentTeamId() {
		return currentTeamId;
	}

	public void setCurrentTeamId(Integer currentTeamId) {
		this.currentTeamId = currentTeamId;
	}

	public Integer getSeasonYear() {
		return seasonYear;
	}

	public void setSeasonYear(Integer seasonYear) {
		this.seasonYear = seasonYear;
	}

	public String getSeasonType() {
		return seasonType;
	}

	public void setSeasonType(String seasonType) {
		this.seasonType = seasonType;
	}

	public Integer getGamesAssists() {
		return gamesAssists;
	}

	public void setGamesAssists(Integer gamesAssists) {
		this.gamesAssists = gamesAssists;
	}

	public Integer getGameWinningGoals() {
		return gameWinningGoals;
	}

	public void setGameWinningGoals(Integer gameWinningGoals) {
		this.gameWinningGoals = gameWinningGoals;
	}

	public Integer getGamesPlayed() {
		return gamesPlayed;
	}

	public void setGamesPlayed(Integer gamesPlayed) {
		this.gamesPlayed = gamesPlayed;
	}

	public Integer getGameGoals() {
		return gameGoals;
	}

	public void setGameGoals(Integer gameGoals) {
		this.gameGoals = gameGoals;
	}

	public Integer getGameOtGoals() {
		return gameOtGoals;
	}

	public void setGameOtGoals(Integer gameOtGoals) {
		this.gameOtGoals = gameOtGoals;
	}

	public Integer getGamePim() {
		return gamePim;
	}

	public void setGamePim(Integer gamePim) {
		this.gamePim = gamePim;
	}

	public Integer getGamePlusMinus() {
		return gamePlusMinus;
	}

	public void setGamePlusMinus(Integer gamePlusMinus) {
		this.gamePlusMinus = gamePlusMinus;
	}

	public Integer getGamePoints() {
		return gamePoints;
	}

	public void setGamePoints(Integer gamePoints) {
		this.gamePoints = gamePoints;
	}

	public Integer getGamePowerPlayGoals() {
		return gamePowerPlayGoals;
	}

	public void setGamePowerPlayGoals(Integer gamePowerPlayGoals) {
		this.gamePowerPlayGoals = gamePowerPlayGoals;
	}

	public Integer getGamePowerPlayPoints() {
		return gamePowerPlayPoints;
	}

	public void setGamePowerPlayPoints(Integer gamePowerPlayPoints) {
		this.gamePowerPlayPoints = gamePowerPlayPoints;
	}

	public Integer getGameShorthandedGoals() {
		return gameShorthandedGoals;
	}

	public void setGameShorthandedGoals(Integer gameShorthandedGoals) {
		this.gameShorthandedGoals = gameShorthandedGoals;
	}

	public Integer getGameShorthandedPoints() {
		return gameShorthandedPoints;
	}

	public void setGameShorthandedPoints(Integer gameShorthandedPoints) {
		this.gameShorthandedPoints = gameShorthandedPoints;
	}

	public Integer getGameShots() {
		return gameShots;
	}

	public void setGameShots(Integer gameShots) {
		this.gameShots = gameShots;
	}

	public Integer getLast5games01Assists() {
		return last5games01Assists;
	}

	public void setLast5games01Assists(Integer last5games01Assists) {
		this.last5games01Assists = last5games01Assists;
	}

	public String getLast5games01Date() {
		return last5games01Date;
	}

	public void setLast5games01Date(String last5games01Date) {
		this.last5games01Date = last5games01Date;
	}

	public Integer getLast5games01GameId() {
		return last5games01GameId;
	}

	public void setLast5games01GameId(Integer last5games01GameId) {
		this.last5games01GameId = last5games01GameId;
	}

	public Integer getLast5games01GameTypeId() {
		return last5games01GameTypeId;
	}

	public void setLast5games01GameTypeId(Integer last5games01GameTypeId) {
		this.last5games01GameTypeId = last5games01GameTypeId;
	}

	public Integer getLast5games01Goals() {
		return last5games01Goals;
	}

	public void setLast5games01Goals(Integer last5games01Goals) {
		this.last5games01Goals = last5games01Goals;
	}

	public String getLast5games01HomeRoadFlag() {
		return last5games01HomeRoadFlag;
	}

	public void setLast5games01HomeRoadFlag(String last5games01HomeRoadFlag) {
		this.last5games01HomeRoadFlag = last5games01HomeRoadFlag;
	}

	public String getLast5games01OpponentAbbrv() {
		return last5games01OpponentAbbrv;
	}

	public void setLast5games01OpponentAbbrv(String last5games01OpponentAbbrv) {
		this.last5games01OpponentAbbrv = last5games01OpponentAbbrv;
	}

	public Integer getLast5games01Pim() {
		return last5games01Pim;
	}

	public void setLast5games01Pim(Integer last5games01Pim) {
		this.last5games01Pim = last5games01Pim;
	}

	public Integer getLast5games01PlusMinus() {
		return last5games01PlusMinus;
	}

	public void setLast5games01PlusMinus(Integer last5games01PlusMinus) {
		this.last5games01PlusMinus = last5games01PlusMinus;
	}

	public Integer getLast5games01Points() {
		return last5games01Points;
	}

	public void setLast5games01Points(Integer last5games01Points) {
		this.last5games01Points = last5games01Points;
	}

	public Integer getLast5games01PowerplayGoals() {
		return last5games01PowerplayGoals;
	}

	public void setLast5games01PowerplayGoals(Integer last5games01PowerplayGoals) {
		this.last5games01PowerplayGoals = last5games01PowerplayGoals;
	}

	public Integer getLast5games01Shifts() {
		return last5games01Shifts;
	}

	public void setLast5games01Shifts(Integer last5games01Shifts) {
		this.last5games01Shifts = last5games01Shifts;
	}

	public Integer getLast5games01ShorthandedGoals() {
		return last5games01ShorthandedGoals;
	}

	public void setLast5games01ShorthandedGoals(Integer last5games01ShorthandedGoals) {
		this.last5games01ShorthandedGoals = last5games01ShorthandedGoals;
	}

	public Integer getLast5games01Shots() {
		return last5games01Shots;
	}

	public void setLast5games01Shots(Integer last5games01Shots) {
		this.last5games01Shots = last5games01Shots;
	}

	public String getLast5games01Toi() {
		return last5games01Toi;
	}

	public void setLast5games01Toi(String last5games01Toi) {
		this.last5games01Toi = last5games01Toi;
	}

	public Integer getLast5games02Assists() {
		return last5games02Assists;
	}

	public void setLast5games02Assists(Integer last5games02Assists) {
		this.last5games02Assists = last5games02Assists;
	}

	public String getLast5games02Date() {
		return last5games02Date;
	}

	public void setLast5games02Date(String last5games02Date) {
		this.last5games02Date = last5games02Date;
	}

	public Integer getLast5games02GameId() {
		return last5games02GameId;
	}

	public void setLast5games02GameId(Integer last5games02GameId) {
		this.last5games02GameId = last5games02GameId;
	}

	public Integer getLast5games02GameTypeId() {
		return last5games02GameTypeId;
	}

	public void setLast5games02GameTypeId(Integer last5games02GameTypeId) {
		this.last5games02GameTypeId = last5games02GameTypeId;
	}

	public Integer getLast5games02Goals() {
		return last5games02Goals;
	}

	public void setLast5games02Goals(Integer last5games02Goals) {
		this.last5games02Goals = last5games02Goals;
	}

	public String getLast5games02HomeRoadFlag() {
		return last5games02HomeRoadFlag;
	}

	public void setLast5games02HomeRoadFlag(String last5games02HomeRoadFlag) {
		this.last5games02HomeRoadFlag = last5games02HomeRoadFlag;
	}

	public String getLast5games02OpponentAbbrv() {
		return last5games02OpponentAbbrv;
	}

	public void setLast5games02OpponentAbbrv(String last5games02OpponentAbbrv) {
		this.last5games02OpponentAbbrv = last5games02OpponentAbbrv;
	}

	public Integer getLast5games02Pim() {
		return last5games02Pim;
	}

	public void setLast5games02Pim(Integer last5games02Pim) {
		this.last5games02Pim = last5games02Pim;
	}

	public Integer getLast5games02PlusMinus() {
		return last5games02PlusMinus;
	}

	public void setLast5games02PlusMinus(Integer last5games02PlusMinus) {
		this.last5games02PlusMinus = last5games02PlusMinus;
	}

	public Integer getLast5games02Points() {
		return last5games02Points;
	}

	public void setLast5games02Points(Integer last5games02Points) {
		this.last5games02Points = last5games02Points;
	}

	public Integer getLast5games02PowerplayGoals() {
		return last5games02PowerplayGoals;
	}

	public void setLast5games02PowerplayGoals(Integer last5games02PowerplayGoals) {
		this.last5games02PowerplayGoals = last5games02PowerplayGoals;
	}

	public Integer getLast5games02Shifts() {
		return last5games02Shifts;
	}

	public void setLast5games02Shifts(Integer last5games02Shifts) {
		this.last5games02Shifts = last5games02Shifts;
	}

	public Integer getLast5games02ShorthandedGoals() {
		return last5games02ShorthandedGoals;
	}

	public void setLast5games02ShorthandedGoals(Integer last5games02ShorthandedGoals) {
		this.last5games02ShorthandedGoals = last5games02ShorthandedGoals;
	}

	public Integer getLast5games02Shots() {
		return last5games02Shots;
	}

	public void setLast5games02Shots(Integer last5games02Shots) {
		this.last5games02Shots = last5games02Shots;
	}

	public String getLast5games02Toi() {
		return last5games02Toi;
	}

	public void setLast5games02Toi(String last5games02Toi) {
		this.last5games02Toi = last5games02Toi;
	}

	public Integer getLast5games03Assists() {
		return last5games03Assists;
	}

	public void setLast5games03Assists(Integer last5games03Assists) {
		this.last5games03Assists = last5games03Assists;
	}

	public String getLast5games03Date() {
		return last5games03Date;
	}

	public void setLast5games03Date(String last5games03Date) {
		this.last5games03Date = last5games03Date;
	}

	public Integer getLast5games03GameId() {
		return last5games03GameId;
	}

	public void setLast5games03GameId(Integer last5games03GameId) {
		this.last5games03GameId = last5games03GameId;
	}

	public Integer getLast5games03GameTypeId() {
		return last5games03GameTypeId;
	}

	public void setLast5games03GameTypeId(Integer last5games03GameTypeId) {
		this.last5games03GameTypeId = last5games03GameTypeId;
	}

	public Integer getLast5games03Goals() {
		return last5games03Goals;
	}

	public void setLast5games03Goals(Integer last5games03Goals) {
		this.last5games03Goals = last5games03Goals;
	}

	public String getLast5games03HomeRoadFlag() {
		return last5games03HomeRoadFlag;
	}

	public void setLast5games03HomeRoadFlag(String last5games03HomeRoadFlag) {
		this.last5games03HomeRoadFlag = last5games03HomeRoadFlag;
	}

	public String getLast5games03OpponentAbbrv() {
		return last5games03OpponentAbbrv;
	}

	public void setLast5games03OpponentAbbrv(String last5games03OpponentAbbrv) {
		this.last5games03OpponentAbbrv = last5games03OpponentAbbrv;
	}

	public Integer getLast5games03Pim() {
		return last5games03Pim;
	}

	public void setLast5games03Pim(Integer last5games03Pim) {
		this.last5games03Pim = last5games03Pim;
	}

	public Integer getLast5games03PlusMinus() {
		return last5games03PlusMinus;
	}

	public void setLast5games03PlusMinus(Integer last5games03PlusMinus) {
		this.last5games03PlusMinus = last5games03PlusMinus;
	}

	public Integer getLast5games03Points() {
		return last5games03Points;
	}

	public void setLast5games03Points(Integer last5games03Points) {
		this.last5games03Points = last5games03Points;
	}

	public Integer getLast5games03PowerplayGoals() {
		return last5games03PowerplayGoals;
	}

	public void setLast5games03PowerplayGoals(Integer last5games03PowerplayGoals) {
		this.last5games03PowerplayGoals = last5games03PowerplayGoals;
	}

	public Integer getLast5games03Shifts() {
		return last5games03Shifts;
	}

	public void setLast5games03Shifts(Integer last5games03Shifts) {
		this.last5games03Shifts = last5games03Shifts;
	}

	public Integer getLast5games03ShorthandedGoals() {
		return last5games03ShorthandedGoals;
	}

	public void setLast5games03ShorthandedGoals(Integer last5games03ShorthandedGoals) {
		this.last5games03ShorthandedGoals = last5games03ShorthandedGoals;
	}

	public Integer getLast5games03Shots() {
		return last5games03Shots;
	}

	public void setLast5games03Shots(Integer last5games03Shots) {
		this.last5games03Shots = last5games03Shots;
	}

	public String getLast5games03Toi() {
		return last5games03Toi;
	}

	public void setLast5games03Toi(String last5games03Toi) {
		this.last5games03Toi = last5games03Toi;
	}

	public Integer getLast5games04Assists() {
		return last5games04Assists;
	}

	public void setLast5games04Assists(Integer last5games04Assists) {
		this.last5games04Assists = last5games04Assists;
	}

	public String getLast5games04Date() {
		return last5games04Date;
	}

	public void setLast5games04Date(String last5games04Date) {
		this.last5games04Date = last5games04Date;
	}

	public Integer getLast5games04GameId() {
		return last5games04GameId;
	}

	public void setLast5games04GameId(Integer last5games04GameId) {
		this.last5games04GameId = last5games04GameId;
	}

	public Integer getLast5games04GameTypeId() {
		return last5games04GameTypeId;
	}

	public void setLast5games04GameTypeId(Integer last5games04GameTypeId) {
		this.last5games04GameTypeId = last5games04GameTypeId;
	}

	public Integer getLast5games04Goals() {
		return last5games04Goals;
	}

	public void setLast5games04Goals(Integer last5games04Goals) {
		this.last5games04Goals = last5games04Goals;
	}

	public String getLast5games04HomeRoadFlag() {
		return last5games04HomeRoadFlag;
	}

	public void setLast5games04HomeRoadFlag(String last5games04HomeRoadFlag) {
		this.last5games04HomeRoadFlag = last5games04HomeRoadFlag;
	}

	public String getLast5games04OpponentAbbrv() {
		return last5games04OpponentAbbrv;
	}

	public void setLast5games04OpponentAbbrv(String last5games04OpponentAbbrv) {
		this.last5games04OpponentAbbrv = last5games04OpponentAbbrv;
	}

	public Integer getLast5games04Pim() {
		return last5games04Pim;
	}

	public void setLast5games04Pim(Integer last5games04Pim) {
		this.last5games04Pim = last5games04Pim;
	}

	public Integer getLast5games04PlusMinus() {
		return last5games04PlusMinus;
	}

	public void setLast5games04PlusMinus(Integer last5games04PlusMinus) {
		this.last5games04PlusMinus = last5games04PlusMinus;
	}

	public Integer getLast5games04Points() {
		return last5games04Points;
	}

	public void setLast5games04Points(Integer last5games04Points) {
		this.last5games04Points = last5games04Points;
	}

	public Integer getLast5games04PowerplayGoals() {
		return last5games04PowerplayGoals;
	}

	public void setLast5games04PowerplayGoals(Integer last5games04PowerplayGoals) {
		this.last5games04PowerplayGoals = last5games04PowerplayGoals;
	}

	public Integer getLast5games04Shifts() {
		return last5games04Shifts;
	}

	public void setLast5games04Shifts(Integer last5games04Shifts) {
		this.last5games04Shifts = last5games04Shifts;
	}

	public Integer getLast5games04ShorthandedGoals() {
		return last5games04ShorthandedGoals;
	}

	public void setLast5games04ShorthandedGoals(Integer last5games04ShorthandedGoals) {
		this.last5games04ShorthandedGoals = last5games04ShorthandedGoals;
	}

	public Integer getLast5games04Shots() {
		return last5games04Shots;
	}

	public void setLast5games04Shots(Integer last5games04Shots) {
		this.last5games04Shots = last5games04Shots;
	}

	public String getLast5games04Toi() {
		return last5games04Toi;
	}

	public void setLast5games04Toi(String last5games04Toi) {
		this.last5games04Toi = last5games04Toi;
	}

	public Integer getLast5games05Assists() {
		return last5games05Assists;
	}

	public void setLast5games05Assists(Integer last5games05Assists) {
		this.last5games05Assists = last5games05Assists;
	}

	public String getLast5games05Date() {
		return last5games05Date;
	}

	public void setLast5games05Date(String last5games05Date) {
		this.last5games05Date = last5games05Date;
	}

	public Integer getLast5games05GameId() {
		return last5games05GameId;
	}

	public void setLast5games05GameId(Integer last5games05GameId) {
		this.last5games05GameId = last5games05GameId;
	}

	public Integer getLast5games05GameTypeId() {
		return last5games05GameTypeId;
	}

	public void setLast5games05GameTypeId(Integer last5games05GameTypeId) {
		this.last5games05GameTypeId = last5games05GameTypeId;
	}

	public Integer getLast5games05Goals() {
		return last5games05Goals;
	}

	public void setLast5games05Goals(Integer last5games05Goals) {
		this.last5games05Goals = last5games05Goals;
	}

	public String getLast5games05HomeRoadFlag() {
		return last5games05HomeRoadFlag;
	}

	public void setLast5games05HomeRoadFlag(String last5games05HomeRoadFlag) {
		this.last5games05HomeRoadFlag = last5games05HomeRoadFlag;
	}

	public String getLast5games05OpponentAbbrv() {
		return last5games05OpponentAbbrv;
	}

	public void setLast5games05OpponentAbbrv(String last5games05OpponentAbbrv) {
		this.last5games05OpponentAbbrv = last5games05OpponentAbbrv;
	}

	public Integer getLast5games05Pim() {
		return last5games05Pim;
	}

	public void setLast5games05Pim(Integer last5games05Pim) {
		this.last5games05Pim = last5games05Pim;
	}

	public Integer getLast5games05PlusMinus() {
		return last5games05PlusMinus;
	}

	public void setLast5games05PlusMinus(Integer last5games05PlusMinus) {
		this.last5games05PlusMinus = last5games05PlusMinus;
	}

	public Integer getLast5games05Points() {
		return last5games05Points;
	}

	public void setLast5games05Points(Integer last5games05Points) {
		this.last5games05Points = last5games05Points;
	}

	public Integer getLast5games05PowerplayGoals() {
		return last5games05PowerplayGoals;
	}

	public void setLast5games05PowerplayGoals(Integer last5games05PowerplayGoals) {
		this.last5games05PowerplayGoals = last5games05PowerplayGoals;
	}

	public Integer getLast5games05Shifts() {
		return last5games05Shifts;
	}

	public void setLast5games05Shifts(Integer last5games05Shifts) {
		this.last5games05Shifts = last5games05Shifts;
	}

	public Integer getLast5games05ShorthandedGoals() {
		return last5games05ShorthandedGoals;
	}

	public void setLast5games05ShorthandedGoals(Integer last5games05ShorthandedGoals) {
		this.last5games05ShorthandedGoals = last5games05ShorthandedGoals;
	}

	public Integer getLast5games05Shots() {
		return last5games05Shots;
	}

	public void setLast5games05Shots(Integer last5games05Shots) {
		this.last5games05Shots = last5games05Shots;
	}

	public String getLast5games05Toi() {
		return last5games05Toi;
	}

	public void setLast5games05Toi(String last5games05Toi) {
		this.last5games05Toi = last5games05Toi;
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

	public String getTeamAbbr() {
		return teamAbbr;
	}

	public void setTeamAbbr(String teamAbbr) {
		this.teamAbbr = teamAbbr;
	}

	public Integer getGameNumber() {
		return gameNumber;
	}

	public void setGameNumber(Integer gameNumber) {
		this.gameNumber = gameNumber;
	}

}

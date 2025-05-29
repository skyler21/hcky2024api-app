package com.hockey.core.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
//import jakarta.persistence.criteria.CriteriaBuilder.In;

@Entity // This tells Hibernate to make a table out of this class
public class Rostergoalie {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private Integer rosterId;
	private Boolean isActive;
	private Integer currentTeamId;
	private Integer seasonYear;
	private String seasonType;
    private Integer gamesPlayed;
    private Float goalsAgainstAvg;
	private Integer gameLosses;
	private Integer gameOtLosses;
	private Float savePctg;
	private Integer shutouts;
	private Integer gameWins; 
	private String last5games01Decision; 
	private String last5games01Date; 
	private Integer last5games01GameId; 
	private Integer last5games01GameTypeId; 
	private Integer last5games01GamesStarted; 
	private Integer last5games01GoalsAgainst;
	private String last5games01HomeRoadFlag; 
	private String last5games01OpponentAbbrv; 
	private Float last5games01SavePctg; 
	private Integer last5games01ShotsAgainst; 
	private String last5games02Decision; 
	private String last5games02Date; 
	private Integer last5games02GameId; 
	private Integer last5games02GameTypeId; 
	private Integer last5games02GamesStarted; 
	private Integer last5games02GoalsAgainst;
	private String last5games02HomeRoadFlag; 
	private String last5games02OpponentAbbrv; 
	private Float last5games02SavePctg; 
	private Integer last5games02ShotsAgainst; 
	private String last5games03Decision; 
	private String last5games03Date; 
	private Integer last5games03GameId; 
	private Integer last5games03GameTypeId; 
	private Integer last5games03GamesStarted; 
	private Integer last5games03GoalsAgainst;
	private String last5games03HomeRoadFlag; 
	private String last5games03OpponentAbbrv; 
	private Float last5games03SavePctg; 
	private Integer last5games03ShotsAgainst; 
	private String last5games04Decision; 
	private String last5games04Date; 
	private Integer last5games04GameId; 
	private Integer last5games04GameTypeId; 
	private Integer last5games04GamesStarted; 
	private Integer last5games04GoalsAgainst;
	private String last5games04HomeRoadFlag; 
	private String last5games04OpponentAbbrv; 
	private Float last5games04SavePctg; 
	private Integer last5games04ShotsAgainst; 
	private String last5games05Decision; 
	private String last5games05Date; 
	private Integer last5games05GameId; 
	private Integer last5games05GameTypeId; 
	private Integer last5games05GamesStarted; 
	private Integer last5games05GoalsAgainst;
	private String last5games05HomeRoadFlag; 
	private String last5games05OpponentAbbrv; 
	private Float last5games05SavePctg; 
	private Integer last5games05ShotsAgainst; 
	private String firstName;
	private String lastName;
	private String teamAbbr;
	private Integer gameNumber;

	
	
	public Rostergoalie() {
	}

	public Rostergoalie(Integer id, Integer rosterId, Boolean isActive, Integer currentTeamId, Integer seasonYear, String seasonType, Integer gamesPlayed, 
	                    Float goalsAgainstAvg, Integer gameLosses, Integer gameOtLosses, Float savePctg, Integer shutouts, Integer gameWins,
						String last5games01Decision, String last5games01Date, Integer last5games01GameId, Integer last5games01GameTypeId, 
						Integer last5games01GamesStarted, Integer last5games01GoalsAgainst, String last5games01HomeRoadFlag, String last5games01OpponentAbbrv,
						Float last5games01SavePctg, Integer last5games01ShotsAgainst, String last5games02Decision, String last5games02Date, Integer last5games02GameId,
						Integer last5games02GameTypeId, Integer last5games02GamesStarted, Integer last5games02GoalsAgainst, String last5games02HomeRoadFlag,
						String last5games02OpponentAbbrv, Float last5games02SavePctg, Integer last5games02ShotsAgainst, String last5games03Decision, 
						String last5games03Date, Integer last5games03GameId, Integer last5games03GameTypeId, Integer last5games03GamesStarted, 
						Integer last5games03GoalsAgainst, String last5games03HomeRoadFlag, String last5games03OpponentAbbrv, Float last5games03SavePctg,
						Integer last5games03ShotsAgainst, String last5games04Decision, String last5games04Date, Integer last5games04GameId,
						Integer last5games04GameTypeId, Integer last5games04GamesStarted, Integer last5games04GoalsAgainst, String last5games04HomeRoadFlag,
						String last5games04OpponentAbbrv, Float last5games04SavePctg, Integer last5games04ShotsAgainst, String last5games05Decision, 
						String last5games05Date, Integer last5games05GameId, Integer last5games05GameTypeId, Integer last5games05GamesStarted,
						Integer last5games05GoalsAgainst, String last5games05HomeRoadFlag, String last5games05OpponentAbbrv, Float last5games05SavePctg,
						Integer last5games05ShotsAgainst, String firstName, String lastName, String teamAbbr, Integer gameNumber) {
		super();
		this.id = id;
		this.rosterId = rosterId;
		this.isActive = isActive ;
		this.currentTeamId = currentTeamId;
		this.seasonYear = seasonYear;
		this.seasonType = seasonType;
    	this.gamesPlayed = gamesPlayed;
    	this.goalsAgainstAvg = goalsAgainstAvg;
		this.gameLosses = gameLosses;
		this.gameOtLosses = gameOtLosses ;
		this.savePctg = savePctg ;
		this.shutouts = shutouts;
		this.gameWins = gameWins ; 
		this.last5games01Decision = last5games01Decision; 
		this.last5games01Date = last5games01Date ; 
		this.last5games01GameId = last5games01GameId; 
		this.last5games01GameTypeId = last5games01GameTypeId; 
		this.last5games01GamesStarted = last5games01GamesStarted; 
		this.last5games01GoalsAgainst = last5games01GoalsAgainst;
		this.last5games01HomeRoadFlag = last5games01HomeRoadFlag; 
		this.last5games01OpponentAbbrv = last5games01OpponentAbbrv; 
		this.last5games01SavePctg = last5games01SavePctg; 
		this.last5games01ShotsAgainst = last5games01ShotsAgainst; 
		this.last5games02Decision = last5games02Decision; 
		this.last5games02Date = last5games02Date; 
		this.last5games02GameId = last5games02GameId; 
		this.last5games02GameTypeId = last5games02GameTypeId; 
		this.last5games02GamesStarted = last5games02GamesStarted; 
		this.last5games02GoalsAgainst = last5games02GoalsAgainst;
		this.last5games02HomeRoadFlag = last5games02HomeRoadFlag; 
		this.last5games02OpponentAbbrv = last5games02OpponentAbbrv; 
		this.last5games02SavePctg = last5games02SavePctg; 
		this.last5games02ShotsAgainst = last5games02ShotsAgainst; 
		this.last5games03Decision = last5games03Decision; 
		this.last5games03Date = last5games03Date; 
		this.last5games03GameId = last5games03GameId; 
		this.last5games03GameTypeId = last5games03GameTypeId; 
		this.last5games03GamesStarted = last5games03GamesStarted; 
		this.last5games03GoalsAgainst = last5games03GoalsAgainst;
		this.last5games03HomeRoadFlag = last5games03HomeRoadFlag; 
		this.last5games03OpponentAbbrv = last5games03OpponentAbbrv; 
		this.last5games03SavePctg = last5games03SavePctg; 
		this.last5games03ShotsAgainst = last5games03ShotsAgainst; 
		this.last5games04Decision = last5games04Decision; 
		this.last5games04Date = last5games04Date; 
		this.last5games04GameId = last5games04GameId; 
		this.last5games04GameTypeId = last5games04GameTypeId; 
		this.last5games04GamesStarted = last5games04GamesStarted; 
		this.last5games04GoalsAgainst = last5games04GoalsAgainst;
		this.last5games04HomeRoadFlag = last5games04HomeRoadFlag;  
		this.last5games04OpponentAbbrv = last5games04OpponentAbbrv; 
		this.last5games04SavePctg = last5games04SavePctg; 
		this.last5games04ShotsAgainst = last5games04ShotsAgainst; 
		this.last5games05Decision = last5games05Decision; 
		this.last5games05Date = last5games05Date; 
		this.last5games05GameId = last5games05GameId; 
		this.last5games05GameTypeId = last5games05GameTypeId; 
		this.last5games05GamesStarted = last5games05GamesStarted; 
		this.last5games05GoalsAgainst = last5games05GoalsAgainst;
		this.last5games05HomeRoadFlag = last5games05HomeRoadFlag; 
		this.last5games05OpponentAbbrv = last5games05OpponentAbbrv; 
		this.last5games05SavePctg = last5games05SavePctg; 
		this.last5games05ShotsAgainst = last5games05ShotsAgainst; 
		this.firstName = firstName;
		this.lastName = lastName;
		this.teamAbbr = teamAbbr;
		this.gameNumber = gameNumber;
	}

	@Override
	public String toString() {
		return "Rostergoalie [id=" + id + ", rosterId=" + rosterId + ", isActive=" + isActive + ", currentTeamId="
				+ currentTeamId + ", seasonYear=" + seasonYear + ", seasonType=" + seasonType + ", gamesPlayed="
				+ gamesPlayed + ", goalsAgainstAvg=" + goalsAgainstAvg + ", gameLosses=" + gameLosses
				+ ", gameOtLosses=" + gameOtLosses + ", savePctg=" + savePctg + ", shutouts=" + shutouts + ", gameWins="
				+ gameWins + ", last5games01Decision=" + last5games01Decision + ", last5games01Date=" + last5games01Date
				+ ", last5games01GameId=" + last5games01GameId + ", last5games01GameTypeId=" + last5games01GameTypeId
				+ ", last5games01GamesStarted=" + last5games01GamesStarted + ", last5games01GoalsAgainst="
				+ last5games01GoalsAgainst + ", last5games01HomeRoadFlag=" + last5games01HomeRoadFlag
				+ ", last5games01OpponentAbbrv=" + last5games01OpponentAbbrv + ", last5games01SavePctg="
				+ last5games01SavePctg + ", last5games01ShotsAgainst=" + last5games01ShotsAgainst
				+ ", last5games02Decision=" + last5games02Decision + ", last5games02Date=" + last5games02Date
				+ ", last5games02GameId=" + last5games02GameId + ", last5games02GameTypeId=" + last5games02GameTypeId
				+ ", last5games02GamesStarted=" + last5games02GamesStarted + ", last5games02GoalsAgainst="
				+ last5games02GoalsAgainst + ", last5games02HomeRoadFlag=" + last5games02HomeRoadFlag
				+ ", last5games02OpponentAbbrv=" + last5games02OpponentAbbrv + ", last5games02SavePctg="
				+ last5games02SavePctg + ", last5games02ShotsAgainst=" + last5games02ShotsAgainst
				+ ", last5games03Decision=" + last5games03Decision + ", last5games03Date=" + last5games03Date
				+ ", last5games03GameId=" + last5games03GameId + ", last5games03GameTypeId=" + last5games03GameTypeId
				+ ", last5games03GamesStarted=" + last5games03GamesStarted + ", last5games03GoalsAgainst="
				+ last5games03GoalsAgainst + ", last5games03HomeRoadFlag=" + last5games03HomeRoadFlag
				+ ", last5games03OpponentAbbrv=" + last5games03OpponentAbbrv + ", last5games03SavePctg="
				+ last5games03SavePctg + ", last5games03ShotsAgainst=" + last5games03ShotsAgainst
				+ ", last5games04Decision=" + last5games04Decision + ", last5games04Date=" + last5games04Date
				+ ", last5games04GameId=" + last5games04GameId + ", last5games04GameTypeId=" + last5games04GameTypeId
				+ ", last5games04GamesStarted=" + last5games04GamesStarted + ", last5games04GoalsAgainst="
				+ last5games04GoalsAgainst + ", last5games04HomeRoadFlag=" + last5games04HomeRoadFlag
				+ ", last5games04OpponentAbbrv=" + last5games04OpponentAbbrv + ", last5games04SavePctg="
				+ last5games04SavePctg + ", last5games04ShotsAgainst=" + last5games04ShotsAgainst
				+ ", last5games05Decision=" + last5games05Decision + ", last5games05Date=" + last5games05Date
				+ ", last5games05GameId=" + last5games05GameId + ", last5games05GameTypeId=" + last5games05GameTypeId
				+ ", last5games05GamesStarted=" + last5games05GamesStarted + ", last5games05GoalsAgainst="
				+ last5games05GoalsAgainst + ", last5games05HomeRoadFlag=" + last5games05HomeRoadFlag
				+ ", last5games05OpponentAbbrv=" + last5games05OpponentAbbrv + ", last5games05SavePctg="
				+ last5games05SavePctg + ", last5games05ShotsAgainst=" + last5games05ShotsAgainst + ", firstName=" + firstName
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

	public Integer getGamesPlayed() {
		return gamesPlayed;
	}

	public void setGamesPlayed(Integer gamesPlayed) {
		this.gamesPlayed = gamesPlayed;
	}

	public Float getGoalsAgainstAvg() {
		return goalsAgainstAvg;
	}

	public void setGoalsAgainstAvg(Float goalsAgainstAvg) {
		this.goalsAgainstAvg = goalsAgainstAvg;
	}

	public Integer getGameLosses() {
		return gameLosses;
	}

	public void setGameLosses(Integer gameLosses) {
		this.gameLosses = gameLosses;
	}

	public Integer getGameOtLosses() {
		return gameOtLosses;
	}

	public void setGameOtLosses(Integer gameOtLosses) {
		this.gameOtLosses = gameOtLosses;
	}

	public Float getSavePctg() {
		return savePctg;
	}

	public void setSavePctg(Float savePctg) {
		this.savePctg = savePctg;
	}

	public Integer getShutouts() {
		return shutouts;
	}

	public void setShutouts(Integer shutouts) {
		this.shutouts = shutouts;
	}

	public Integer getGameWins() {
		return gameWins;
	}

	public void setGameWins(Integer gameWins) {
		this.gameWins = gameWins;
	}

	public String getLast5games01Decision() {
		return last5games01Decision;
	}

	public void setLast5games01Decision(String last5games01Decision) {
		this.last5games01Decision = last5games01Decision;
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

	public Integer getLast5games01GamesStarted() {
		return last5games01GamesStarted;
	}

	public void setLast5games01GamesStarted(Integer last5games01GamesStarted) {
		this.last5games01GamesStarted = last5games01GamesStarted;
	}

	public Integer getLast5games01GoalsAgainst() {
		return last5games01GoalsAgainst;
	}

	public void setLast5games01GoalsAgainst(Integer last5games01GoalsAgainst) {
		this.last5games01GoalsAgainst = last5games01GoalsAgainst;
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

	public Float getLast5games01SavePctg() {
		return last5games01SavePctg;
	}

	public void setLast5games01SavePctg(Float last5games01SavePctg) {
		this.last5games01SavePctg = last5games01SavePctg;
	}

	public Integer getLast5games01ShotsAgainst() {
		return last5games01ShotsAgainst;
	}

	public void setLast5games01ShotsAgainst(Integer last5games01ShotsAgainst) {
		this.last5games01ShotsAgainst = last5games01ShotsAgainst;
	}

	public String getLast5games02Decision() {
		return last5games02Decision;
	}

	public void setLast5games02Decision(String last5games02Decision) {
		this.last5games02Decision = last5games02Decision;
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

	public Integer getLast5games02GamesStarted() {
		return last5games02GamesStarted;
	}

	public void setLast5games02GamesStarted(Integer last5games02GamesStarted) {
		this.last5games02GamesStarted = last5games02GamesStarted;
	}

	public Integer getLast5games02GoalsAgainst() {
		return last5games02GoalsAgainst;
	}

	public void setLast5games02GoalsAgainst(Integer last5games02GoalsAgainst) {
		this.last5games02GoalsAgainst = last5games02GoalsAgainst;
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

	public Float getLast5games02SavePctg() {
		return last5games02SavePctg;
	}

	public void setLast5games02SavePctg(Float last5games02SavePctg) {
		this.last5games02SavePctg = last5games02SavePctg;
	}

	public Integer getLast5games02ShotsAgainst() {
		return last5games02ShotsAgainst;
	}

	public void setLast5games02ShotsAgainst(Integer last5games02ShotsAgainst) {
		this.last5games02ShotsAgainst = last5games02ShotsAgainst;
	}

	public String getLast5games03Decision() {
		return last5games03Decision;
	}

	public void setLast5games03Decision(String last5games03Decision) {
		this.last5games03Decision = last5games03Decision;
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

	public Integer getLast5games03GamesStarted() {
		return last5games03GamesStarted;
	}

	public void setLast5games03GamesStarted(Integer last5games03GamesStarted) {
		this.last5games03GamesStarted = last5games03GamesStarted;
	}

	public Integer getLast5games03GoalsAgainst() {
		return last5games03GoalsAgainst;
	}

	public void setLast5games03GoalsAgainst(Integer last5games03GoalsAgainst) {
		this.last5games03GoalsAgainst = last5games03GoalsAgainst;
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

	public Float getLast5games03SavePctg() {
		return last5games03SavePctg;
	}

	public void setLast5games03SavePctg(Float last5games03SavePctg) {
		this.last5games03SavePctg = last5games03SavePctg;
	}

	public Integer getLast5games03ShotsAgainst() {
		return last5games03ShotsAgainst;
	}

	public void setLast5games03ShotsAgainst(Integer last5games03ShotsAgainst) {
		this.last5games03ShotsAgainst = last5games03ShotsAgainst;
	}

	public String getLast5games04Decision() {
		return last5games04Decision;
	}

	public void setLast5games04Decision(String last5games04Decision) {
		this.last5games04Decision = last5games04Decision;
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

	public Integer getLast5games04GamesStarted() {
		return last5games04GamesStarted;
	}

	public void setLast5games04GamesStarted(Integer last5games04GamesStarted) {
		this.last5games04GamesStarted = last5games04GamesStarted;
	}

	public Integer getLast5games04GoalsAgainst() {
		return last5games04GoalsAgainst;
	}

	public void setLast5games04GoalsAgainst(Integer last5games04GoalsAgainst) {
		this.last5games04GoalsAgainst = last5games04GoalsAgainst;
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

	public Float getLast5games04SavePctg() {
		return last5games04SavePctg;
	}

	public void setLast5games04SavePctg(Float last5games04SavePctg) {
		this.last5games04SavePctg = last5games04SavePctg;
	}

	public Integer getLast5games04ShotsAgainst() {
		return last5games04ShotsAgainst;
	}

	public void setLast5games04ShotsAgainst(Integer last5games04ShotsAgainst) {
		this.last5games04ShotsAgainst = last5games04ShotsAgainst;
	}

	public String getLast5games05Decision() {
		return last5games05Decision;
	}

	public void setLast5games05Decision(String last5games05Decision) {
		this.last5games05Decision = last5games05Decision;
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

	public Integer getLast5games05GamesStarted() {
		return last5games05GamesStarted;
	}

	public void setLast5games05GamesStarted(Integer last5games05GamesStarted) {
		this.last5games05GamesStarted = last5games05GamesStarted;
	}

	public Integer getLast5games05GoalsAgainst() {
		return last5games05GoalsAgainst;
	}

	public void setLast5games05GoalsAgainst(Integer last5games05GoalsAgainst) {
		this.last5games05GoalsAgainst = last5games05GoalsAgainst;
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

	public Float getLast5games05SavePctg() {
		return last5games05SavePctg;
	}

	public void setLast5games05SavePctg(Float last5games05SavePctg) {
		this.last5games05SavePctg = last5games05SavePctg;
	}

	public Integer getLast5games05ShotsAgainst() {
		return last5games05ShotsAgainst;
	}

	public void setLast5games05ShotsAgainst(Integer last5games05ShotsAgainst) {
		this.last5games05ShotsAgainst = last5games05ShotsAgainst;
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

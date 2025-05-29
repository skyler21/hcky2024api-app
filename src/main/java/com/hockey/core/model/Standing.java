package com.hockey.core.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity // This tells Hibernate to make a table out of this class
public class Standing {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String conferenceAbbrev;
    private Integer conferenceHomeSequence;
    private Integer conferenceL10Sequence;
    private String conferenceName;
    private Integer conferenceRoadSequence;
    private Integer conferenceSequence;
    private String date;
    private String divisionAbbrev;
    private Integer divisionHomeSequence;
    private Integer divisionL10Sequence;
    private String divisionName;
    private Integer divisionRoadSequence;
    private Integer divisionSequence;
    private Integer gameTypeId;
    private Integer gamesPlayed;
    private Integer goalDifferential;
    private Float goalDifferentialPctg;
    private Integer goalAgainst;
    private Integer goalFor;
    private Float goalsForPctg;
    private Integer homeGamesPlayed;
    private Integer homeGoalDifferential;
    private Integer homeGoalsAgainst;
    private Integer homeGoalsFor;
    private Integer homeLosses;
    private Integer homeOtLosses;
    private Integer homePoints;
    private Integer homeRegulationPlusOtWins;
    private Integer homeRegulationWins;
    private Integer homeTies;
    private Integer homeWins;
    private Integer l10GamesPlayed;
    private Integer l10GoalDifferential;
    private Integer l10GoalsAgainst;
    private Integer l10GoalsFor;
    private Integer l10Losses;
    private Integer l10OtLosses;
    private Integer l10Points;
    private Integer l10RegulationPlusOtWins;
    private Integer l10RegulationWins;
    private Integer l10Ties;
    private Integer l10Wins;
    private Integer leagueHomeSequence;
    private Integer leagueL10Sequence;
    private Integer leagueRoadSequence;
    private Integer leagueSequence;
    private Integer losses;
    private Integer otLosses;
    private String placeName;
    private Float pointPctg;
    private Integer points;
    private Float regulationPlusOtWinPctg;
    private Integer regulationPlusOtWins;
    private Float regulationWinPctg;
    private Integer regulationWins;
    private Integer roadGamesPlayed;
    private Integer roadGoalDifferential;
    private Integer roadGoalsAgainst;
    private Integer roadGoalsFor;
    private Integer roadLosses;
    private Integer roadOtLosses;
    private Integer roadPoints;
    private Integer roadRegulationPlusOtWins;
    private Integer roadRegulationWins;
    private Integer roadTies;
    private Integer roadWins;
    private Integer seasonId;
    private Integer shootoutLosses;
    private Integer shootoutWins;
    private String streakCode;
    private Integer streakCount;
    private String teamName;
    private String teamCommonName;
    private String teamAbbrev;
    private Integer ties;
    private Integer waiversSequence;
    private Integer wildcardSequence;
    private Float winPctg;
    private Integer wins;

    public Standing() {
    }

    public Standing(Integer id, String conferenceAbbrev, Integer conferenceHomeSequence, Integer conferenceL10Sequence,
            String conferenceName, Integer conferenceRoadSequence, Integer conferenceSequence, String date,
            String divisionAbbrev, Integer divisionHomeSequence, Integer divisionL10Sequence, String divisionName,
            Integer divisionRoadSequence, Integer divisionSequence, Integer gameTypeId, Integer gamesPlayed,
            Integer goalDifferential, Float goalDifferentialPctg, Integer goalAgainst, Integer goalFor,
            Float goalsForPctg, Integer homeGamesPlayed, Integer homeGoalDifferential, Integer homeGoalsAgainst,
            Integer homeGoalsFor, Integer homeLosses, Integer homeOtLosses, Integer homePoints,
            Integer homeRegulationPlusOtWins, Integer homeRegulationWins, Integer homeTies, Integer homeWins,
            Integer l10GamesPlayed, Integer l10GoalDifferential, Integer l10GoalsAgainst, Integer l10GoalsFor,
            Integer l10Losses, Integer l10OtLosses, Integer l10Points, Integer l10RegulationPlusOtWins,
            Integer l10RegulationWins, Integer l10Ties, Integer l10Wins, Integer leagueHomeSequence,
            Integer leagueL10Sequence, Integer leagueRoadSequence, Integer leagueSequence, Integer losses,
            Integer otLosses, String placeName, Float pointPctg, Integer points, Float regulationPlusOtWinPctg,
            Integer regulationPlusOtWins, Float regulationWinPctg, Integer regulationWins, Integer roadGamesPlayed,
            Integer roadGoalDifferential, Integer roadGoalsAgainst, Integer roadGoalsFor, Integer roadLosses,
            Integer roadOtLosses, Integer roadPoints, Integer roadRegulationPlusOtWins, Integer roadRegulationWins,
            Integer roadTies, Integer roadWins, Integer seasonId, Integer shootoutLosses, Integer shootoutWins,
            String streakCode, Integer streakCount, String teamName, String teamCommonName, String teamAbbrev,
            Integer ties, Integer waiversSequence, Integer wildcardSequence, Float winPctg, Integer wins) {
        this.id = id;
        this.conferenceAbbrev = conferenceAbbrev;
        this.conferenceHomeSequence = conferenceHomeSequence;
        this.conferenceL10Sequence = conferenceL10Sequence;
        this.conferenceName = conferenceName;
        this.conferenceRoadSequence = conferenceRoadSequence;
        this.conferenceSequence = conferenceSequence;
        this.date = date;
        this.divisionAbbrev = divisionAbbrev;
        this.divisionHomeSequence = divisionHomeSequence;
        this.divisionL10Sequence = divisionL10Sequence;
        this.divisionName = divisionName;
        this.divisionRoadSequence = divisionRoadSequence;
        this.divisionSequence = divisionSequence;
        this.gameTypeId = gameTypeId;
        this.gamesPlayed = gamesPlayed;
        this.goalDifferential = goalDifferential;
        this.goalDifferentialPctg = goalDifferentialPctg;
        this.goalAgainst = goalAgainst;
        this.goalFor = goalFor;
        this.goalsForPctg = goalsForPctg;
        this.homeGamesPlayed = homeGamesPlayed;
        this.homeGoalDifferential = homeGoalDifferential;
        this.homeGoalsAgainst = homeGoalsAgainst;
        this.homeGoalsFor = homeGoalsFor;
        this.homeLosses = homeLosses;
        this.homeOtLosses = homeOtLosses;
        this.homePoints = homePoints;
        this.homeRegulationPlusOtWins = homeRegulationPlusOtWins;
        this.homeRegulationWins = homeRegulationWins;
        this.homeTies = homeTies;
        this.homeWins = homeWins;
        this.l10GamesPlayed = l10GamesPlayed;
        this.l10GoalDifferential = l10GoalDifferential;
        this.l10GoalsAgainst = l10GoalsAgainst;
        this.l10GoalsFor = l10GoalsFor;
        this.l10Losses = l10Losses;
        this.l10OtLosses = l10OtLosses;
        this.l10Points = l10Points;
        this.l10RegulationPlusOtWins = l10RegulationPlusOtWins;
        this.l10RegulationWins = l10RegulationWins;
        this.l10Ties = l10Ties;
        this.l10Wins = l10Wins;
        this.leagueHomeSequence = leagueHomeSequence;
        this.leagueL10Sequence = leagueL10Sequence;
        this.leagueRoadSequence = leagueRoadSequence;
        this.leagueSequence = leagueSequence;
        this.losses = losses;
        this.otLosses = otLosses;
        this.placeName = placeName;
        this.pointPctg = pointPctg;
        this.points = points;
        this.regulationPlusOtWinPctg = regulationPlusOtWinPctg;
        this.regulationPlusOtWins = regulationPlusOtWins;
        this.regulationWinPctg = regulationWinPctg;
        this.regulationWins = regulationWins;
        this.roadGamesPlayed = roadGamesPlayed;
        this.roadGoalDifferential = roadGoalDifferential;
        this.roadGoalsAgainst = roadGoalsAgainst;
        this.roadGoalsFor = roadGoalsFor;
        this.roadLosses = roadLosses;
        this.roadOtLosses = roadOtLosses;
        this.roadPoints = roadPoints;
        this.roadRegulationPlusOtWins = roadRegulationPlusOtWins;
        this.roadRegulationWins = roadRegulationWins;
        this.roadTies = roadTies;
        this.roadWins = roadWins;
        this.seasonId = seasonId;
        this.shootoutLosses = shootoutLosses;
        this.shootoutWins = shootoutWins;
        this.streakCode = streakCode;
        this.streakCount = streakCount;
        this.teamName = teamName;
        this.teamCommonName = teamCommonName;
        this.teamAbbrev = teamAbbrev;
        this.ties = ties;
        this.waiversSequence = waiversSequence;
        this.wildcardSequence = wildcardSequence;
        this.winPctg = winPctg;
        this.wins = wins;
    }

    @Override
    public String toString() {
        return "Standing [id=" + id + ", conferenceAbbrev=" + conferenceAbbrev + ", conferenceHomeSequence="
                + conferenceHomeSequence + ", conferenceL10Sequence=" + conferenceL10Sequence + ", conferenceName="
                + conferenceName + ", conferenceRoadSequence=" + conferenceRoadSequence + ", conferenceSequence="
                + conferenceSequence + ", date=" + date + ", divisionAbbrev=" + divisionAbbrev
                + ", divisionHomeSequence=" + divisionHomeSequence + ", divisionL10Sequence=" + divisionL10Sequence
                + ", divisionName=" + divisionName + ", divisionRoadSequence=" + divisionRoadSequence
                + ", divisionSequence=" + divisionSequence + ", gameTypeId=" + gameTypeId + ", gamesPlayed="
                + gamesPlayed + ", goalDifferential=" + goalDifferential + ", goalDifferentialPctg="
                + goalDifferentialPctg + ", goalAgainst=" + goalAgainst + ", goalFor=" + goalFor + ", goalsForPctg="
                + goalsForPctg + ", homeGamesPlayed=" + homeGamesPlayed + ", homeGoalDifferential="
                + homeGoalDifferential + ", homeGoalsAgainst=" + homeGoalsAgainst + ", homeGoalsFor=" + homeGoalsFor
                + ", homeLosses=" + homeLosses + ", homeOtLosses=" + homeOtLosses + ", homePoints=" + homePoints
                + ", homeRegulationPlusOtWins=" + homeRegulationPlusOtWins + ", homeRegulationWins="
                + homeRegulationWins + ", homeTies=" + homeTies + ", homeWins=" + homeWins + ", l10GamesPlayed="
                + l10GamesPlayed + ", l10GoalDifferential=" + l10GoalDifferential + ", l10GoalsAgainst="
                + l10GoalsAgainst + ", l10GoalsFor=" + l10GoalsFor + ", l10Losses=" + l10Losses + ", l10OtLosses="
                + l10OtLosses + ", l10Points=" + l10Points + ", l10RegulationPlusOtWins=" + l10RegulationPlusOtWins
                + ", l10RegulationWins=" + l10RegulationWins + ", l10Ties=" + l10Ties + ", l10Wins=" + l10Wins
                + ", leagueHomeSequence=" + leagueHomeSequence + ", leagueL10Sequence=" + leagueL10Sequence
                + ", leagueRoadSequence=" + leagueRoadSequence + ", leagueSequence=" + leagueSequence + ", losses="
                + losses + ", otLosses=" + otLosses + ", placeName=" + placeName + ", pointPctg=" + pointPctg
                + ", points=" + points + ", regulationPlusOtWinPctg=" + regulationPlusOtWinPctg
                + ", regulationPlusOtWins=" + regulationPlusOtWins + ", regulationWinPctg=" + regulationWinPctg
                + ", regulationWins=" + regulationWins + ", roadGamesPlayed=" + roadGamesPlayed
                + ", roadGoalDifferential=" + roadGoalDifferential + ", roadGoalsAgainst=" + roadGoalsAgainst
                + ", roadGoalsFor=" + roadGoalsFor + ", roadLosses=" + roadLosses + ", roadOtLosses=" + roadOtLosses
                + ", roadPoints=" + roadPoints + ", roadRegulationPlusOtWins=" + roadRegulationPlusOtWins
                + ", roadRegulationWins=" + roadRegulationWins + ", roadTies=" + roadTies + ", roadWins=" + roadWins
                + ", seasonId=" + seasonId + ", shootoutLosses=" + shootoutLosses + ", shootoutWins=" + shootoutWins
                + ", streakCode=" + streakCode + ", streakCount=" + streakCount + ", teamName=" + teamName
                + ", teamCommonName=" + teamCommonName + ", teamAbbrev=" + teamAbbrev + ", ties=" + ties
                + ", waiversSequence=" + waiversSequence + ", wildcardSequence=" + wildcardSequence + ", winPctg="
                + winPctg + ", wins=" + wins + "]";
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getConferenceAbbrev() {
        return conferenceAbbrev;
    }

    public void setConferenceAbbrev(String conferenceAbbrev) {
        this.conferenceAbbrev = conferenceAbbrev;
    }

    public Integer getConferenceHomeSequence() {
        return conferenceHomeSequence;
    }

    public void setConferenceHomeSequence(Integer conferenceHomeSequence) {
        this.conferenceHomeSequence = conferenceHomeSequence;
    }

    public Integer getConferenceL10Sequence() {
        return conferenceL10Sequence;
    }

    public void setConferenceL10Sequence(Integer conferenceL10Sequence) {
        this.conferenceL10Sequence = conferenceL10Sequence;
    }

    public String getConferenceName() {
        return conferenceName;
    }

    public void setConferenceName(String conferenceName) {
        this.conferenceName = conferenceName;
    }

    public Integer getConferenceRoadSequence() {
        return conferenceRoadSequence;
    }

    public void setConferenceRoadSequence(Integer conferenceRoadSequence) {
        this.conferenceRoadSequence = conferenceRoadSequence;
    }

    public Integer getConferenceSequence() {
        return conferenceSequence;
    }

    public void setConferenceSequence(Integer conferenceSequence) {
        this.conferenceSequence = conferenceSequence;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDivisionAbbrev() {
        return divisionAbbrev;
    }

    public void setDivisionAbbrev(String divisionAbbrev) {
        this.divisionAbbrev = divisionAbbrev;
    }

    public Integer getDivisionHomeSequence() {
        return divisionHomeSequence;
    }

    public void setDivisionHomeSequence(Integer divisionHomeSequence) {
        this.divisionHomeSequence = divisionHomeSequence;
    }

    public Integer getDivisionL10Sequence() {
        return divisionL10Sequence;
    }

    public void setDivisionL10Sequence(Integer divisionL10Sequence) {
        this.divisionL10Sequence = divisionL10Sequence;
    }

    public String getDivisionName() {
        return divisionName;
    }

    public void setDivisionName(String divisionName) {
        this.divisionName = divisionName;
    }

    public Integer getDivisionRoadSequence() {
        return divisionRoadSequence;
    }

    public void setDivisionRoadSequence(Integer divisionRoadSequence) {
        this.divisionRoadSequence = divisionRoadSequence;
    }

    public Integer getDivisionSequence() {
        return divisionSequence;
    }

    public void setDivisionSequence(Integer divisionSequence) {
        this.divisionSequence = divisionSequence;
    }

    public Integer getGameTypeId() {
        return gameTypeId;
    }

    public void setGameTypeId(Integer gameTypeId) {
        this.gameTypeId = gameTypeId;
    }

    public Integer getGamesPlayed() {
        return gamesPlayed;
    }

    public void setGamesPlayed(Integer gamesPlayed) {
        this.gamesPlayed = gamesPlayed;
    }

    public Integer getGoalDifferential() {
        return goalDifferential;
    }

    public void setGoalDifferential(Integer goalDifferential) {
        this.goalDifferential = goalDifferential;
    }

    public Float getGoalDifferentialPctg() {
        return goalDifferentialPctg;
    }

    public void setGoalDifferentialPctg(Float goalDifferentialPctg) {
        this.goalDifferentialPctg = goalDifferentialPctg;
    }

    public Integer getGoalAgainst() {
        return goalAgainst;
    }

    public void setGoalAgainst(Integer goalAgainst) {
        this.goalAgainst = goalAgainst;
    }

    public Integer getGoalFor() {
        return goalFor;
    }

    public void setGoalFor(Integer goalFor) {
        this.goalFor = goalFor;
    }

    public Float getGoalsForPctg() {
        return goalsForPctg;
    }

    public void setGoalsForPctg(Float goalsForPctg) {
        this.goalsForPctg = goalsForPctg;
    }

    public Integer getHomeGamesPlayed() {
        return homeGamesPlayed;
    }

    public void setHomeGamesPlayed(Integer homeGamesPlayed) {
        this.homeGamesPlayed = homeGamesPlayed;
    }

    public Integer getHomeGoalDifferential() {
        return homeGoalDifferential;
    }

    public void setHomeGoalDifferential(Integer homeGoalDifferential) {
        this.homeGoalDifferential = homeGoalDifferential;
    }

    public Integer getHomeGoalsAgainst() {
        return homeGoalsAgainst;
    }

    public void setHomeGoalsAgainst(Integer homeGoalsAgainst) {
        this.homeGoalsAgainst = homeGoalsAgainst;
    }

    public Integer getHomeGoalsFor() {
        return homeGoalsFor;
    }

    public void setHomeGoalsFor(Integer homeGoalsFor) {
        this.homeGoalsFor = homeGoalsFor;
    }

    public Integer getHomeLosses() {
        return homeLosses;
    }

    public void setHomeLosses(Integer homeLosses) {
        this.homeLosses = homeLosses;
    }

    public Integer getHomeOtLosses() {
        return homeOtLosses;
    }

    public void setHomeOtLosses(Integer homeOtLosses) {
        this.homeOtLosses = homeOtLosses;
    }

    public Integer getHomePoints() {
        return homePoints;
    }

    public void setHomePoints(Integer homePoints) {
        this.homePoints = homePoints;
    }

    public Integer getHomeRegulationPlusOtWins() {
        return homeRegulationPlusOtWins;
    }

    public void setHomeRegulationPlusOtWins(Integer homeRegulationPlusOtWins) {
        this.homeRegulationPlusOtWins = homeRegulationPlusOtWins;
    }

    public Integer getHomeRegulationWins() {
        return homeRegulationWins;
    }

    public void setHomeRegulationWins(Integer homeRegulationWins) {
        this.homeRegulationWins = homeRegulationWins;
    }

    public Integer getHomeTies() {
        return homeTies;
    }

    public void setHomeTies(Integer homeTies) {
        this.homeTies = homeTies;
    }

    public Integer getHomeWins() {
        return homeWins;
    }

    public void setHomeWins(Integer homeWins) {
        this.homeWins = homeWins;
    }

    public Integer getL10GamesPlayed() {
        return l10GamesPlayed;
    }

    public void setL10GamesPlayed(Integer l10GamesPlayed) {
        this.l10GamesPlayed = l10GamesPlayed;
    }

    public Integer getL10GoalDifferential() {
        return l10GoalDifferential;
    }

    public void setL10GoalDifferential(Integer l10GoalDifferential) {
        this.l10GoalDifferential = l10GoalDifferential;
    }

    public Integer getL10GoalsAgainst() {
        return l10GoalsAgainst;
    }

    public void setL10GoalsAgainst(Integer l10GoalsAgainst) {
        this.l10GoalsAgainst = l10GoalsAgainst;
    }

    public Integer getL10GoalsFor() {
        return l10GoalsFor;
    }

    public void setL10GoalsFor(Integer l10GoalsFor) {
        this.l10GoalsFor = l10GoalsFor;
    }

    public Integer getL10Losses() {
        return l10Losses;
    }

    public void setL10Losses(Integer l10Losses) {
        this.l10Losses = l10Losses;
    }

    public Integer getL10OtLosses() {
        return l10OtLosses;
    }

    public void setL10OtLosses(Integer l10OtLosses) {
        this.l10OtLosses = l10OtLosses;
    }

    public Integer getL10Points() {
        return l10Points;
    }

    public void setL10Points(Integer l10Points) {
        this.l10Points = l10Points;
    }

    public Integer getL10RegulationPlusOtWins() {
        return l10RegulationPlusOtWins;
    }

    public void setL10RegulationPlusOtWins(Integer l10RegulationPlusOtWins) {
        this.l10RegulationPlusOtWins = l10RegulationPlusOtWins;
    }

    public Integer getL10RegulationWins() {
        return l10RegulationWins;
    }

    public void setL10RegulationWins(Integer l10RegulationWins) {
        this.l10RegulationWins = l10RegulationWins;
    }

    public Integer getL10Ties() {
        return l10Ties;
    }

    public void setL10Ties(Integer l10Ties) {
        this.l10Ties = l10Ties;
    }

    public Integer getL10Wins() {
        return l10Wins;
    }

    public void setL10Wins(Integer l10Wins) {
        this.l10Wins = l10Wins;
    }

    public Integer getLeagueHomeSequence() {
        return leagueHomeSequence;
    }

    public void setLeagueHomeSequence(Integer leagueHomeSequence) {
        this.leagueHomeSequence = leagueHomeSequence;
    }

    public Integer getLeagueL10Sequence() {
        return leagueL10Sequence;
    }

    public void setLeagueL10Sequence(Integer leagueL10Sequence) {
        this.leagueL10Sequence = leagueL10Sequence;
    }

    public Integer getLeagueRoadSequence() {
        return leagueRoadSequence;
    }

    public void setLeagueRoadSequence(Integer leagueRoadSequence) {
        this.leagueRoadSequence = leagueRoadSequence;
    }

    public Integer getLeagueSequence() {
        return leagueSequence;
    }

    public void setLeagueSequence(Integer leagueSequence) {
        this.leagueSequence = leagueSequence;
    }

    public Integer getLosses() {
        return losses;
    }

    public void setLosses(Integer losses) {
        this.losses = losses;
    }

    public Integer getOtLosses() {
        return otLosses;
    }

    public void setOtLosses(Integer otLosses) {
        this.otLosses = otLosses;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public Float getPointPctg() {
        return pointPctg;
    }

    public void setPointPctg(Float pointPctg) {
        this.pointPctg = pointPctg;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public Float getRegulationPlusOtWinPctg() {
        return regulationPlusOtWinPctg;
    }

    public void setRegulationPlusOtWinPctg(Float regulationPlusOtWinPctg) {
        this.regulationPlusOtWinPctg = regulationPlusOtWinPctg;
    }

    public Integer getRegulationPlusOtWins() {
        return regulationPlusOtWins;
    }

    public void setRegulationPlusOtWins(Integer regulationPlusOtWins) {
        this.regulationPlusOtWins = regulationPlusOtWins;
    }

    public Float getRegulationWinPctg() {
        return regulationWinPctg;
    }

    public void setRegulationWinPctg(Float regulationWinPctg) {
        this.regulationWinPctg = regulationWinPctg;
    }

    public Integer getRegulationWins() {
        return regulationWins;
    }

    public void setRegulationWins(Integer regulationWins) {
        this.regulationWins = regulationWins;
    }

    public Integer getRoadGamesPlayed() {
        return roadGamesPlayed;
    }

    public void setRoadGamesPlayed(Integer roadGamesPlayed) {
        this.roadGamesPlayed = roadGamesPlayed;
    }

    public Integer getRoadGoalDifferential() {
        return roadGoalDifferential;
    }

    public void setRoadGoalDifferential(Integer roadGoalDifferential) {
        this.roadGoalDifferential = roadGoalDifferential;
    }

    public Integer getRoadGoalsAgainst() {
        return roadGoalsAgainst;
    }

    public void setRoadGoalsAgainst(Integer roadGoalsAgainst) {
        this.roadGoalsAgainst = roadGoalsAgainst;
    }

    public Integer getRoadGoalsFor() {
        return roadGoalsFor;
    }

    public void setRoadGoalsFor(Integer roadGoalsFor) {
        this.roadGoalsFor = roadGoalsFor;
    }

    public Integer getRoadLosses() {
        return roadLosses;
    }

    public void setRoadLosses(Integer roadLosses) {
        this.roadLosses = roadLosses;
    }

    public Integer getRoadOtLosses() {
        return roadOtLosses;
    }

    public void setRoadOtLosses(Integer roadOtLosses) {
        this.roadOtLosses = roadOtLosses;
    }

    public Integer getRoadPoints() {
        return roadPoints;
    }

    public void setRoadPoints(Integer roadPoints) {
        this.roadPoints = roadPoints;
    }

    public Integer getRoadRegulationPlusOtWins() {
        return roadRegulationPlusOtWins;
    }

    public void setRoadRegulationPlusOtWins(Integer roadRegulationPlusOtWins) {
        this.roadRegulationPlusOtWins = roadRegulationPlusOtWins;
    }

    public Integer getRoadRegulationWins() {
        return roadRegulationWins;
    }

    public void setRoadRegulationWins(Integer roadRegulationWins) {
        this.roadRegulationWins = roadRegulationWins;
    }

    public Integer getRoadTies() {
        return roadTies;
    }

    public void setRoadTies(Integer roadTies) {
        this.roadTies = roadTies;
    }

    public Integer getRoadWins() {
        return roadWins;
    }

    public void setRoadWins(Integer roadWins) {
        this.roadWins = roadWins;
    }

    public Integer getSeasonId() {
        return seasonId;
    }

    public void setSeasonId(Integer seasonId) {
        this.seasonId = seasonId;
    }

    public Integer getShootoutLosses() {
        return shootoutLosses;
    }

    public void setShootoutLosses(Integer shootoutLosses) {
        this.shootoutLosses = shootoutLosses;
    }

    public Integer getShootoutWins() {
        return shootoutWins;
    }

    public void setShootoutWins(Integer shootoutWins) {
        this.shootoutWins = shootoutWins;
    }

    public String getStreakCode() {
        return streakCode;
    }

    public void setStreakCode(String streakCode) {
        this.streakCode = streakCode;
    }

    public Integer getStreakCount() {
        return streakCount;
    }

    public void setStreakCount(Integer streakCount) {
        this.streakCount = streakCount;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getTeamCommonName() {
        return teamCommonName;
    }

    public void setTeamCommonName(String teamCommonName) {
        this.teamCommonName = teamCommonName;
    }

    public String getTeamAbbrev() {
        return teamAbbrev;
    }

    public void setTeamAbbrev(String teamAbbrev) {
        this.teamAbbrev = teamAbbrev;
    }

    public Integer getTies() {
        return ties;
    }

    public void setTies(Integer ties) {
        this.ties = ties;
    }

    public Integer getWaiversSequence() {
        return waiversSequence;
    }

    public void setWaiversSequence(Integer waiversSequence) {
        this.waiversSequence = waiversSequence;
    }

    public Integer getWildcardSequence() {
        return wildcardSequence;
    }

    public void setWildcardSequence(Integer wildcardSequence) {
        this.wildcardSequence = wildcardSequence;
    }

    public Float getWinPctg() {
        return winPctg;
    }

    public void setWinPctg(Float winPctg) {
        this.winPctg = winPctg;
    }

    public Integer getWins() {
        return wins;
    }

    public void setWins(Integer wins) {
        this.wins = wins;
    }

}

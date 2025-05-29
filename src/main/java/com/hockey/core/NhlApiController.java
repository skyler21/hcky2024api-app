package com.hockey.core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.ListIterator;
//import java.util.Map;

import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cglib.reflect.FastMember;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hockey.core.dao.TeamRepository;
import com.hockey.core.model.Team;
import com.hockey.core.dao.FranchiseRepository;
import com.hockey.core.model.Franchise;
import com.hockey.core.dao.GameRepository;
import com.hockey.core.dao.StandingRepository;
import com.hockey.core.dao.RosterRepository;
import com.hockey.core.dao.RostergoalieRepository;
import com.hockey.core.dao.RosterdefenseRepository;
import com.hockey.core.dao.RosterforwardRepository;
import com.hockey.core.model.Game;
import com.hockey.core.model.Standing;
import com.hockey.core.model.Roster;
import com.hockey.core.model.Rostergoalie;
import com.hockey.core.model.Rosterdefense;
import com.hockey.core.model.Rosterforward;
//import com.hockey.core.ReferenceData;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class NhlApiController {
	Logger logger = Logger.getLogger(NhlApiController.class);

	@Autowired
	TeamRepository teamRepository;

	@RequestMapping(value = "/api/load/teams", method = { RequestMethod.POST, RequestMethod.GET })
	@Transactional
	public String loadDBTeams() {

		//logger.debug("loadDBTeams has been reached");

		try {

			URL url = new URL("https://api.nhle.com/stats/rest/en/team");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("User-Agent",
					"Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");
			conn.setRequestProperty("Accept", "application/json");

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

			String myString;
			int count = 0;
			String dataLine = "";

			// truncate doesn't work with foreign table references
			// conferenceRepository.truncateConference();
			// divisionRepository.truncateDivision();
			// teamRepository.truncateTeam();

			teamRepository.deleteAll();

			//logger.debug("Output from Server .... \n");
			while ((myString = br.readLine()) != null) {
				count = count + 1;
				dataLine = dataLine + myString;

				// logger.debug(count + " " + myString);
			}

			JSONObject myJsonString = new JSONObject(dataLine);

			JSONArray teamsArray = myJsonString.getJSONArray("data");
			for (int i = 0; i < teamsArray.length(); i++) {
				Team nTeam = new Team();
				nTeam.setTeamId(teamsArray.getJSONObject(i).getInt("id"));
				nTeam.setFullName(teamsArray.getJSONObject(i).getString("fullName"));

				String testName = teamsArray.getJSONObject(i).getString("fullName");
				if (testName.equals("NHL") || testName.equals("To be determined")) {
					nTeam.setFranchiseId(0);
				} else {
					nTeam.setFranchiseId(teamsArray.getJSONObject(i).getInt("franchiseId"));
				}

				nTeam.setLeagueId(teamsArray.getJSONObject(i).getInt("leagueId"));
				nTeam.setRawTricode(teamsArray.getJSONObject(i).getString("rawTricode"));
				nTeam.setTriCode(teamsArray.getJSONObject(i).getString("triCode"));
				//logger.debug("TEAM " + nTeam);
				teamRepository.save(nTeam);

			}

			conn.disconnect();

		} catch (IOException e) {

			e.printStackTrace();

		}
		//
		return "Team Saved\n";
	}

	@Autowired
	FranchiseRepository franchiseRepository;

	@RequestMapping(value = "/api/load/franchises", method = { RequestMethod.POST, RequestMethod.GET })
	@Transactional
	public String loadDBFranchises() {

		//logger.debug("loadDBFranchises has been reached");

		try {

			URL url = new URL("https://api.nhle.com/stats/rest/en/franchise");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("User-Agent",
					"Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");
			conn.setRequestProperty("Accept", "application/json");

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

			String myString;
			int count = 0;
			String dataLine = "";

			// truncate doesn't work with foreign table references
			// conferenceRepository.truncateConference();
			// divisionRepository.truncateDivision();
			// teamRepository.truncateTeam();

			franchiseRepository.deleteAll();

			//logger.debug("Output from Server .... \n");
			while ((myString = br.readLine()) != null) {
				count = count + 1;
				dataLine = dataLine + myString;

				// logger.debug(count + " " + myString);
			}

			JSONObject myJsonString = new JSONObject(dataLine);

			JSONArray franchisesArray = myJsonString.getJSONArray("data");
			for (int i = 0; i < franchisesArray.length(); i++) {
				Franchise nFranchise = new Franchise();
				nFranchise.setFranchiseId(franchisesArray.getJSONObject(i).getInt("id"));
				nFranchise.setFullName(franchisesArray.getJSONObject(i).getString("fullName"));
				nFranchise.setTeamCommonName(franchisesArray.getJSONObject(i).getString("teamCommonName"));
				nFranchise.setTeamPlaceName(franchisesArray.getJSONObject(i).getString("teamPlaceName"));
				//logger.debug("FRANCHISE " + nFranchise);
				franchiseRepository.save(nFranchise);

			}

			conn.disconnect();

		} catch (IOException e) {

			e.printStackTrace();

		}
		//
		return "Franchise Saved\n";
	}

	@Autowired
	GameRepository gameRepository;

	@RequestMapping(value = "/api/load/games", method = { RequestMethod.POST, RequestMethod.GET })
	@Transactional
	public String loadDBGames() {

		//logger.debug("loadDBGames has been reached");

		try {
			ReferenceData refData = new ReferenceData();

			URL url = new URL("https://api.nhle.com/stats/rest/en/game");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("User-Agent",
					"Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");
			conn.setRequestProperty("Accept", "application/json");

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

			String myString;
			int count = 0;
			String dataLine = "";

			// truncate doesn't work with foreign table references
			// conferenceRepository.truncateConference();
			// divisionRepository.truncateDivision();
			// teamRepository.truncateTeam();

			gameRepository.deleteAll();

			//logger.debug("Output from Server .... \n");
			while ((myString = br.readLine()) != null) {
				count = count + 1;
				dataLine = dataLine + myString;

				// logger.debug(count + " " + myString);
			}

			JSONObject myJsonString = new JSONObject(dataLine);

			JSONArray gameArray = myJsonString.getJSONArray("data");
			for (int i = 0; i < gameArray.length(); i++) {
				int testSeason = gameArray.getJSONObject(i).getInt("season");
				if (testSeason == 20242025 || testSeason == 20232024) {
					Game nGame = new Game();
					nGame.setGameId(gameArray.getJSONObject(i).getInt("id"));
					nGame.setEasternStartTime(gameArray.getJSONObject(i).getString("easternStartTime"));
					nGame.setGameDate(gameArray.getJSONObject(i).getString("gameDate"));
					nGame.setGameNumber(gameArray.getJSONObject(i).getInt("gameNumber"));
					nGame.setGameScheduleStateId(gameArray.getJSONObject(i).getInt("gameScheduleStateId"));
					nGame.setGameStateId(gameArray.getJSONObject(i).getInt("gameStateId"));
					nGame.setGameType(gameArray.getJSONObject(i).getInt("gameType"));
					nGame.setGameTypeDesc(refData.getGameType(gameArray.getJSONObject(i).getInt("gameType")));
					nGame.setHomeScore(gameArray.getJSONObject(i).getInt("homeScore"));
					nGame.setHomeTeamId(gameArray.getJSONObject(i).getInt("homeTeamId"));
					nGame.setHomeTeamFullName(
							teamRepository.findNameByTeamId(gameArray.getJSONObject(i).getInt("homeTeamId")));

					if ((gameArray.getJSONObject(i).getInt("gameStateId")) == 1) {
						nGame.setPeriod(0);
					} else {
						nGame.setPeriod(gameArray.getJSONObject(i).getInt("period"));
					}

					nGame.setSeason(gameArray.getJSONObject(i).getInt("season"));
					nGame.setVisitingScore(gameArray.getJSONObject(i).getInt("visitingScore"));
					nGame.setVisitingTeamId(gameArray.getJSONObject(i).getInt("visitingTeamId"));
					nGame.setVisitingTeamFullName(
							teamRepository.findNameByTeamId(gameArray.getJSONObject(i).getInt("visitingTeamId")));
					//logger.debug("GAME " + nGame);
					gameRepository.save(nGame);
				}
			}

			conn.disconnect();

		} catch (IOException e) {

			e.printStackTrace();

		}
		//
		return "Game Saved\n";
	}

	@Autowired
	RosterRepository rosterRepository;
	@Autowired
	RosterdefenseRepository rosterdefenseRepository;
	@Autowired
	RosterforwardRepository rosterforwardRepository;
	@Autowired
	RostergoalieRepository rostergoalieRepository;

	// like curl localhost:8085/api/load/roster/date=2024-12-18
	@RequestMapping(value = "/api/load/roster/date={gameDate}", method = { RequestMethod.POST, RequestMethod.GET })
	@Transactional
	public String loadDBTeamRoster(@PathVariable("gameDate") String gameDate) {

		//logger.debug("loadDBTeamRoster has been reached");
		// int season = 20242025;

		// get Games for 'gameDate' (returns a List<Games>)
		// curl
		// "http://localhost:8085/db/get/findGames?gameSeason=20242025&gameType=Regular&gameTeam=NONE&gameDate=2024-12-18"

		// empty the Roster table (truncate doesn't work)
		rosterRepository.deleteAll();
		rostergoalieRepository.deleteAll();
		rosterforwardRepository.deleteAll();
		rosterdefenseRepository.deleteAll();

		HttpNHLClient httpNHLClient = new HttpNHLClient();

		try {
			List<Game> dayGames = httpNHLClient.findAll(gameDate);
			//logger.debug("dayGames = " + dayGames);
			String teamAbbr = "";
			Integer currentGameNumber = 0;
			// JSONObject myJsonGames = new JSONObject();

			for (Game g : dayGames) {
				currentGameNumber = g.getGameNumber();
				teamAbbr = teamRepository.findAbbrByTeamId(g.getHomeTeamId());
				getTeamRoster(teamAbbr, currentGameNumber);
				teamAbbr = teamRepository.findAbbrByTeamId(g.getVisitingTeamId());
				getTeamRoster(teamAbbr, currentGameNumber);

			}

		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		//
		return "After getTeamRoster complete\n";
	}

	public String getTeamRoster(String teamAbbrv, Integer gameNum) {

		//logger.debug("getTeamRoster has been reached");
		try {

			URL url = new URL("https://api-web.nhle.com/v1/roster/" + teamAbbrv + "/current");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("User-Agent",
					"Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");
			conn.setRequestProperty("Accept", "application/json");
			logger.debug("url is " + url);

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : api-web nhle HTTP error code : " + conn.getResponseCode());
			}

			String saveTeamAbbrv = teamAbbrv;
			String saveFirstName = "";
			String saveLastName = "";  
			Integer saveGameNum = gameNum;

			//logger.debug("TEAM ABBRV =  " + saveTeamAbbrv);

			// get header by 'key'
			// String server = conn.getHeaderField("Server");

			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

			String myString;
			int count = 0;
			String dataLine = "";
			int playerId = 0;

			// truncate doesn't work with foreign table references
			// conferenceRepository.truncateConference();
			// divisionRepository.truncateDivision();
			// teamRepository.truncateTeam();

			// rosterRepository.deleteAll();

			//logger.debug("Output from Server .... \n");
			while ((myString = br.readLine()) != null) {
				count = count + 1;
				dataLine = dataLine + myString;

				// logger.debug(count + " " + myString);
			}

			JSONObject myJsonString = new JSONObject(dataLine);

			JSONArray forwardsArray = myJsonString.getJSONArray("forwards");
			for (int fi = 0; fi < forwardsArray.length(); fi++) {
				playerId = forwardsArray.getJSONObject(fi).getInt("id");
				Roster nRoster = new Roster();
				nRoster.setRosterId(forwardsArray.getJSONObject(fi).getInt("id"));
				nRoster.setFirstName(forwardsArray.getJSONObject(fi).getJSONObject("firstName").getString("default"));
				nRoster.setLastName(forwardsArray.getJSONObject(fi).getJSONObject("lastName").getString("default"));
				nRoster.setSweaterNumber(forwardsArray.getJSONObject(fi).optInt("sweaterNumber"));
				nRoster.setPositionCode(forwardsArray.getJSONObject(fi).getString("positionCode"));
				
				if (forwardsArray.getJSONObject(fi).has("shootsCatches")) { 
					nRoster.setShootsCatches(forwardsArray.getJSONObject(fi).getString("shootsCatches"));
				} else {
					nRoster.setShootsCatches("R");
				}
								
				nRoster.setHeightInches(forwardsArray.getJSONObject(fi).getInt("heightInInches"));
				nRoster.setWeightPounds(forwardsArray.getJSONObject(fi).getInt("weightInPounds"));
				nRoster.setBirthDate(forwardsArray.getJSONObject(fi).getString("birthDate"));
				nRoster.setBirthCity(forwardsArray.getJSONObject(fi).getJSONObject("birthCity").getString("default"));
				nRoster.setBirthCountry(forwardsArray.getJSONObject(fi).getString("birthCountry"));
				String testCountryF = forwardsArray.getJSONObject(fi).getString("birthCountry");
				if ((testCountryF.equals("CAN")) || (testCountryF.equals("USA")) && forwardsArray.getJSONObject(fi).has("birthStateProvince")) {
					nRoster.setBirthStateProvince(
							forwardsArray.getJSONObject(fi).getJSONObject("birthStateProvince").getString("default"));
				} else {
					nRoster.setBirthStateProvince(" ");
				}
				nRoster.setTeamAbbr(saveTeamAbbrv);
			    saveFirstName = forwardsArray.getJSONObject(fi).getJSONObject("firstName").getString("default");
			    saveLastName = forwardsArray.getJSONObject(fi).getJSONObject("lastName").getString("default");  
				getForwardRoster(playerId, saveTeamAbbrv, saveFirstName, saveLastName, saveGameNum);

				//logger.debug("Roster " + nRoster);
				rosterRepository.save(nRoster);

			}

			JSONArray defenseArray = myJsonString.getJSONArray("defensemen");
			for (int di = 0; di < defenseArray.length(); di++) {
				playerId = defenseArray.getJSONObject(di).getInt("id");
				Roster nRoster = new Roster();
				nRoster.setRosterId(defenseArray.getJSONObject(di).getInt("id"));
				nRoster.setFirstName(defenseArray.getJSONObject(di).getJSONObject("firstName").getString("default"));
				nRoster.setLastName(defenseArray.getJSONObject(di).getJSONObject("lastName").getString("default"));
				nRoster.setSweaterNumber(defenseArray.getJSONObject(di).optInt("sweaterNumber"));
				nRoster.setPositionCode(defenseArray.getJSONObject(di).getString("positionCode"));
				nRoster.setShootsCatches(defenseArray.getJSONObject(di).getString("shootsCatches"));
				nRoster.setHeightInches(defenseArray.getJSONObject(di).getInt("heightInInches"));
				nRoster.setWeightPounds(defenseArray.getJSONObject(di).getInt("weightInPounds"));
				nRoster.setBirthDate(defenseArray.getJSONObject(di).getString("birthDate"));
				nRoster.setBirthCity(defenseArray.getJSONObject(di).getJSONObject("birthCity").getString("default"));
				nRoster.setBirthCountry(defenseArray.getJSONObject(di).getString("birthCountry"));
				String testCountryD = defenseArray.getJSONObject(di).getString("birthCountry");
				if ((testCountryD.equals("CAN")) || (testCountryD.equals("USA"))  && defenseArray.getJSONObject(di).has("birthStateProvince"))  {
					nRoster.setBirthStateProvince(
							defenseArray.getJSONObject(di).getJSONObject("birthStateProvince").getString("default"));
				} else {
					nRoster.setBirthStateProvince(" ");
				}
				nRoster.setTeamAbbr(saveTeamAbbrv);

				//logger.debug("Roster " + nRoster);
				rosterRepository.save(nRoster);
				saveFirstName = defenseArray.getJSONObject(di).getJSONObject("firstName").getString("default");
			    saveLastName = defenseArray.getJSONObject(di).getJSONObject("lastName").getString("default");  
				getDefenseRoster(playerId, saveTeamAbbrv, saveFirstName, saveLastName, saveGameNum);
			}

			JSONArray goaliesArray = myJsonString.getJSONArray("goalies");
			for (int gi = 0; gi < goaliesArray.length(); gi++) {
				playerId = goaliesArray.getJSONObject(gi).getInt("id");
				//logger.debug("Goalie playerId = " + playerId);
				Roster nRoster = new Roster();
				nRoster.setRosterId(goaliesArray.getJSONObject(gi).getInt("id"));
				
				//nRoster.setFirstName("xxxxx");
                nRoster.setFirstName(goaliesArray.getJSONObject(gi).getJSONObject("firstName").getString("default"));
				nRoster.setLastName(goaliesArray.getJSONObject(gi).getJSONObject("lastName").getString("default"));
				nRoster.setSweaterNumber(goaliesArray.getJSONObject(gi).optInt("sweaterNumber"));
				nRoster.setPositionCode(goaliesArray.getJSONObject(gi).getString("positionCode"));
				nRoster.setShootsCatches(goaliesArray.getJSONObject(gi).getString("shootsCatches"));
				nRoster.setHeightInches(goaliesArray.getJSONObject(gi).getInt("heightInInches"));
				nRoster.setWeightPounds(goaliesArray.getJSONObject(gi).getInt("weightInPounds"));
				nRoster.setBirthDate(goaliesArray.getJSONObject(gi).getString("birthDate"));
				nRoster.setBirthCity(goaliesArray.getJSONObject(gi).getJSONObject("birthCity").getString("default"));
				nRoster.setBirthCountry(goaliesArray.getJSONObject(gi).getString("birthCountry"));
				String testCountryG = goaliesArray.getJSONObject(gi).getString("birthCountry");
				if ((testCountryG.equals("CAN")) || (testCountryG.equals("USA"))  && goaliesArray.getJSONObject(gi).has("birthStateProvince")) {
					nRoster.setBirthStateProvince(
							goaliesArray.getJSONObject(gi).getJSONObject("birthStateProvince").getString("default"));
				} else {
					nRoster.setBirthStateProvince(" ");
				}

				nRoster.setTeamAbbr(saveTeamAbbrv);

				//logger.debug("Roster " + nRoster);
				rosterRepository.save(nRoster);
				saveFirstName = goaliesArray.getJSONObject(gi).getJSONObject("firstName").getString("default");
			    saveLastName = goaliesArray.getJSONObject(gi).getJSONObject("lastName").getString("default");  
			
				getGoalieRoster(playerId, saveTeamAbbrv, saveFirstName, saveLastName, saveGameNum);
				
				
			}

			conn.disconnect();
		}

		catch (IOException e) {

			e.printStackTrace();
		}
		return "Team Roster Saved\n";

	}

	public String getGoalieRoster(Integer playerId, String saveTeamAbbr, String saveFirstName, String saveLastName, Integer saveGameNum) {

		//logger.debug("getGoalieRoster has been reached");
		//logger.debug("PlayerID = " + playerId);
		try {

			URL urlGoalie = new URL("https://api-web.nhle.com/v1/player/" + playerId + "/landing");
			HttpURLConnection connGoalie = (HttpURLConnection) urlGoalie.openConnection();
			connGoalie.setRequestMethod("GET");
			connGoalie.setRequestProperty("User-Agent",
					"Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");
			connGoalie.setRequestProperty("Accept", "application/json");
			logger.debug("urlGoalie is " + urlGoalie);

			if (connGoalie.getResponseCode() != 200) {
				throw new RuntimeException("Failed : api-web nhle HTTP error code : " + connGoalie.getResponseCode());
			}

			BufferedReader brGoalie = new BufferedReader(new InputStreamReader((connGoalie.getInputStream())));

			String myStringG;
			int countG = 0;
			String dataLineG = "";

			// truncate doesn't work with foreign table references
			// conferenceRepository.truncateConference();
			// divisionRepository.truncateDivision();
			// teamRepository.truncateTeam();
			// rosterRepository.deleteAll();

			// logger.debug("Output from Server .... \n");
			while ((myStringG = brGoalie.readLine()) != null) {
				countG = countG + 1;
				dataLineG = dataLineG + myStringG;
				// logger.debug(countG + " " + myStringG);
			}

			JSONObject myJsonStringG = new JSONObject(dataLineG);
			if (myJsonStringG.has("featuredStats")) {
				Rostergoalie nRostergoalie = new Rostergoalie();
				nRostergoalie.setRosterId(myJsonStringG.getInt("playerId"));
				nRostergoalie.setIsActive(myJsonStringG.getBoolean("isActive"));
				nRostergoalie.setCurrentTeamId(myJsonStringG.getInt("currentTeamId"));
				nRostergoalie.setSeasonYear(myJsonStringG.getJSONObject("featuredStats").getInt("season"));
				nRostergoalie.setSeasonType("regularSeason");
				nRostergoalie.setGamesPlayed(myJsonStringG.getJSONObject("featuredStats").getJSONObject("regularSeason")
						.getJSONObject("subSeason").getInt("gamesPlayed"));
				nRostergoalie.setGoalsAgainstAvg(myJsonStringG.getJSONObject("featuredStats")
						.getJSONObject("regularSeason").getJSONObject("subSeason").getFloat("goalsAgainstAvg"));
				nRostergoalie.setGameLosses(myJsonStringG.getJSONObject("featuredStats").getJSONObject("regularSeason")
						.getJSONObject("subSeason").getInt("losses"));
				nRostergoalie.setGameOtLosses(myJsonStringG.getJSONObject("featuredStats")
						.getJSONObject("regularSeason").getJSONObject("subSeason").getInt("otLosses"));
				nRostergoalie.setSavePctg(0.0f);
				// nRostergoalie.setSavePctg(myJsonStringG.getJSONObject("featuredStats").getJSONObject("regularSeason")
				// .getJSONObject("subSeason").getFloat("savePctg"));
				nRostergoalie.setShutouts(myJsonStringG.getJSONObject("featuredStats").getJSONObject("regularSeason")
						.getJSONObject("subSeason").getInt("shutouts"));
				nRostergoalie.setGameWins(myJsonStringG.getJSONObject("featuredStats").getJSONObject("regularSeason")
						.getJSONObject("subSeason").getInt("wins"));
				nRostergoalie.setFirstName(saveFirstName);
				nRostergoalie.setLastName(saveLastName);
				nRostergoalie.setTeamAbbr(saveTeamAbbr);
				nRostergoalie.setGameNumber(saveGameNum);
		

				JSONArray goaliesArrayG = myJsonStringG.getJSONArray("last5Games");
				for (int gar = 0; gar < goaliesArrayG.length(); gar++) {
				
					switch (gar) {
						case 0:
							if (goaliesArrayG.getJSONObject(gar).has("decision")) { 
								nRostergoalie.setLast5games01Decision(
										goaliesArrayG.getJSONObject(gar).getString("decision"));
							} else {
  								nRostergoalie.setLast5games01Decision("N");
							}

							nRostergoalie.setLast5games01Date(goaliesArrayG.getJSONObject(gar).getString("gameDate"));
							nRostergoalie.setLast5games01GameId(goaliesArrayG.getJSONObject(gar).getInt("gameId"));
							nRostergoalie
									.setLast5games01GameTypeId(goaliesArrayG.getJSONObject(gar).getInt("gameTypeId"));
							nRostergoalie.setLast5games01GamesStarted(
									goaliesArrayG.getJSONObject(gar).getInt("gamesStarted"));
							nRostergoalie.setLast5games01GoalsAgainst(
									goaliesArrayG.getJSONObject(gar).getInt("goalsAgainst"));
							nRostergoalie.setLast5games01HomeRoadFlag(
									goaliesArrayG.getJSONObject(gar).getString("homeRoadFlag"));
							nRostergoalie.setLast5games01OpponentAbbrv(
									goaliesArrayG.getJSONObject(gar).getString("opponentAbbrev"));

							if (goaliesArrayG.getJSONObject(gar).has("savePctg")) {

								nRostergoalie
										.setLast5games01SavePctg(goaliesArrayG.getJSONObject(gar).optFloat("savePctg"));
							} else {
								nRostergoalie.setLast5games01SavePctg(0.0f);
							}

							nRostergoalie.setLast5games01ShotsAgainst(
									goaliesArrayG.getJSONObject(gar).getInt("shotsAgainst"));

						case 1:
						    if (goaliesArrayG.getJSONObject(gar).has("decision")) {
								nRostergoalie.setLast5games02Decision(
									goaliesArrayG.getJSONObject(gar).getString("decision"));
  							} else {
	
									nRostergoalie.setLast5games02Decision("N");
							}

							nRostergoalie.setLast5games02Date(goaliesArrayG.getJSONObject(gar).getString("gameDate"));
							nRostergoalie.setLast5games02GameId(goaliesArrayG.getJSONObject(gar).getInt("gameId"));
							nRostergoalie
									.setLast5games02GameTypeId(goaliesArrayG.getJSONObject(gar).getInt("gameTypeId"));
							nRostergoalie.setLast5games02GamesStarted(
									goaliesArrayG.getJSONObject(gar).getInt("gamesStarted"));
							nRostergoalie.setLast5games02GoalsAgainst(
									goaliesArrayG.getJSONObject(gar).getInt("goalsAgainst"));
							nRostergoalie.setLast5games02HomeRoadFlag(
									goaliesArrayG.getJSONObject(gar).getString("homeRoadFlag"));
							nRostergoalie.setLast5games02OpponentAbbrv(
									goaliesArrayG.getJSONObject(gar).getString("opponentAbbrev"));

							if (goaliesArrayG.getJSONObject(gar).has("savePctg")) {

								nRostergoalie
										.setLast5games02SavePctg(goaliesArrayG.getJSONObject(gar).optFloat("savePctg"));
							} else {
								nRostergoalie.setLast5games02SavePctg(0.0f);
							}

							nRostergoalie.setLast5games02ShotsAgainst(
									goaliesArrayG.getJSONObject(gar).getInt("shotsAgainst"));

						case 2:
						    if (goaliesArrayG.getJSONObject(gar).has("decision")) {
								nRostergoalie.setLast5games03Decision(
									goaliesArrayG.getJSONObject(gar).getString("decision"));
							} else {
								nRostergoalie.setLast5games03Decision("N");
							}

							nRostergoalie.setLast5games03Date(goaliesArrayG.getJSONObject(gar).getString("gameDate"));
							nRostergoalie.setLast5games03GameId(goaliesArrayG.getJSONObject(gar).getInt("gameId"));
							nRostergoalie
									.setLast5games03GameTypeId(goaliesArrayG.getJSONObject(gar).getInt("gameTypeId"));
							nRostergoalie.setLast5games03GamesStarted(
									goaliesArrayG.getJSONObject(gar).getInt("gamesStarted"));
							nRostergoalie.setLast5games03GoalsAgainst(
									goaliesArrayG.getJSONObject(gar).getInt("goalsAgainst"));
							nRostergoalie.setLast5games03HomeRoadFlag(
									goaliesArrayG.getJSONObject(gar).getString("homeRoadFlag"));
							nRostergoalie.setLast5games03OpponentAbbrv(
									goaliesArrayG.getJSONObject(gar).getString("opponentAbbrev"));
							if (goaliesArrayG.getJSONObject(gar).has("savePctg")) {

								nRostergoalie
										.setLast5games03SavePctg(goaliesArrayG.getJSONObject(gar).optFloat("savePctg"));
							} else {
								nRostergoalie.setLast5games03SavePctg(0.0f);
							}

							nRostergoalie.setLast5games03ShotsAgainst(
									goaliesArrayG.getJSONObject(gar).getInt("shotsAgainst"));

						case 3:
						    if (goaliesArrayG.getJSONObject(gar).has("decision")) {
								nRostergoalie.setLast5games04Decision(
										goaliesArrayG.getJSONObject(gar).getString("decision"));
							} else {
								nRostergoalie.setLast5games04Decision("N");
							}

							nRostergoalie.setLast5games04Date(goaliesArrayG.getJSONObject(gar).getString("gameDate"));
							nRostergoalie.setLast5games04GameId(goaliesArrayG.getJSONObject(gar).getInt("gameId"));
							nRostergoalie
									.setLast5games04GameTypeId(goaliesArrayG.getJSONObject(gar).getInt("gameTypeId"));
							nRostergoalie.setLast5games04GamesStarted(
									goaliesArrayG.getJSONObject(gar).getInt("gamesStarted"));
							nRostergoalie.setLast5games04GoalsAgainst(
									goaliesArrayG.getJSONObject(gar).getInt("goalsAgainst"));
							nRostergoalie.setLast5games04HomeRoadFlag(
									goaliesArrayG.getJSONObject(gar).getString("homeRoadFlag"));
							nRostergoalie.setLast5games04OpponentAbbrv(
									goaliesArrayG.getJSONObject(gar).getString("opponentAbbrev"));

							if (goaliesArrayG.getJSONObject(gar).has("savePctg")) {

								nRostergoalie
										.setLast5games04SavePctg(goaliesArrayG.getJSONObject(gar).optFloat("savePctg"));
							} else {
								nRostergoalie.setLast5games04SavePctg(0.0f);
							}

							nRostergoalie.setLast5games04ShotsAgainst(
									goaliesArrayG.getJSONObject(gar).getInt("shotsAgainst"));

						case 4:
						    if (goaliesArrayG.getJSONObject(gar).has("decision")) {
								nRostergoalie.setLast5games05Decision(
									goaliesArrayG.getJSONObject(gar).getString("decision"));
							} else {
								nRostergoalie.setLast5games05Decision("N");
							}

							nRostergoalie.setLast5games05Date(goaliesArrayG.getJSONObject(gar).getString("gameDate"));
							nRostergoalie.setLast5games05GameId(goaliesArrayG.getJSONObject(gar).getInt("gameId"));
							nRostergoalie
									.setLast5games05GameTypeId(goaliesArrayG.getJSONObject(gar).getInt("gameTypeId"));
							nRostergoalie.setLast5games05GamesStarted(
									goaliesArrayG.getJSONObject(gar).getInt("gamesStarted"));
							nRostergoalie.setLast5games05GoalsAgainst(
									goaliesArrayG.getJSONObject(gar).getInt("goalsAgainst"));
							nRostergoalie.setLast5games05HomeRoadFlag(
									goaliesArrayG.getJSONObject(gar).getString("homeRoadFlag"));
							nRostergoalie.setLast5games05OpponentAbbrv(
									goaliesArrayG.getJSONObject(gar).getString("opponentAbbrev"));
						
							if (goaliesArrayG.getJSONObject(gar).has("savePctg")) {

								nRostergoalie
										.setLast5games05SavePctg(goaliesArrayG.getJSONObject(gar).optFloat("savePctg"));
							} else {
								nRostergoalie.setLast5games05SavePctg(0.0f);
							}
						
							nRostergoalie.setLast5games05ShotsAgainst(
									goaliesArrayG.getJSONObject(gar).getInt("shotsAgainst"));
					}
				}
				// logger.debug("RosterGoalie " + nRostergoalie);
				rostergoalieRepository.save(nRostergoalie);
				//logger.debug("RosterGoalie SAVED ===========================================\n");
			}
			connGoalie.disconnect();

		} catch (IOException e) {
			e.printStackTrace();

		}

		//
		return "Roster Goalie Complete\n";
	}

	public String getDefenseRoster(Integer playerId, String saveTeamAbbr, String saveFirstName, String saveLastName, Integer saveGameNum) {

		//logger.debug("getDefenseRoster has been reached");
		//logger.debug("PlayerID = " + playerId);
		try {

			URL urlDefense = new URL("https://api-web.nhle.com/v1/player/" + playerId + "/landing");
			HttpURLConnection connDefense = (HttpURLConnection) urlDefense.openConnection();
			connDefense.setRequestMethod("GET");
			connDefense.setRequestProperty("User-Agent",
					"Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");
			connDefense.setRequestProperty("Accept", "application/json");
			logger.debug("urlDefense is " + urlDefense);

			if (connDefense.getResponseCode() != 200) {
				throw new RuntimeException("Failed : api-web nhle HTTP error code : " + connDefense.getResponseCode());
			}

			BufferedReader brDefense = new BufferedReader(new InputStreamReader((connDefense.getInputStream())));

			String myStringD;
			int countD = 0;
			String dataLineD = "";

			// truncate doesn't work with foreign table references
			// conferenceRepository.truncateConference();
			// divisionRepository.truncateDivision();
			// teamRepository.truncateTeam();
			// rosterRepository.deleteAll();

			// logger.debug("Output from Server .... \n");
			while ((myStringD = brDefense.readLine()) != null) {
				countD = countD + 1;
				dataLineD = dataLineD + myStringD;
				// logger.debug(countD + " " + myStringD);
			}

			JSONObject myJsonStringD = new JSONObject(dataLineD);

			if (myJsonStringD.has("featuredStats")) {
				Rosterdefense nRosterdefense = new Rosterdefense();
				nRosterdefense.setRosterId(myJsonStringD.getInt("playerId"));
				nRosterdefense.setIsActive(myJsonStringD.getBoolean("isActive"));
				nRosterdefense.setCurrentTeamId(myJsonStringD.getInt("currentTeamId"));
				nRosterdefense.setSeasonYear(myJsonStringD.getJSONObject("featuredStats").getInt("season"));
				nRosterdefense.setSeasonType("regularSeason");
				nRosterdefense.setGamesAssists(myJsonStringD.getJSONObject("featuredStats")
						.getJSONObject("regularSeason").getJSONObject("subSeason").getInt("assists"));
				nRosterdefense.setGameWinningGoals(myJsonStringD.getJSONObject("featuredStats")
						.getJSONObject("regularSeason").getJSONObject("subSeason").getInt("gameWinningGoals"));
				nRosterdefense.setGamesPlayed(myJsonStringD.getJSONObject("featuredStats")
						.getJSONObject("regularSeason").getJSONObject("subSeason").getInt("gamesPlayed"));
				nRosterdefense.setGameGoals(myJsonStringD.getJSONObject("featuredStats").getJSONObject("regularSeason")
						.getJSONObject("subSeason").getInt("goals"));
				nRosterdefense.setGameOtGoals(myJsonStringD.getJSONObject("featuredStats")
						.getJSONObject("regularSeason").getJSONObject("subSeason").getInt("otGoals"));
				nRosterdefense.setGamePim(myJsonStringD.getJSONObject("featuredStats").getJSONObject("regularSeason")
						.getJSONObject("subSeason").getInt("pim"));
				nRosterdefense.setGamePlusMinus(myJsonStringD.getJSONObject("featuredStats")
						.getJSONObject("regularSeason").getJSONObject("subSeason").getInt("plusMinus"));
				nRosterdefense.setGamePoints(myJsonStringD.getJSONObject("featuredStats").getJSONObject("regularSeason")
						.getJSONObject("subSeason").getInt("points"));
				nRosterdefense.setGamePowerPlayGoals(myJsonStringD.getJSONObject("featuredStats")
						.getJSONObject("regularSeason").getJSONObject("subSeason").getInt("powerPlayGoals"));
				nRosterdefense.setGamePowerPlayPoints(myJsonStringD.getJSONObject("featuredStats")
						.getJSONObject("regularSeason").getJSONObject("subSeason").getInt("powerPlayPoints"));
				nRosterdefense.setGameShorthandedGoals(myJsonStringD.getJSONObject("featuredStats")
						.getJSONObject("regularSeason").getJSONObject("subSeason").getInt("shorthandedGoals"));
				nRosterdefense.setGameShorthandedPoints(myJsonStringD.getJSONObject("featuredStats")
						.getJSONObject("regularSeason").getJSONObject("subSeason").getInt("shorthandedPoints"));
				nRosterdefense.setGameShots(myJsonStringD.getJSONObject("featuredStats").getJSONObject("regularSeason")
						.getJSONObject("subSeason").getInt("shots"));
				nRosterdefense.setFirstName(saveFirstName);
				nRosterdefense.setLastName(saveLastName);
				nRosterdefense.setTeamAbbr(saveTeamAbbr);
				nRosterdefense.setGameNumber(saveGameNum);

				JSONArray defensesArrayD = myJsonStringD.getJSONArray("last5Games");
				for (int dar = 0; dar < defensesArrayD.length(); dar++) {
					// Integer testGamesStarted;
					// String testGameTime;

					switch (dar) {
						case 0:
							nRosterdefense.setLast5games01Assists(defensesArrayD.getJSONObject(dar).getInt("assists"));
							nRosterdefense.setLast5games01Date(defensesArrayD.getJSONObject(dar).getString("gameDate"));
							nRosterdefense.setLast5games01GameId(defensesArrayD.getJSONObject(dar).getInt("gameId"));
							nRosterdefense
									.setLast5games01GameTypeId(defensesArrayD.getJSONObject(dar).getInt("gameTypeId"));
							nRosterdefense.setLast5games01Goals(defensesArrayD.getJSONObject(dar).getInt("goals"));
							nRosterdefense.setLast5games01HomeRoadFlag(
									defensesArrayD.getJSONObject(dar).getString("homeRoadFlag"));
							nRosterdefense.setLast5games01OpponentAbbrv(
									defensesArrayD.getJSONObject(dar).getString("opponentAbbrev"));
							nRosterdefense.setLast5games01Pim(defensesArrayD.getJSONObject(dar).getInt("pim"));
							nRosterdefense
									.setLast5games01PlusMinus(defensesArrayD.getJSONObject(dar).getInt("plusMinus"));
							nRosterdefense.setLast5games01Points(defensesArrayD.getJSONObject(dar).getInt("points"));
							nRosterdefense.setLast5games01PowerplayGoals(
									defensesArrayD.getJSONObject(dar).getInt("powerPlayGoals"));
							nRosterdefense.setLast5games01Shifts(defensesArrayD.getJSONObject(dar).getInt("shifts"));
							nRosterdefense.setLast5games01ShorthandedGoals(
									defensesArrayD.getJSONObject(dar).getInt("shorthandedGoals"));
							nRosterdefense.setLast5games01Shots(defensesArrayD.getJSONObject(dar).getInt("shots"));
							nRosterdefense.setLast5games01Toi(defensesArrayD.getJSONObject(dar).getString("toi"));

						case 1:
							nRosterdefense.setLast5games02Assists(defensesArrayD.getJSONObject(dar).getInt("assists"));
							nRosterdefense.setLast5games02Date(defensesArrayD.getJSONObject(dar).getString("gameDate"));
							nRosterdefense.setLast5games02GameId(defensesArrayD.getJSONObject(dar).getInt("gameId"));
							nRosterdefense
									.setLast5games02GameTypeId(defensesArrayD.getJSONObject(dar).getInt("gameTypeId"));
							nRosterdefense.setLast5games02Goals(defensesArrayD.getJSONObject(dar).getInt("goals"));
							nRosterdefense.setLast5games02HomeRoadFlag(
									defensesArrayD.getJSONObject(dar).getString("homeRoadFlag"));
							nRosterdefense.setLast5games02OpponentAbbrv(
									defensesArrayD.getJSONObject(dar).getString("opponentAbbrev"));
							nRosterdefense.setLast5games02Pim(defensesArrayD.getJSONObject(dar).getInt("pim"));
							nRosterdefense
									.setLast5games02PlusMinus(defensesArrayD.getJSONObject(dar).getInt("plusMinus"));
							nRosterdefense.setLast5games02Points(defensesArrayD.getJSONObject(dar).getInt("points"));
							nRosterdefense.setLast5games02PowerplayGoals(
									defensesArrayD.getJSONObject(dar).getInt("powerPlayGoals"));
							nRosterdefense.setLast5games02Shifts(defensesArrayD.getJSONObject(dar).getInt("shifts"));
							nRosterdefense.setLast5games02ShorthandedGoals(
									defensesArrayD.getJSONObject(dar).getInt("shorthandedGoals"));
							nRosterdefense.setLast5games02Shots(defensesArrayD.getJSONObject(dar).getInt("shots"));
							nRosterdefense.setLast5games02Toi(defensesArrayD.getJSONObject(dar).getString("toi"));

						case 2:
							nRosterdefense.setLast5games03Assists(defensesArrayD.getJSONObject(dar).getInt("assists"));
							nRosterdefense.setLast5games03Date(defensesArrayD.getJSONObject(dar).getString("gameDate"));
							nRosterdefense.setLast5games03GameId(defensesArrayD.getJSONObject(dar).getInt("gameId"));
							nRosterdefense
									.setLast5games03GameTypeId(defensesArrayD.getJSONObject(dar).getInt("gameTypeId"));
							nRosterdefense.setLast5games03Goals(defensesArrayD.getJSONObject(dar).getInt("goals"));
							nRosterdefense.setLast5games03HomeRoadFlag(
									defensesArrayD.getJSONObject(dar).getString("homeRoadFlag"));
							nRosterdefense.setLast5games03OpponentAbbrv(
									defensesArrayD.getJSONObject(dar).getString("opponentAbbrev"));
							nRosterdefense.setLast5games03Pim(defensesArrayD.getJSONObject(dar).getInt("pim"));
							nRosterdefense
									.setLast5games03PlusMinus(defensesArrayD.getJSONObject(dar).getInt("plusMinus"));
							nRosterdefense.setLast5games03Points(defensesArrayD.getJSONObject(dar).getInt("points"));
							nRosterdefense.setLast5games03PowerplayGoals(
									defensesArrayD.getJSONObject(dar).getInt("powerPlayGoals"));
							nRosterdefense.setLast5games03Shifts(defensesArrayD.getJSONObject(dar).getInt("shifts"));
							nRosterdefense.setLast5games03ShorthandedGoals(
									defensesArrayD.getJSONObject(dar).getInt("shorthandedGoals"));
							nRosterdefense.setLast5games03Shots(defensesArrayD.getJSONObject(dar).getInt("shots"));
							nRosterdefense.setLast5games03Toi(defensesArrayD.getJSONObject(dar).getString("toi"));

						case 3:
							nRosterdefense.setLast5games04Assists(defensesArrayD.getJSONObject(dar).getInt("assists"));
							nRosterdefense.setLast5games04Date(defensesArrayD.getJSONObject(dar).getString("gameDate"));
							nRosterdefense.setLast5games04GameId(defensesArrayD.getJSONObject(dar).getInt("gameId"));
							nRosterdefense
									.setLast5games04GameTypeId(defensesArrayD.getJSONObject(dar).getInt("gameTypeId"));
							nRosterdefense.setLast5games04Goals(defensesArrayD.getJSONObject(dar).getInt("goals"));
							nRosterdefense.setLast5games04HomeRoadFlag(
									defensesArrayD.getJSONObject(dar).getString("homeRoadFlag"));
							nRosterdefense.setLast5games04OpponentAbbrv(
									defensesArrayD.getJSONObject(dar).getString("opponentAbbrev"));
							nRosterdefense.setLast5games04Pim(defensesArrayD.getJSONObject(dar).getInt("pim"));
							nRosterdefense
									.setLast5games04PlusMinus(defensesArrayD.getJSONObject(dar).getInt("plusMinus"));
							nRosterdefense.setLast5games04Points(defensesArrayD.getJSONObject(dar).getInt("points"));
							nRosterdefense.setLast5games04PowerplayGoals(
									defensesArrayD.getJSONObject(dar).getInt("powerPlayGoals"));
							nRosterdefense.setLast5games04Shifts(defensesArrayD.getJSONObject(dar).getInt("shifts"));
							nRosterdefense.setLast5games04ShorthandedGoals(
									defensesArrayD.getJSONObject(dar).getInt("shorthandedGoals"));
							nRosterdefense.setLast5games04Shots(defensesArrayD.getJSONObject(dar).getInt("shots"));
							nRosterdefense.setLast5games04Toi(defensesArrayD.getJSONObject(dar).getString("toi"));

						case 4:
							nRosterdefense.setLast5games05Assists(defensesArrayD.getJSONObject(dar).getInt("assists"));
							nRosterdefense.setLast5games05Date(defensesArrayD.getJSONObject(dar).getString("gameDate"));
							nRosterdefense.setLast5games05GameId(defensesArrayD.getJSONObject(dar).getInt("gameId"));
							nRosterdefense
									.setLast5games05GameTypeId(defensesArrayD.getJSONObject(dar).getInt("gameTypeId"));
							nRosterdefense.setLast5games05Goals(defensesArrayD.getJSONObject(dar).getInt("goals"));
							nRosterdefense.setLast5games05HomeRoadFlag(
									defensesArrayD.getJSONObject(dar).getString("homeRoadFlag"));
							nRosterdefense.setLast5games05OpponentAbbrv(
									defensesArrayD.getJSONObject(dar).getString("opponentAbbrev"));
							nRosterdefense.setLast5games05Pim(defensesArrayD.getJSONObject(dar).getInt("pim"));
							nRosterdefense
									.setLast5games05PlusMinus(defensesArrayD.getJSONObject(dar).getInt("plusMinus"));
							nRosterdefense.setLast5games05Points(defensesArrayD.getJSONObject(dar).getInt("points"));
							nRosterdefense.setLast5games05PowerplayGoals(
									defensesArrayD.getJSONObject(dar).getInt("powerPlayGoals"));
							nRosterdefense.setLast5games05Shifts(defensesArrayD.getJSONObject(dar).getInt("shifts"));
							nRosterdefense.setLast5games05ShorthandedGoals(
									defensesArrayD.getJSONObject(dar).getInt("shorthandedGoals"));
							nRosterdefense.setLast5games05Shots(defensesArrayD.getJSONObject(dar).getInt("shots"));
							nRosterdefense.setLast5games05Toi(defensesArrayD.getJSONObject(dar).getString("toi"));

					}
				}
				// logger.debug("RosterDefense " + nRosterdefense);
				rosterdefenseRepository.save(nRosterdefense);
				//logger.debug("RosterDefense SAVED ===========================================\n");
			}
			connDefense.disconnect();

		} catch (IOException e) {
			e.printStackTrace();

		}

		//
		return "Roster Defense Complete\n";
	}

	public String getForwardRoster(Integer playerId, String saveTeamAbbr, String saveFirstName, String saveLastName, Integer saveGameNum) {

		//logger.debug("getForwardRoster has been reached");
		//logger.debug("PlayerID = " + playerId);
		try {

			URL urlForward = new URL("https://api-web.nhle.com/v1/player/" + playerId + "/landing");
			HttpURLConnection connForward = (HttpURLConnection) urlForward.openConnection();
			connForward.setRequestMethod("GET");
			connForward.setRequestProperty("User-Agent",
					"Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");
			connForward.setRequestProperty("Accept", "application/json");
			logger.debug("urlForward is " + urlForward);

			if (connForward.getResponseCode() != 200) {
				throw new RuntimeException("Failed : api-web nhle HTTP error code : " + connForward.getResponseCode());
			}

			BufferedReader brForward = new BufferedReader(new InputStreamReader((connForward.getInputStream())));

			String myStringF;
			int countF = 0;
			String dataLineF = "";

			// truncate doesn't work with foreign table references
			// conferenceRepository.truncateConference();
			// divisionRepository.truncateDivision();
			// teamRepository.truncateTeam();
			// rosterRepository.deleteAll();

			// logger.debug("Output from Server .... \n");
			while ((myStringF = brForward.readLine()) != null) {
				countF = countF + 1;
				dataLineF = dataLineF + myStringF;
				// logger.debug(countF + " " + myStringF);
			}

			JSONObject myJsonStringF = new JSONObject(dataLineF);
			if (myJsonStringF.has("featuredStats")) {
				Rosterforward nRosterforward = new Rosterforward();
				nRosterforward.setRosterId(myJsonStringF.getInt("playerId"));
				nRosterforward.setIsActive(myJsonStringF.getBoolean("isActive"));
				nRosterforward.setCurrentTeamId(myJsonStringF.getInt("currentTeamId"));
				nRosterforward.setSeasonYear(myJsonStringF.getJSONObject("featuredStats").getInt("season"));
				nRosterforward.setSeasonType("regularSeason");
				nRosterforward.setGamesAssists(myJsonStringF.getJSONObject("featuredStats")
						.getJSONObject("regularSeason").getJSONObject("subSeason").getInt("assists"));
				nRosterforward.setGameWinningGoals(myJsonStringF.getJSONObject("featuredStats")
						.getJSONObject("regularSeason").getJSONObject("subSeason").getInt("gameWinningGoals"));
				nRosterforward.setGamesPlayed(myJsonStringF.getJSONObject("featuredStats")
						.getJSONObject("regularSeason").getJSONObject("subSeason").getInt("gamesPlayed"));
				nRosterforward.setGameGoals(myJsonStringF.getJSONObject("featuredStats").getJSONObject("regularSeason")
						.getJSONObject("subSeason").getInt("goals"));
				nRosterforward.setGameOtGoals(myJsonStringF.getJSONObject("featuredStats")
						.getJSONObject("regularSeason").getJSONObject("subSeason").getInt("otGoals"));
				nRosterforward.setGamePim(myJsonStringF.getJSONObject("featuredStats").getJSONObject("regularSeason")
						.getJSONObject("subSeason").getInt("pim"));
				nRosterforward.setGamePlusMinus(myJsonStringF.getJSONObject("featuredStats")
						.getJSONObject("regularSeason").getJSONObject("subSeason").getInt("plusMinus"));
				nRosterforward.setGamePoints(myJsonStringF.getJSONObject("featuredStats").getJSONObject("regularSeason")
						.getJSONObject("subSeason").getInt("points"));
				nRosterforward.setGamePowerPlayGoals(myJsonStringF.getJSONObject("featuredStats")
						.getJSONObject("regularSeason").getJSONObject("subSeason").getInt("powerPlayGoals"));
				nRosterforward.setGamePowerPlayPoints(myJsonStringF.getJSONObject("featuredStats")
						.getJSONObject("regularSeason").getJSONObject("subSeason").getInt("powerPlayPoints"));
				nRosterforward.setGameShorthandedGoals(myJsonStringF.getJSONObject("featuredStats")
						.getJSONObject("regularSeason").getJSONObject("subSeason").getInt("shorthandedGoals"));
				nRosterforward.setGameShorthandedPoints(myJsonStringF.getJSONObject("featuredStats")
						.getJSONObject("regularSeason").getJSONObject("subSeason").getInt("shorthandedPoints"));
				nRosterforward.setGameShots(myJsonStringF.getJSONObject("featuredStats").getJSONObject("regularSeason")
						.getJSONObject("subSeason").getInt("shots"));
				nRosterforward.setFirstName(saveFirstName);
				nRosterforward.setLastName(saveLastName);
				nRosterforward.setTeamAbbr(saveTeamAbbr);
				nRosterforward.setGameNumber(saveGameNum);
			
				JSONArray forwardsArrayF = myJsonStringF.getJSONArray("last5Games");
				for (int far = 0; far < forwardsArrayF.length(); far++) {
					// Integer testGamesStarted;
					// String testGameTime;

					switch (far) {
						case 0:
							nRosterforward.setLast5games01Assists(forwardsArrayF.getJSONObject(far).getInt("assists"));
							nRosterforward.setLast5games01Date(forwardsArrayF.getJSONObject(far).getString("gameDate"));
							nRosterforward.setLast5games01GameId(forwardsArrayF.getJSONObject(far).getInt("gameId"));
							nRosterforward
									.setLast5games01GameTypeId(forwardsArrayF.getJSONObject(far).getInt("gameTypeId"));
							nRosterforward.setLast5games01Goals(forwardsArrayF.getJSONObject(far).getInt("goals"));
							nRosterforward.setLast5games01HomeRoadFlag(
									forwardsArrayF.getJSONObject(far).getString("homeRoadFlag"));
							nRosterforward.setLast5games01OpponentAbbrv(
									forwardsArrayF.getJSONObject(far).getString("opponentAbbrev"));
							nRosterforward.setLast5games01Pim(forwardsArrayF.getJSONObject(far).getInt("pim"));
							nRosterforward
									.setLast5games01PlusMinus(forwardsArrayF.getJSONObject(far).getInt("plusMinus"));
							nRosterforward.setLast5games01Points(forwardsArrayF.getJSONObject(far).getInt("points"));
							nRosterforward.setLast5games01PowerplayGoals(
									forwardsArrayF.getJSONObject(far).getInt("powerPlayGoals"));
							nRosterforward.setLast5games01Shifts(forwardsArrayF.getJSONObject(far).getInt("shifts"));
							nRosterforward.setLast5games01ShorthandedGoals(
									forwardsArrayF.getJSONObject(far).getInt("shorthandedGoals"));
							nRosterforward.setLast5games01Shots(forwardsArrayF.getJSONObject(far).getInt("shots"));
							nRosterforward.setLast5games01Toi(forwardsArrayF.getJSONObject(far).getString("toi"));

						case 1:
							nRosterforward.setLast5games02Assists(forwardsArrayF.getJSONObject(far).getInt("assists"));
							nRosterforward.setLast5games02Date(forwardsArrayF.getJSONObject(far).getString("gameDate"));
							nRosterforward.setLast5games02GameId(forwardsArrayF.getJSONObject(far).getInt("gameId"));
							nRosterforward
									.setLast5games02GameTypeId(forwardsArrayF.getJSONObject(far).getInt("gameTypeId"));
							nRosterforward.setLast5games02Goals(forwardsArrayF.getJSONObject(far).getInt("goals"));
							nRosterforward.setLast5games02HomeRoadFlag(
									forwardsArrayF.getJSONObject(far).getString("homeRoadFlag"));
							nRosterforward.setLast5games02OpponentAbbrv(
									forwardsArrayF.getJSONObject(far).getString("opponentAbbrev"));
							nRosterforward.setLast5games02Pim(forwardsArrayF.getJSONObject(far).getInt("pim"));
							nRosterforward
									.setLast5games02PlusMinus(forwardsArrayF.getJSONObject(far).getInt("plusMinus"));
							nRosterforward.setLast5games02Points(forwardsArrayF.getJSONObject(far).getInt("points"));
							nRosterforward.setLast5games02PowerplayGoals(
									forwardsArrayF.getJSONObject(far).getInt("powerPlayGoals"));
							nRosterforward.setLast5games02Shifts(forwardsArrayF.getJSONObject(far).getInt("shifts"));
							nRosterforward.setLast5games02ShorthandedGoals(
									forwardsArrayF.getJSONObject(far).getInt("shorthandedGoals"));
							nRosterforward.setLast5games02Shots(forwardsArrayF.getJSONObject(far).getInt("shots"));
							nRosterforward.setLast5games02Toi(forwardsArrayF.getJSONObject(far).getString("toi"));

						case 2:
							nRosterforward.setLast5games03Assists(forwardsArrayF.getJSONObject(far).getInt("assists"));
							nRosterforward.setLast5games03Date(forwardsArrayF.getJSONObject(far).getString("gameDate"));
							nRosterforward.setLast5games03GameId(forwardsArrayF.getJSONObject(far).getInt("gameId"));
							nRosterforward
									.setLast5games03GameTypeId(forwardsArrayF.getJSONObject(far).getInt("gameTypeId"));
							nRosterforward.setLast5games03Goals(forwardsArrayF.getJSONObject(far).getInt("goals"));
							nRosterforward.setLast5games03HomeRoadFlag(
									forwardsArrayF.getJSONObject(far).getString("homeRoadFlag"));
							nRosterforward.setLast5games03OpponentAbbrv(
									forwardsArrayF.getJSONObject(far).getString("opponentAbbrev"));
							nRosterforward.setLast5games03Pim(forwardsArrayF.getJSONObject(far).getInt("pim"));
							nRosterforward
									.setLast5games03PlusMinus(forwardsArrayF.getJSONObject(far).getInt("plusMinus"));
							nRosterforward.setLast5games03Points(forwardsArrayF.getJSONObject(far).getInt("points"));
							nRosterforward.setLast5games03PowerplayGoals(
									forwardsArrayF.getJSONObject(far).getInt("powerPlayGoals"));
							nRosterforward.setLast5games03Shifts(forwardsArrayF.getJSONObject(far).getInt("shifts"));
							nRosterforward.setLast5games03ShorthandedGoals(
									forwardsArrayF.getJSONObject(far).getInt("shorthandedGoals"));
							nRosterforward.setLast5games03Shots(forwardsArrayF.getJSONObject(far).getInt("shots"));
							nRosterforward.setLast5games03Toi(forwardsArrayF.getJSONObject(far).getString("toi"));

						case 3:
							nRosterforward.setLast5games04Assists(forwardsArrayF.getJSONObject(far).getInt("assists"));
							nRosterforward.setLast5games04Date(forwardsArrayF.getJSONObject(far).getString("gameDate"));
							nRosterforward.setLast5games04GameId(forwardsArrayF.getJSONObject(far).getInt("gameId"));
							nRosterforward
									.setLast5games04GameTypeId(forwardsArrayF.getJSONObject(far).getInt("gameTypeId"));
							nRosterforward.setLast5games04Goals(forwardsArrayF.getJSONObject(far).getInt("goals"));
							nRosterforward.setLast5games04HomeRoadFlag(
									forwardsArrayF.getJSONObject(far).getString("homeRoadFlag"));
							nRosterforward.setLast5games04OpponentAbbrv(
									forwardsArrayF.getJSONObject(far).getString("opponentAbbrev"));
							nRosterforward.setLast5games04Pim(forwardsArrayF.getJSONObject(far).getInt("pim"));
							nRosterforward
									.setLast5games04PlusMinus(forwardsArrayF.getJSONObject(far).getInt("plusMinus"));
							nRosterforward.setLast5games04Points(forwardsArrayF.getJSONObject(far).getInt("points"));
							nRosterforward.setLast5games04PowerplayGoals(
									forwardsArrayF.getJSONObject(far).getInt("powerPlayGoals"));
							nRosterforward.setLast5games04Shifts(forwardsArrayF.getJSONObject(far).getInt("shifts"));
							nRosterforward.setLast5games04ShorthandedGoals(
									forwardsArrayF.getJSONObject(far).getInt("shorthandedGoals"));
							nRosterforward.setLast5games04Shots(forwardsArrayF.getJSONObject(far).getInt("shots"));
							nRosterforward.setLast5games04Toi(forwardsArrayF.getJSONObject(far).getString("toi"));

						case 4:
							nRosterforward.setLast5games05Assists(forwardsArrayF.getJSONObject(far).getInt("assists"));
							nRosterforward.setLast5games05Date(forwardsArrayF.getJSONObject(far).getString("gameDate"));
							nRosterforward.setLast5games05GameId(forwardsArrayF.getJSONObject(far).getInt("gameId"));
							nRosterforward
									.setLast5games05GameTypeId(forwardsArrayF.getJSONObject(far).getInt("gameTypeId"));
							nRosterforward.setLast5games05Goals(forwardsArrayF.getJSONObject(far).getInt("goals"));
							nRosterforward.setLast5games05HomeRoadFlag(
									forwardsArrayF.getJSONObject(far).getString("homeRoadFlag"));
							nRosterforward.setLast5games05OpponentAbbrv(
									forwardsArrayF.getJSONObject(far).getString("opponentAbbrev"));
							nRosterforward.setLast5games05Pim(forwardsArrayF.getJSONObject(far).getInt("pim"));
							nRosterforward
									.setLast5games05PlusMinus(forwardsArrayF.getJSONObject(far).getInt("plusMinus"));
							nRosterforward.setLast5games05Points(forwardsArrayF.getJSONObject(far).getInt("points"));
							nRosterforward.setLast5games05PowerplayGoals(
									forwardsArrayF.getJSONObject(far).getInt("powerPlayGoals"));
							nRosterforward.setLast5games05Shifts(forwardsArrayF.getJSONObject(far).getInt("shifts"));
							nRosterforward.setLast5games05ShorthandedGoals(
									forwardsArrayF.getJSONObject(far).getInt("shorthandedGoals"));
							nRosterforward.setLast5games05Shots(forwardsArrayF.getJSONObject(far).getInt("shots"));
							nRosterforward.setLast5games05Toi(forwardsArrayF.getJSONObject(far).getString("toi"));

					}
				}
				// logger.debug("RosterForward " + nRosterforward);
				rosterforwardRepository.save(nRosterforward);
				//logger.debug("RosterForward SAVED ============================================\n");
			}
			connForward.disconnect();

		} catch (IOException e) {
			e.printStackTrace();

		}

		//
		return "Roster Forward Complete\n";
	}

	@RequestMapping(value = "/api/update/game/updateDate={inputDate}", method = { RequestMethod.POST,
			RequestMethod.GET })
	@Transactional
	public String updateGame(@PathVariable("inputDate") String inputDate) {

		//logger.debug("updateGame has been reached");

		String selectDate = inputDate + "%";
		//logger.debug("selectDate = " + selectDate);

		List<Game> rs = null;
		rs = gameRepository.findByGameDate(selectDate);
		// logger.debug("rs ..." + rs);

		// URL url3 = new
		for (ListIterator<Game> iter = rs.listIterator(); iter.hasNext();) {
			Game gameFromDb = iter.next();
			String selectPk = gameFromDb.getGameId().toString();
			//logger.debug("gamePk...." + selectPk);
			updateGameLine(selectPk, gameFromDb);

		}
		return "Saved";
	}

	public String updateGameLine(String selectPk, Game gameFromDb) {

		try {

			URL url3 = new URL("https://api-web.nhle.com/v1/gamecenter/" + selectPk + "/boxscore");
			HttpURLConnection conn3 = (HttpURLConnection) url3.openConnection();
			conn3.setRequestMethod("GET");
			conn3.setRequestProperty("Accept", "application/json");

			if (conn3.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + conn3.getResponseCode());
			}

			BufferedReader br3 = new BufferedReader(new InputStreamReader((conn3.getInputStream())));

			String myString3;
			int count = 0;
			String dataLine3 = "";

			while ((myString3 = br3.readLine()) != null) {
				count = count + 1;
				dataLine3 = dataLine3 + myString3;
			}

			//
			JSONObject myJsonString3 = new JSONObject(dataLine3);

			// changed this to use optString, because in some cases this element doesn't
			// exist and throws an error with getString.
			String gameState = myJsonString3.optString("gameState");
			//logger.debug("gameState " + gameState);

			if (gameState.equals("OFF")) {

				// logger.debug("myJsonString3 " + myJsonString3);
				gameFromDb.setVisitingScore(myJsonString3.getJSONObject("awayTeam").getInt("score"));
				gameFromDb.setVisitingSog(myJsonString3.getJSONObject("awayTeam").getInt("sog"));
				gameFromDb.setHomeScore(myJsonString3.getJSONObject("homeTeam").getInt("score"));
				gameFromDb.setHomeSog(myJsonString3.getJSONObject("homeTeam").getInt("sog"));
				gameFromDb.setLastPeriodType(myJsonString3.getJSONObject("gameOutcome").getString("lastPeriodType"));
				//logger.debug(
				//		"lastPeriodType " + myJsonString3.getJSONObject("gameOutcome").getString("lastPeriodType"));

				//logger.debug("gameFromDb .... " + gameFromDb.getGameDate() + " " + gameFromDb.getGameId());
				gameRepository.save(gameFromDb);

				conn3.disconnect();
			}

		} catch (IOException e) {

			e.printStackTrace();

		}

		//
		return "Game Updated ";

	}

	@Autowired
	StandingRepository standingRepository;

	@RequestMapping(value = "/api/load/standings", method = { RequestMethod.POST, RequestMethod.GET })
	@Transactional
	public String loadDBStandings() {

		//logger.debug("loadDBStandings has been reached");

		try {
			URL url = new URL("https://api-web.nhle.com/v1/standings/now");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("User-Agent",
					"Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");
			conn.setRequestProperty("Accept", "application/json");

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

			String myString;
			int count = 0;
			String dataLine = "";

			// truncate doesn't work with foreign table references
			// conferenceRepository.truncateConference();
			// divisionRepository.truncateDivision();
			// teamRepository.truncateTeam();

			standingRepository.deleteAll();

			//logger.debug("Output from Server .... \n");
			while ((myString = br.readLine()) != null) {
				count = count + 1;
				dataLine = dataLine + myString;

				// logger.debug(count + " " + myString);
			}

			JSONObject myJsonString = new JSONObject(dataLine);

			JSONArray standingArray = myJsonString.getJSONArray("standings");
			for (int i = 0; i < standingArray.length(); i++) {
				Standing nStanding = new Standing();
				nStanding.setConferenceAbbrev(standingArray.getJSONObject(i).getString("conferenceAbbrev"));
				nStanding.setConferenceHomeSequence(standingArray.getJSONObject(i).getInt("conferenceHomeSequence"));
				nStanding.setConferenceL10Sequence(standingArray.getJSONObject(i).getInt("conferenceL10Sequence"));
				nStanding.setConferenceName(standingArray.getJSONObject(i).getString("conferenceName"));
				nStanding.setConferenceRoadSequence(standingArray.getJSONObject(i).getInt("conferenceRoadSequence"));
				nStanding.setConferenceSequence(standingArray.getJSONObject(i).getInt("conferenceSequence"));
				nStanding.setDate(standingArray.getJSONObject(i).getString("date"));
				nStanding.setDivisionAbbrev(standingArray.getJSONObject(i).getString("divisionAbbrev"));
				nStanding.setDivisionHomeSequence(standingArray.getJSONObject(i).getInt("divisionHomeSequence"));
				nStanding.setDivisionL10Sequence(standingArray.getJSONObject(i).getInt("divisionL10Sequence"));
				nStanding.setDivisionName(standingArray.getJSONObject(i).getString("divisionName"));
				nStanding.setDivisionRoadSequence(standingArray.getJSONObject(i).getInt("divisionRoadSequence"));
				nStanding.setDivisionSequence(standingArray.getJSONObject(i).getInt("divisionSequence"));
				nStanding.setGameTypeId(standingArray.getJSONObject(i).getInt("gameTypeId"));
				nStanding.setGamesPlayed(standingArray.getJSONObject(i).getInt("gamesPlayed"));
				nStanding.setGoalDifferential(standingArray.getJSONObject(i).getInt("goalDifferential"));
				nStanding.setGoalDifferentialPctg(standingArray.getJSONObject(i).getFloat("goalDifferentialPctg"));
				nStanding.setGoalAgainst(standingArray.getJSONObject(i).getInt("goalAgainst"));
				nStanding.setGoalFor(standingArray.getJSONObject(i).getInt("goalFor"));
				nStanding.setGoalsForPctg(standingArray.getJSONObject(i).getFloat("goalsForPctg"));
				nStanding.setHomeGamesPlayed(standingArray.getJSONObject(i).getInt("homeGamesPlayed"));
				nStanding.setHomeGoalDifferential(standingArray.getJSONObject(i).getInt("homeGoalDifferential"));
				nStanding.setHomeGoalsAgainst(standingArray.getJSONObject(i).getInt("homeGoalsAgainst"));
				nStanding.setHomeGoalsFor(standingArray.getJSONObject(i).getInt("homeGoalsFor"));
				nStanding.setHomeLosses(standingArray.getJSONObject(i).getInt("homeLosses"));
				nStanding.setHomeOtLosses(standingArray.getJSONObject(i).getInt("homeOtLosses"));
				nStanding.setHomePoints(standingArray.getJSONObject(i).getInt("homePoints"));
				nStanding
						.setHomeRegulationPlusOtWins(standingArray.getJSONObject(i).getInt("homeRegulationPlusOtWins"));
				nStanding.setHomeRegulationWins(standingArray.getJSONObject(i).getInt("homeRegulationWins"));

				nStanding.setHomeTies(standingArray.getJSONObject(i).getInt("homeTies"));
				nStanding.setHomeWins(standingArray.getJSONObject(i).getInt("homeWins"));
				nStanding.setL10GamesPlayed(standingArray.getJSONObject(i).getInt("l10GamesPlayed"));
				nStanding.setL10GoalDifferential(standingArray.getJSONObject(i).getInt("l10GoalDifferential"));
				nStanding.setL10GoalsAgainst(standingArray.getJSONObject(i).getInt("l10GoalsAgainst"));
				nStanding.setL10GoalsFor(standingArray.getJSONObject(i).getInt("l10GoalsFor"));
				nStanding.setL10Losses(standingArray.getJSONObject(i).getInt("l10Losses"));
				nStanding.setL10OtLosses(standingArray.getJSONObject(i).getInt("l10OtLosses"));
				nStanding.setL10Points(standingArray.getJSONObject(i).getInt("l10Points"));
				nStanding.setL10RegulationPlusOtWins(standingArray.getJSONObject(i).getInt("l10RegulationPlusOtWins"));
				nStanding.setL10RegulationWins(standingArray.getJSONObject(i).getInt("l10RegulationWins"));
				nStanding.setL10Ties(standingArray.getJSONObject(i).getInt("l10Ties"));
				nStanding.setL10Wins(standingArray.getJSONObject(i).getInt("l10Wins"));
				nStanding.setLeagueHomeSequence(standingArray.getJSONObject(i).getInt("leagueHomeSequence"));
				nStanding.setLeagueL10Sequence(standingArray.getJSONObject(i).getInt("leagueL10Sequence"));
				nStanding.setLeagueRoadSequence(standingArray.getJSONObject(i).getInt("leagueRoadSequence"));
				nStanding.setLeagueSequence(standingArray.getJSONObject(i).getInt("leagueSequence"));
				nStanding.setLosses(standingArray.getJSONObject(i).getInt("losses"));
				nStanding.setOtLosses(standingArray.getJSONObject(i).getInt("otLosses"));
				nStanding.setPlaceName(standingArray.getJSONObject(i).getJSONObject("placeName").getString("default"));
				nStanding.setPointPctg(standingArray.getJSONObject(i).getFloat("pointPctg"));
				nStanding.setPoints(standingArray.getJSONObject(i).getInt("points"));
				nStanding
						.setRegulationPlusOtWinPctg(standingArray.getJSONObject(i).getFloat("regulationPlusOtWinPctg"));
				nStanding.setRegulationPlusOtWins(standingArray.getJSONObject(i).getInt("regulationPlusOtWins"));
				nStanding.setRegulationWinPctg(standingArray.getJSONObject(i).getFloat("regulationWinPctg"));
				nStanding.setRegulationWins(standingArray.getJSONObject(i).getInt("regulationWins"));
				nStanding.setRoadGamesPlayed(standingArray.getJSONObject(i).getInt("roadGamesPlayed"));
				nStanding.setRoadGoalDifferential(standingArray.getJSONObject(i).getInt("roadGoalDifferential"));
				nStanding.setRoadGoalsAgainst(standingArray.getJSONObject(i).getInt("roadGoalsAgainst"));
				nStanding.setRoadGoalsFor(standingArray.getJSONObject(i).getInt("roadGoalsFor"));
				nStanding.setRoadLosses(standingArray.getJSONObject(i).getInt("roadLosses"));
				nStanding.setRoadOtLosses(standingArray.getJSONObject(i).getInt("roadOtLosses"));
				nStanding.setRoadPoints(standingArray.getJSONObject(i).getInt("roadPoints"));
				nStanding
						.setRoadRegulationPlusOtWins(standingArray.getJSONObject(i).getInt("roadRegulationPlusOtWins"));
				nStanding.setRoadRegulationWins(standingArray.getJSONObject(i).getInt("roadRegulationWins"));
				nStanding.setRoadTies(standingArray.getJSONObject(i).getInt("roadTies"));
				nStanding.setRoadWins(standingArray.getJSONObject(i).getInt("roadWins"));
				nStanding.setSeasonId(standingArray.getJSONObject(i).getInt("seasonId"));
				nStanding.setShootoutLosses(standingArray.getJSONObject(i).getInt("shootoutLosses"));
				nStanding.setShootoutWins(standingArray.getJSONObject(i).getInt("shootoutWins"));
				nStanding.setStreakCode(standingArray.getJSONObject(i).getString("streakCode"));
				nStanding.setStreakCount(standingArray.getJSONObject(i).getInt("streakCount"));
				nStanding.setTeamName(standingArray.getJSONObject(i).getJSONObject("teamName").getString("default"));
				nStanding.setTeamCommonName(
						standingArray.getJSONObject(i).getJSONObject("teamCommonName").getString("default"));
				nStanding
						.setTeamAbbrev(standingArray.getJSONObject(i).getJSONObject("teamAbbrev").getString("default"));
				nStanding.setTies(standingArray.getJSONObject(i).getInt("ties"));
				nStanding.setWaiversSequence(standingArray.getJSONObject(i).getInt("waiversSequence"));
				nStanding.setWildcardSequence(standingArray.getJSONObject(i).getInt("wildcardSequence"));
				nStanding.setWinPctg(standingArray.getJSONObject(i).getFloat("winPctg"));
				nStanding.setWins(standingArray.getJSONObject(i).getInt("wins"));

				//logger.debug("Standing " + nStanding);
				standingRepository.save(nStanding);

			}

			conn.disconnect();

		} catch (IOException e) {

			e.printStackTrace();

		}
		//
		return "Standing Saved\n";
	}

}

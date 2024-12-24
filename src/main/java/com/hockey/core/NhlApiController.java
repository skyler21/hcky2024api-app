package com.hockey.core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
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
import com.hockey.core.dao.RosterRepository;
import com.hockey.core.model.Game;
import com.hockey.core.model.Roster;
import com.hockey.core.ReferenceData;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class NhlApiController {
	Logger logger = Logger.getLogger(NhlApiController.class);
	
	@Autowired
	TeamRepository teamRepository;

	@RequestMapping(value = "/api/load/teams", method = { RequestMethod.POST, RequestMethod.GET })
	@Transactional
	public String loadDBTeams() {

		logger.debug("loadDBTeams has been reached");

		try {

			URL url = new URL("https://api.nhle.com/stats/rest/en/team");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");
			conn.setRequestProperty("Accept", "application/json");

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

			String myString;
			int count = 0;
			String dataLine = "";

			// truncate doesn't work with foreign table references 
			//conferenceRepository.truncateConference();
			//divisionRepository.truncateDivision();
			//teamRepository.truncateTeam();

			teamRepository.deleteAll();
			
			logger.debug("Output from Server .... \n");
			while ((myString = br.readLine()) != null) {
				count = count + 1;
				dataLine = dataLine + myString;

				//logger.debug(count + " " + myString);
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
				}
				else{ 
				   nTeam.setFranchiseId(teamsArray.getJSONObject(i).getInt("franchiseId"));
			    }   
				
				nTeam.setLeagueId(teamsArray.getJSONObject(i).getInt("leagueId"));
				nTeam.setRawTricode(teamsArray.getJSONObject(i).getString("rawTricode"));
				nTeam.setTriCode(teamsArray.getJSONObject(i).getString("triCode"));
				logger.debug("TEAM " + nTeam);
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

		logger.debug("loadDBFranchises has been reached");

		try {

			URL url = new URL("https://api.nhle.com/stats/rest/en/franchise");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");
			conn.setRequestProperty("Accept", "application/json");

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

			String myString;
			int count = 0;
			String dataLine = "";

			// truncate doesn't work with foreign table references 
			//conferenceRepository.truncateConference();
			//divisionRepository.truncateDivision();
			//teamRepository.truncateTeam();

			franchiseRepository.deleteAll();

			logger.debug("Output from Server .... \n");
			while ((myString = br.readLine()) != null) {
				count = count + 1;
				dataLine = dataLine + myString;

				//logger.debug(count + " " + myString);
			}

			JSONObject myJsonString = new JSONObject(dataLine);
		
			JSONArray franchisesArray = myJsonString.getJSONArray("data");
			for (int i = 0; i < franchisesArray.length(); i++) {
				Franchise nFranchise = new Franchise();
				nFranchise.setFranchiseId(franchisesArray.getJSONObject(i).getInt("id"));
			    nFranchise.setFullName(franchisesArray.getJSONObject(i).getString("fullName"));
			    nFranchise.setTeamCommonName(franchisesArray.getJSONObject(i).getString("teamCommonName"));
			    nFranchise.setTeamPlaceName(franchisesArray.getJSONObject(i).getString("teamPlaceName"));
			    logger.debug("FRANCHISE " + nFranchise);
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

		logger.debug("loadDBGames has been reached");

		try {
			ReferenceData refData = new ReferenceData();


			URL url = new URL("https://api.nhle.com/stats/rest/en/game");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");
			conn.setRequestProperty("Accept", "application/json");
			
			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

			String myString;
			int count = 0;
			String dataLine = "";

			// truncate doesn't work with foreign table references 
			//conferenceRepository.truncateConference();
			//divisionRepository.truncateDivision();
			//teamRepository.truncateTeam();

			gameRepository.deleteAll();

			logger.debug("Output from Server .... \n");
			while ((myString = br.readLine()) != null) {
				count = count + 1;
				dataLine = dataLine + myString;

				//logger.debug(count + " " + myString);
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
					nGame.setHomeTeamFullName(teamRepository.findNameByTeamId(gameArray.getJSONObject(i).getInt("homeTeamId")));
					
					if ((gameArray.getJSONObject(i).getInt("gameStateId")) == 1) {
						nGame.setPeriod(0);
					} 
					else {	
						nGame.setPeriod(gameArray.getJSONObject(i).getInt("period"));
					}
					
					nGame.setSeason(gameArray.getJSONObject(i).getInt("season"));
					nGame.setVisitingScore(gameArray.getJSONObject(i).getInt("visitingScore"));
					nGame.setVisitingTeamId(gameArray.getJSONObject(i).getInt("visitingTeamId"));
					nGame.setVisitingTeamFullName(teamRepository.findNameByTeamId(gameArray.getJSONObject(i).getInt("visitingTeamId")));
					logger.debug("GAME " + nGame);
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
	
	@RequestMapping(value = "/api/load/roster/team={teamAbbrv}", method = { RequestMethod.POST, RequestMethod.GET })
	@Transactional
	public String loadDBTeamRoster(@PathVariable("teamAbbrv") String teamAbbrv) {

		logger.debug("loadDBTeamRoster has been reached");
        //int season = 20242025;

		try {

			URL url = new URL("https://api-web.nhle.com/v1/roster/" + teamAbbrv + "/current");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");
			conn.setRequestProperty("Accept", "application/json");
			logger.debug("url is " + url);

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}
			
			//get all headers
			Map<String, List<String>> map = conn.getHeaderFields();
			for (Map.Entry<String, List<String>> entry : map.entrySet()) {
				logger.debug("Key : " + entry.getKey() + 
					 " ,Value : " + entry.getValue());
			}

			//get header by 'key'
			String server = conn.getHeaderField("Server");

			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

			String myString;
			int count = 0;
			String dataLine = "";

			// truncate doesn't work with foreign table references 
			//conferenceRepository.truncateConference();
			//divisionRepository.truncateDivision();
			//teamRepository.truncateTeam();

			rosterRepository.deleteAll();

			logger.debug("Output from Server .... \n");
			while ((myString = br.readLine()) != null) {
				count = count + 1;
				dataLine = dataLine + myString;

				//logger.debug(count + " " + myString);
			}

			JSONObject myJsonString = new JSONObject(dataLine);
		
			Roster nRoster = new Roster();
	
			JSONArray forwardsArray = myJsonString.getJSONArray("forwards");
			for (int fi = 0; fi < forwardsArray.length(); fi++) {
				nRoster.setRosterId(forwardsArray.getJSONObject(fi).getInt("id"));
				nRoster.setFirstName(forwardsArray.getJSONObject(fi).getJSONObject("firstName").getString("default"));
				nRoster.setLastName(forwardsArray.getJSONObject(fi).getJSONObject("lastName").getString("default"));
				nRoster.setSweaterNumber(forwardsArray.getJSONObject(fi).optInt("sweaterNumber"));
				nRoster.setPositionCode(forwardsArray.getJSONObject(fi).getString("positionCode"));
				nRoster.setShootsCatches(forwardsArray.getJSONObject(fi).getString("shootsCatches"));
				nRoster.setHeightInches(forwardsArray.getJSONObject(fi).getInt("heightInInches"));
				nRoster.setWeightPounds(forwardsArray.getJSONObject(fi).getInt("weightInPounds"));
				nRoster.setBirthDate(forwardsArray.getJSONObject(fi).getString("birthDate"));
				nRoster.setBirthCity(forwardsArray.getJSONObject(fi).getJSONObject("birthCity").getString("default"));
				nRoster.setBirthCountry(forwardsArray.getJSONObject(fi).getString("birthCountry"));
				String testCountryF = forwardsArray.getJSONObject(fi).getString("birthCountry");
			    if (testCountryF.equals("CAN") || testCountryF.equals("USA")) {
				    nRoster.setBirthStateProvince(forwardsArray.getJSONObject(fi).getJSONObject("birthStateProvince").getString("default"));
				}
				else{ 
				    nRoster.setBirthStateProvince(" ");
				}  

				logger.debug("Roster " + nRoster);
				rosterRepository.save(nRoster);
			
		 	}
		
			 JSONArray defenseArray = myJsonString.getJSONArray("defensemen");
			 for (int di = 0; di < defenseArray.length(); di++) {
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
			    if (testCountryD.equals("CAN") || testCountryD.equals("USA")) {
				    nRoster.setBirthStateProvince(defenseArray.getJSONObject(di).getJSONObject("birthStateProvince").getString("default"));
				}
				else{ 
					nRoster.setBirthStateProvince(" ");
				}  
				logger.debug("Roster " + nRoster);
				rosterRepository.save(nRoster);
			  }
		 
			  JSONArray goaliesArray = myJsonString.getJSONArray("goalies");
			  for (int gi = 0; gi < goaliesArray.length(); gi++) {
				nRoster.setRosterId(goaliesArray.getJSONObject(gi).getInt("id"));
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
			    if (testCountryG.equals("CAN") || testCountryG.equals("USA")) {
				    nRoster.setBirthStateProvince(goaliesArray.getJSONObject(gi).getJSONObject("birthStateProvince").getString("default"));
				}
				else{ 
				    nRoster.setBirthStateProvince(" ");
				}  

				logger.debug("Roster " + nRoster);
				rosterRepository.save(nRoster);
			   }
		
			   conn.disconnect();

		} catch (IOException e) {

			e.printStackTrace();

		}
		//
		return "Team Roster Saved\n";
	}
}

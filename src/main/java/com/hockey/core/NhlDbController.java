package com.hockey.core;

import java.lang.ref.Reference;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hockey.core.dao.TeamRepository;
import com.hockey.core.dao.GameRepository;
import com.hockey.core.dao.FranchiseRepository;

import com.hockey.core.model.Team;
import com.hockey.core.model.Game;
import com.hockey.core.model.Franchise;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class NhlDbController {
	Logger logger = Logger.getLogger(NhlDbController.class);

	@Autowired
	TeamRepository teamRepository;
	@Autowired
	GameRepository gameRepository;
	@Autowired
	FranchiseRepository franchiseRepository;

	@RequestMapping(value = "/db/get/teams", method = { RequestMethod.POST, RequestMethod.GET })
	@Transactional
	public List<Team> getAllTeams() {
		// This returns a JSON or XML with the users
		logger.debug("getAllTeams has been reached");
		return (List<Team>) teamRepository.findAll();
	}

	@RequestMapping(value = "/db/get/games", method = { RequestMethod.POST, RequestMethod.GET })
	@Transactional
	public List<Game> getAllGames() {
		// This returns a JSON or XML with the users
		logger.debug("getAllGames has been reached");
		return (List<Game>) gameRepository.findAll();
	}

	@RequestMapping(value = "/db/get/gamesByDate/gameDate={inputDate}", method = { RequestMethod.POST, RequestMethod.GET })
	@Transactional
	public List<Game> getByGameDate(@PathVariable("inputDate") String inputDate) {
		// This returns a JSON or XML with the users
		logger.debug("getgamesByDate has been reached");
		String selectDate = inputDate.trim() + "%";
		return (List<Game>) gameRepository.findByGameDate(selectDate);
	}

	@RequestMapping(value = "/db/get/franchises", method = { RequestMethod.POST, RequestMethod.GET })
	@Transactional
	public List<Franchise> getAllFranchises() {
		// This returns a JSON or XML with the users
		logger.debug("getAllFranchises has been reached");
		return (List<Franchise>) franchiseRepository.findAll();
	}

	//@RequestMapping(value = "/reference/get/allGameTypes", method = { RequestMethod.POST, RequestMethod.GET })
	//@Transactional
	//public List<String> getAllGameTypes() {
   	// This returns a JSON or XML with the users
    //		logger.debug("getAllGameTypes has been reached");
	//	return (List<String>) ReferenceData.getAllGameTypes();
	//}

	//   curl command is like this - has to be in double quotes on the cmd line 
	// curl "http://localhost:8085/db/get/findGames?gameSeason=20242025&gameType=Regular&gameTeam=NONE&gameDate=NONE"
    // curl "http://localhost:8085/db/get/findGames?gameSeason=20242025&gameType=Regular&gameTeam=Columbus%20Blue%20Jackets&gameDate=NONE"
    // curl "http://localhost:8085/db/get/findGames?gameSeason=20242025&gameType=Regular&gameTeam=NONE&gameDate=2024-12-18"
	
    @RequestMapping(value = "/db/get/findGames", method = { RequestMethod.GET })
	@Transactional
	public List<Game> getFindGames(@RequestParam("gameSeason") String pkseason,
	                               @RequestParam("gameType") String pktype,
								   @RequestParam("gameTeam") String pkteam,
								   @RequestParam("gameDate") String pkdate) {

		// This returns a JSON or XML with the users
		logger.debug("getFindGames has been reached");
		logger.debug("gameSeason = " + pkseason);
		logger.debug("gameType = " + pktype);
		logger.debug("gameTeam = " + pkteam);
		logger.debug("gameDate = " + pkdate);
        if ((pkdate.equals("NONE")) || (pkdate.equals(""))) {
			logger.debug("pkdate is equal NONE");
			pkdate = "%"; 
		}
		if (pkteam.equals("NONE")) {
			logger.debug("pkteam is equal NONE");
			pkteam = "%"; 
	   } 

		return (List<Game>) gameRepository.findGameByAny(pkseason, pkdate, pktype, pkteam);
	}
  
	@RequestMapping(value = "/db/get/allGameSeasons", method = { RequestMethod.POST, RequestMethod.GET })
	@Transactional
	public List<String> getAllGameSeasons() {
		// This returns a JSON or XML with the users
		logger.debug("getAllGameSeasons has been reached");
		return (List<String>) gameRepository.findGameSeasons();
	}

	@RequestMapping(value = "/db/get/allGameTeams", method = { RequestMethod.POST, RequestMethod.GET })
	@Transactional
	public List<String> getAllGameTeams() {
		// This returns a JSON or XML with the users
		logger.debug("getAllGameTeams has been reached");
		return (List<String>) gameRepository.findGameTeams();
	}

	@RequestMapping(value = "/db/get/allGameTypes", method = { RequestMethod.POST, RequestMethod.GET })
	@Transactional
	public List<String> getAllGameTypes() {
		// This returns a JSON or XML with the users
		logger.debug("getAllGameTypes has been reached");
		return (List<String>) gameRepository.findGameTypes();
	}

}
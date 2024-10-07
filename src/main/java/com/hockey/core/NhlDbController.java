package com.hockey.core;

import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

	@RequestMapping(value = "/db/get/franchises", method = { RequestMethod.POST, RequestMethod.GET })
	@Transactional
	public List<Franchise> getAllFranchises() {
		// This returns a JSON or XML with the users
		logger.debug("getAllFranchises has been reached");
		return (List<Franchise>) franchiseRepository.findAll();
	}

}
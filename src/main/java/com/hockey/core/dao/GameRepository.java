package com.hockey.core.dao;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hockey.core.model.Game;


// This will be AUTO IMPLEMENTED by Spring into a Bean called gameRepository
// CRUD refers Create, Read, Update, Delete
@Repository
public interface GameRepository extends CrudRepository<Game, Integer> {
	@Modifying
	@Query (
			value = "truncate table game",
			nativeQuery = true
			)
	void truncateGame();

}

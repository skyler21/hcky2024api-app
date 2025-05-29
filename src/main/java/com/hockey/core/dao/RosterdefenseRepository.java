package com.hockey.core.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.jpa.repository.Modifying;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hockey.core.model.Rosterdefense;
import com.hockey.core.model.Rosterforward;


// This will be AUTO IMPLEMENTED by Spring into a Bean called RosterdefenseRepository
// CRUD refers Create, Read, Update, Delete
@Repository
public interface RosterdefenseRepository extends CrudRepository<Rosterdefense, Integer> {
	//@Modifying
	//@Query (
	//		value = "truncate table roster",
	//		nativeQuery = true
	//		)
	//void truncateRoster();


	@Query(
		value = "select * from rosterdefense a order by game_points desc;",
  		nativeQuery = true
	  )
    List<Rosterdefense> getDefenseRoster();
}

package com.hockey.core.dao;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.jpa.repository.Modifying;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hockey.core.model.Rostergoalie;


// This will be AUTO IMPLEMENTED by Spring into a Bean called RostergoalieRepository
// CRUD refers Create, Read, Update, Delete
@Repository
public interface RostergoalieRepository extends CrudRepository<Rostergoalie, Integer> {
	//@Modifying
	//@Query (
	//		value = "truncate table roster",
	//		nativeQuery = true
	//		)
	//void truncateRoster();

	@Query(
		value = "select * from rostergoalie a order by a.goals_against_avg;", 
		nativeQuery = true
	  )
    List<Rostergoalie> getGoalieRoster();


}

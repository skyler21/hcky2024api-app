package com.hockey.core.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.jpa.repository.Modifying;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hockey.core.model.Standing;


// This will be AUTO IMPLEMENTED by Spring into a Bean called standingRepository
// CRUD refers Create, Read, Update, Delete
@Repository
public interface StandingRepository extends CrudRepository<Standing, Integer> {
	//@Modifying
	//@Query (
	//		value = "truncate table standing",
	//		nativeQuery = true
	//		)
	//void truncateStanding();

	 @Query(
		value = "select * from standing order by conference_name, division_name, points desc", 
		nativeQuery = true
	  )
    List<Standing> getSortedStandings();

	@Query(
		value = "select * from standing order by win_pctg desc", 
		nativeQuery = true
	  )
    List<Standing> getSortedWinPercent();


}

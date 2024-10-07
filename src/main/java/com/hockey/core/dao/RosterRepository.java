package com.hockey.core.dao;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hockey.core.model.Roster;


// This will be AUTO IMPLEMENTED by Spring into a Bean called rosterRepository
// CRUD refers Create, Read, Update, Delete
@Repository
public interface RosterRepository extends CrudRepository<Roster, Integer> {
	@Modifying
	@Query (
			value = "truncate table roster",
			nativeQuery = true
			)
	void truncateRoster();

}
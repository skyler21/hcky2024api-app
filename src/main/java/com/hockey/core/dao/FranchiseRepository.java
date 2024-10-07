package com.hockey.core.dao;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hockey.core.model.Franchise;


// This will be AUTO IMPLEMENTED by Spring into a Bean called franchiseRepository
// CRUD refers Create, Read, Update, Delete
@Repository
public interface FranchiseRepository extends CrudRepository<Franchise, Integer> {
	@Modifying
	@Query (
			value = "truncate table franchise",
			nativeQuery = true
			)
	void truncateFranchise();

}

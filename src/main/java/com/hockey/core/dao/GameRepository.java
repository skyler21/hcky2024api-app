package com.hockey.core.dao;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hockey.core.model.Game;
import java.util.List;


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

	@Query(
		value = "select * from game WHERE game_id = ?1", 
		nativeQuery = true
	  )
    Game findByGame(int pkid);

    @Query(
		value = "select g.* from game g WHERE g.game_date like ?1", 
		nativeQuery = true
	  )
    List<Game> findByGameDate(String pkdate);

    @Query(
		value = "select g.* from game g WHERE g.visiting_team_id = ?1 or g.home_team_id =?1", 
		nativeQuery = true
	  )
    List<Game> findByGameTeam(String pkteam);

    @Query(
		value = "select g.* from game g WHERE g.season like ?1 and g.game_date like ?2 and g.game_type_desc like ?3 and (g.home_team_full_name like ?4 or g.visiting_team_full_name like ?4)",
		nativeQuery = true
	  )
    List<Game> findGameByAny(String pkseason, String pkdate, String pktype, String pkteam);

	@Query(
		value = "select distinct g.season from game g order by g.season",
		nativeQuery = true
	  )
    List<String> findGameSeasons();

	@Query(
		value = "select distinct g.home_team_full_name from game g where home_team_full_name is not null order by g.home_team_full_name",
		nativeQuery = true
	  )
    List<String> findGameTeams();

	@Query(
		value = "select distinct g.game_type_desc from game g order by g.game_type_desc",
		nativeQuery = true
	  )
    List<String> findGameTypes();

}

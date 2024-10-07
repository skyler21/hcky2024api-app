 use db_nhl;
 select game_date as '-----game date-----'
       ,t1.abbreviation as 'AWAY'
       ,g.team_awayp1 as 'P1'
	   ,g.team_awayp2 as 'P2'
	   ,g.team_awayp3 as 'P3'
	   ,g.team_awayot as 'OT'
	   ,g.team_away_total as 'Final'
       ,t2.abbreviation as 'HOME'
	   ,g.team_homep1 as 'P1'
	   ,g.team_homep2 as 'P2'
	   ,g.team_homep3 as 'P3'
	   ,g.team_homeot as 'OT'
	   ,g.team_home_total as 'Final'
	   ,g.game_shootout as 'SO'
       ,g.team_home_total + g.team_away_total as 'Total Goals'  
       ,CASE
          when g.team_away_total > g.team_home_total THEN t1.abbreviation ELSE t2.abbreviation 
        END as 'WINNER'
   from game     g
       ,team     t1
       ,team     t2
 where DATE_FORMAT(game_date, '%y-%m-%d') = DATE_SUB(CURDATE(), INTERVAL 1 DAY)
 and t1.team_id = g.team_away_id
 and t2.team_id = g.team_home_id
 order by game_date;

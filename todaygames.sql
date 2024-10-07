 use db_nhl;
 select game_date as '-----game date-----'
       ,t1.abbreviation as 'AWAY TEAM'
       ,s1.team_games as 'TOTAL GAMES'
       ,s1.team_points as 'TOTAL POINTS'
       ,s1.team_away_wins  as 'away wins'
       ,s1.team_away_losses as 'away losses'
       ,s1.team_away_ot_losses as ' away ot ' 
       ,s1.team_goals_for as ' TOTAL G F ' 
       ,s1.team_goals_against as 'TOTAL G A ' 
       ,s1.team_streak as 'Overall Streak'
       ,t2.abbreviation as 'HOME TEAM'
       ,s2.team_games as 'TOTAL GAMES'
       ,s2.team_points as 'TOTAL POINTS' 
       ,s2.team_home_wins as 'home wins' 
       ,s2.team_home_losses as 'home losses' 
       ,s2.team_home_ot_losses as ' home ot ' 
       ,s2.team_goals_for as ' TOTAL G F ' 
       ,s2.team_goals_against as ' TOTAL G A ' 
       ,s2.team_streak as 'Overall Streak'        
   from game     g
       ,team     t1
       ,team     t2
       ,standing s1
       ,standing s2 
 where DATE_FORMAT(game_date, '%y-%m-%d') = CURDATE()       
 and t1.team_id = g.team_away_id
 and t2.team_id = g.team_home_id
 and t1.team_id = s1.team_id
 and t2.team_id = s2.team_id
 order by game_date;

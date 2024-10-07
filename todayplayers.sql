 use db_nhl;
 select g.game_date as '-----game date-----'
       ,rpad(t1.team_name,20, ' ') as 'TEAM                   '
       ,rpad(r1.full_name,20, ' ') as 'NAME           '
       ,r1.position_type as 'POSITION'
       ,p1.g_games as 'GAMES'
       ,p1.g_wins as 'WINS'
       ,p1.g_losses as 'LOSSES'
       ,p1.g_ties as 'TIES'
       ,p1.g_save_percent as 'SAVE PERCENT'
       ,p1.g_goals_against_avg as 'GAA'                
   from game     g
       ,roster   r1
       ,player   p1
       ,team     t1
 where DATE_FORMAT(game_date, '%y-%m-%d') = CURDATE()       
 and (r1.team_id = g.team_away_id
      or r1.team_id = g.team_home_id)
 and r1.position_type in('G')
 and p1.team_id = r1.team_id
 and p1.person_id = r1.person_id
 and p1.team_id = t1.team_id
 and p1.g_games > 0
 order by p1.g_goals_against_avg;
 ----
 select g.game_date as '-----game date-----'
       ,rpad(t1.team_name,20, ' ') as 'TEAM                   '
       ,rpad(r1.full_name,20, ' ') as 'NAME           '
       ,r1.position_type as 'POSITION'
       ,p1.games as 'GAMES'
       ,p1.goals as 'GOALS'
       ,p1.assists as 'LOSSES'
       ,p1.points as 'POINTS'                
   from game     g
       ,roster   r1
       ,player   p1
       ,team     t1
 where DATE_FORMAT(game_date, '%y-%m-%d') = CURDATE()       
 and (r1.team_id = g.team_away_id
      or r1.team_id = g.team_home_id)
 and r1.position_type in('C','LW','RW')     
 and p1.team_id = r1.team_id
 and p1.person_id = r1.person_id
 and p1.team_id = t1.team_id
 and p1.games > 0
 order by p1.points desc;
 ----
 select g.game_date as '-----game date-----'
       ,rpad(t1.team_name,20, ' ') as 'TEAM                   '
       ,rpad(r1.full_name,20, ' ') as 'NAME           '
       ,r1.position_type as 'POSITION'
       ,p1.games as 'GAMES'
       ,p1.goals as 'GOALS'
       ,p1.assists as 'LOSSES'
       ,p1.points as 'POINTS'                
   from game     g
       ,roster   r1
       ,player   p1
       ,team     t1
 where DATE_FORMAT(game_date, '%y-%m-%d') = CURDATE()       
 and (r1.team_id = g.team_away_id
      or r1.team_id = g.team_home_id)
 and r1.position_type in('D')
 and p1.team_id = r1.team_id
 and p1.person_id = r1.person_id
 and p1.team_id = t1.team_id
 and p1.games > 0
 order by p1.points desc;
 ----
 

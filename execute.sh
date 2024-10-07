echo "start Spring Boot java program" 
nohup java -jar ~/Downloads/hockeySql/target/hockeySql.jar > nohup.out & echo $! > ./pid.file &
echo "Sleeping 30 seconds "  
sleep 30
parmdate=$(date  --date="yesterday" +"%Y-%m-%d") # YYYY-mm-dd format
echo "Update yesterday's games - date = " "$parmdate"
curl localhost:8085/api/update/game/updateDate=$parmdate 
parmdate2=$(date  --date="today" +"%Y-%m-%d") # YYYY-mm-dd format
echo "Update today's Roster/Players - date = " "$parmdate2"
curl localhost:8085/api/update/players/updateDate=$parmdate2 
echo "Update standings "
curl localhost:8085/api/load/standing
echo "Mysql yesterday scores"  
mysql --defaults-extra-file=mysqldb.txt db_nhl < yesterdaygames.sql
echo "Mysql todaysgames"  
mysql --defaults-extra-file=mysqldb.txt db_nhl < todaygames.sql
echo "Mysql todaysplayers"  
mysql --defaults-extra-file=mysqldb.txt db_nhl < todayplayers.sql
echo "Stopping JAVA Application "  
kill $(cat ./pid.file)
echo "Start Angular @ angular/hockeysql - port 4200 " 
cd ~/angular14/hockeySql
ng serve --open

echo "Script has ended"

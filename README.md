# edu-intro-jdbc

## Command you need to run.

```
curl -L https://raw.githubusercontent.com/ali-ce/datasets/master/Banned-Videogames/Games.csv -o Ganes.csv

docker ps

docker start iths-mysql
docker cp Games.csv iths-mysql:/var/lib/mysql-files

docker exec -it iths-mysql bash


cd /var/lib/mysql-files
ls
cat Games.csv

*CTRL+D*

docker exec -i iths-mysql mysql -uroot -proot < normalize.sql


 ```

## This app can just be run from Idea because it has Scanner inside and scanner cant work with Gradle. 

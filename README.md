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
[![](https://mermaid.ink/img/pako:eNqFU01vgzAM_StRrit_AO3UInUcJlXi0AsXjxgaNR8oH5Oqjv--AN3IaNBycOL3Ytnxc-600QxpThsB1hYcOgOyViSs2R5BoiWvX1k2H0vV6jRT7GM8Jy9cOVKyFVg5w1U3-RGzEBUajjZJHbRXztySXIEOuEjH7UEdwGGnN2IDXzlwPh195lfeI-NwMrrlIl11KaHbeI-XEjaL_kShezRJ9uQ_BLeXDfaIyqQzvmmJ_W85s53U_ZHpPmOEZLFCwY20sWvwT_MX-Km3w1PCcWL-SxmrHqFx7xZ41baB7qhEI4GzMMdTppq6C4YBo3k4MjDXmtZqvAfe6eqmGpo743FHfc9C9Y-xp3kLwgY0qO20eX98jHEbvgGoDgEn?type=png)](https://mermaid.live/edit#pako:eNqFU01vgzAM_StRrit_AO3UInUcJlXi0AsXjxgaNR8oH5Oqjv--AN3IaNBycOL3Ytnxc-600QxpThsB1hYcOgOyViSs2R5BoiWvX1k2H0vV6jRT7GM8Jy9cOVKyFVg5w1U3-RGzEBUajjZJHbRXztySXIEOuEjH7UEdwGGnN2IDXzlwPh195lfeI-NwMrrlIl11KaHbeI-XEjaL_kShezRJ9uQ_BLeXDfaIyqQzvmmJ_W85s53U_ZHpPmOEZLFCwY20sWvwT_MX-Km3w1PCcWL-SxmrHqFx7xZ41baB7qhEI4GzMMdTppq6C4YBo3k4MjDXmtZqvAfe6eqmGpo743FHfc9C9Y-xp3kLwgY0qO20eX98jHEbvgGoDgEn)

## This app can just be run from Idea because it has Scanner inside and scanner cant work with Gradle. 

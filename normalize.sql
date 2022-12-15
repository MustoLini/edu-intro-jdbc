use iths;

DROP TABLE IF EXISTS GAMES;

CREATE TABLE `GAMES` (
    `Id` VARCHAR(200),
    `Game` VARCHAR(200),
    `Series` VARCHAR(410),
    `Country` VARCHAR(200),
    `Details` VARCHAR(2000),
    `BanCategory` VARCHAR(2000),
    `BanStatus` VARCHAR(2000),
    `WikipediaProfile` VARCHAR(2000),
    `Image` VARCHAR(700),
    `Summary` VARCHAR(5000),
    `Developer` VARCHAR(400),
    `Publisher` VARCHAR(300),
    `Genre` VARCHAR(400),
    `Homepage` VARCHAR(500)
)  ENGINE=INNODB;

LOAD DATA INFILE '/var/lib/mysql-files/Games.csv'
INTO TABLE GAMES
CHARACTER SET latin1
FIELDS TERMINATED BY ','
ENCLOSED BY '"'
LINES TERMINATED BY '\n'
IGNORE 1 ROWS;

DROP TABLE IF EXISTS GamesDB;

CREATE TABLE GamesDB (
Id INT NOT NULL, 
Games VARCHAR(400), 
Country VARCHAR(400), 
BanCategory VARCHAR(400), 
PRIMARY KEY(Id)
) ENGINE=INNODB;

INSERT INTO GamesDB(Games,Country,BanCategory) SELECT Game, Country, BanCategory FROM GAMES;
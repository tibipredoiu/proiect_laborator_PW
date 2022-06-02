CREATE DATABASE IF NOT EXISTS bd_java;
USE bd_java;
CREATE TABLE IF NOT EXISTS movies(
MovieId TINYINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
MovieName VARCHAR(255),
ReleaseDate VARCHAR(255),
rating FLOAT
);

CREATE TABLE IF NOT EXISTS users(
Id TINYINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
firstname varchar(255) not null, 
lastName varchar (255),
passwords varchar(255),
email varchar(255)
);
INSERT INTO movies
VALUES 
(1, 'Justice League', 6.1 , '17 noiembrie 2017'),
(2, 'Need for Speed', 6.4, '7 martie 2014'),
(3, 'Fast and Furious', 6.8, '22 iunie 2001'),
(4, 'Batman Begins', 8.2, '15 iunie 2005'),
(5, 'The Flash', 7.6, '7 octombrie 2014'),
(6, 'Iron Man', 7.9, '2 mai 2008'),
(7, 'Terminator', 8.0, '26 octombrie 1984'),
(8, 'Safe Haven', 6.7, '14 februarie 2013');
select * from movies;
select * from users;
CREATE DATABASE IF NOT EXISTS sample;
use sample;

DROP TABLE IF EXISTS sample.users;
create table sample.users(id BIGINT NOT NULL PRIMARY KEY, 
name varchar(100) NOT NULL, 
email varchar(100) NOT NULL, 
phone BIGINT NOT NULL,
address varchar(250));
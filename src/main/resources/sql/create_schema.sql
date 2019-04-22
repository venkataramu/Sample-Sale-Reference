CREATE DATABASE IF NOT EXISTS flashsale;
use flashsale;

DROP TABLE IF EXISTS flashsale.users;
create table sample.users(id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
name varchar(100) NOT NULL, 
email varchar(100) NOT NULL, 
phone BIGINT NOT NULL,
address varchar(250));

DROP TABLE IF EXISTS flashsale.registered_users;
create table sample.registered_users(user_id BIGINT NOT NULL,
registration_time TIMESTAMP);


DROP TABLE IF EXISTS flashsale.sales;
create table sample.sales(id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
sale_name varchar(100) NOT NULL,
sale_start_time TIMESTAMP,
sale_end_time TIMESTAMP);


DROP TABLE IF EXISTS flashsale.products;
CREATE TABLE sample.products(product_id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
name varchar(20) NOT NULL,
quantity INT NOT NULL, 
sale_start_time TIME,
sale_end_time TIME); 

DROP TABLE IF EXISTS flashsale.orders;
CREATE TABLE sample.orders(id BIGINT NOT NULL PRIMARY KEY,
product_id BIGINT NOT NULL,
user_id BIGINT NOT NULL);
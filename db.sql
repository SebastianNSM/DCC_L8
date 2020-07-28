create database if not exists contacts;
use contacts;
create table if not exists contact 
( id int(11) not null auto_increment, 
name varchar(100) not null, 
email varchar(100), 
phone varchar(12), 
constraint sites_pk primary key (id) 
); 

drop table usermain  CASCADE CONSTRAINTS purge;

create table USERMAIN (
prefix VARCHAR2(5),userId INT,userName varchar2(50) not null,fullname varchar2(100) not null, 
constraint "pk_usermain" PRIMARY KEY (prefix,userId)
);

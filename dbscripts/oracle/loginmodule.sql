drop table usermain  CASCADE CONSTRAINTS purge;
drop sequence USERMAIN_USERID;

create sequence USERMAIN_USERID start WITH 1
increment by 1;
create table USERMAIN (
prefix VARCHAR2(5),userId INT,userName varchar2(50) not null,fullname varchar2(100) not null, 
constraint "pk_usermain" PRIMARY KEY (prefix,userId)
);
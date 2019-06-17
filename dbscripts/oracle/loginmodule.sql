drop table usermain  CASCADE CONSTRAINTS purge;
drop table USERTOKEN  CASCADE CONSTRAINTS purge;
drop sequence USERMAIN_USERID;

create sequence USERMAIN_USERID start WITH 1
increment by 1;
create table USERMAIN (
prefix VARCHAR2(5),user_number NUMBER(8,0),user_name varchar2(50) not null,full_name varchar2(100) not null,email VARCHAR2(30) not null, 
constraint "pk_usermain" PRIMARY KEY (prefix,user_number)
);

create table USERTOKEN (
prefix VARCHAR2(5),user_number NUMBER(8,0),token varchar2(16) not null,start_stamp TIMESTAMP WITH LOCAL TIME ZONE not null,end_stamp TIMESTAMP WITH LOCAL TIME ZONE not null, 
constraint "pk_usertoken" PRIMARY KEY (prefix,user_number,token),
constraint "fk_usertoken" FOREIGN KEY (prefix,user_number) references USERMAIN(prefix,user_number)
);
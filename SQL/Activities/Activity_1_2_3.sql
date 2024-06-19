REM   Script: Activity 1,2,3
REM   SQL Activity1

drop table salesman;

create table salesman(salesman_id int PRIMARY KEY,salesman_name varchar2(20) NOT NULL,salesman_city varchar(10),commision int);

INSERT ALL 
	INTO salesman VALUES(5001,'James Hoog','New York',15) 
	INTO salesman VALUES(5002,'Nail Knite','Paris',13) 
	INTO salesman VALUES(5005,'Pit Alex','London',11) 
	INTO salesman VALUES(5006,'McLyon','Paris',14) 
	INTO salesman VALUES(5007,'Paul Adam','Rome',13) 
    INTO salesman VALUES(5003,'Lauson Hen','San Jose',12) 
SELECT 1 FROM DUAL;

select * from salesman;

select salesman_id,salesman_city from salesman;

select * from salesman where salesman_city = 'Paris';

select salesman_id,commision from salesman where salesman_name = 'Paul Adam';


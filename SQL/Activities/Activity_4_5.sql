REM   Script: Activity 4-5
REM   Activity 4 and 5 for SQL

select * from salesman;

create table salesman(salesman_id int PRIMARY KEY,salesman_name varchar2(20) NOT NULL,salesman_city varchar(10),commision int);

INSERT ALL  
	INTO salesman VALUES(5001,'James Hoog','New York',15)  
	INTO salesman VALUES(5002,'Nail Knite','Paris',13)  
	INTO salesman VALUES(5005,'Pit Alex','London',11)  
	INTO salesman VALUES(5006,'McLyon','Paris',14)  
	INTO salesman VALUES(5007,'Paul Adam','Rome',13)  
    INTO salesman VALUES(5003,'Lauson Hen','San Jose',12)  
SELECT 1 FROM DUAL;

alter table salesman add grade int;

update salesman set grade = 100;

select * from salesman;

update salesman set grade = 200 where salesman_city = 'Rome';

update salesman set salesman_name = 'Pierre' where salesman_name = 'McLyon';

update salesman set salesman_name = 'Pierre' where salesman_name = 'McLyon';

update salesman set salesman_name = 'Pierre' where salesman_name = 'McLyon';

update salesman set salesman_name = 'Pierre' where salesman_name = 'McLyon';

update salesman set salesman_name = 'Pierre' where salesman_name = 'McLyon';

update salesman set salesman_name = 'Pierre' where salesman_name = 'McLyon';

update salesman set grade = 300 where salesman_name = 'James Hoog';

select * from salesman;

select * from salesman;


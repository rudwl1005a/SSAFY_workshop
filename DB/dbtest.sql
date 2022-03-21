use dbtest;

create table test (
	no int,
	name varchar(10),
	price int,
	cnt int
);

select * from test;

load data infile 'C:\\ProgramData\\MySQL\\MySQL Server 8.0\\Uploads\\test.txt'
into table test character set utf8mb4
fields terminated by '\t'
lines terminated by '\r\n'
ignore 1 rows;
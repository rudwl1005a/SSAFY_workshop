-- BINARY -> 대소문자 구별
SELECT * FROM sakila.customer
WHERE last_name = BINARY 'JONES';

SELECT * FROM sakila.city
WHERE country_id IN (86, 103); -- 86번 103번  

SELECT * FROM sakila.city
WHERE country_id <> 86; -- 86번 아닌것
-- AND, OR -> and끼리 or끼리 묶어서 먼저 계산하고 난 이후에 계산

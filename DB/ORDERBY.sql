-- Fetch 대상 확정할때 많이 사용
SELECT * FROM customer
WHERE store_id = 1
ORDER BY address_id DESC;

SELECT country_id, city FROM city
WHERE country_id in (86,103)
ORDER BY country_id DESC, city ASC;

SELECT * FROM city
LIMIT 10; -- 10개만 나타내기

SELECT * FROM city
LIMIT 5 OFFSET 10; -- offset : 시작 index

SELECT * FROM city
LIMIT 10, 20; -- 시작 index(10), 나타낼 개수(20)


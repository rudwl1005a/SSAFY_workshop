use world;

-- 3.
SELECT * FROM country
WHERE Code = 'KOR';

-- 4.
SELECT Code, name, GNP, GNPOld, GNP-GNPOld AS gnp변동량 FROM country
WHERE GNP-GNPOld > 0 AND GNPOld IS NOT NULL
ORDER BY GNP-GNPOld ASC;
-- and
SELECT code, name, gnp, gnpold, gnp-gnpold 'gnp변동량'
FROM country
WHERE gnp-gnpold > 0
ORDER BY gnp-gnpold ASC;

-- 5.
SELECT DISTINCT continent FROM country
ORDER BY length(continent) ASC;

-- 6.
SELECT concat(name, '은 ', region, '에 속하며 인구는', population, '명이다.') AS 정보 FROM country
WHERE continent = 'asia'
ORDER BY name ASC;

-- 7.
SELECT * FROM country
WHERE indepYear IS NULL AND population >= 10000
ORDER BY population ASC;

-- 8.
SELECT * FROM country
WHERE population >= 100000000 AND population <= 200000000
ORDER BY population DESC
LIMIT 3;
-- and
SELECT * FROM country
WHERE population BETWEEN 100000000 AND 200000000
ORDER BY population DESC
LIMIT 3;

-- 9.
SELECT * FROM country
WHERE indepYear = '800' OR indepYear = '1810' OR indepYear = '1811' OR indepYear = '1901'
ORDER BY indepYear ASC, code DESC;
-- and
SELECT * FROM country
WHERE indepYear IN ('800', '1810', '1811', '1901')
ORDER BY indepYear ASC, code DESC;

-- 10.
SELECT * FROM country
WHERE region LIKE '%asia%' AND name LIKE '_o%';

-- 11.
SELECT char_length('홍길동') AS 한글, char_length('hong') AS 영문;

-- 12.
SELECT * FROM country
WHERE GovernmentForm LIKE '%republic%' AND length(name) >= 10
ORDER BY length(name) DESC
LIMIT 10;

-- 13.
SELECT * FROM country
WHERE code LIKE 'A%' OR code LIKE 'E%' OR code LIKE 'I%' OR code LIKE 'O%' OR code LIKE 'U%'
ORDER BY name ASC
LIMIT 2, 3;
-- and
SELECT * FROM country
-- WHERE substr(code, 1, 1) IN ('A', 'E', 'I', 'O', 'U')
WHERE left(code, 1) IN ('A', 'E', 'I', 'O', 'U') -- substr과 둘중 하나
ORDER BY name ASC
LIMIT 2, 3;

-- 14.
SELECT name, concat(left(name, 2), lpad('*', length(name) - 4, '*'), right(name, 2)) AS guess FROM country;
-- SELECT * FROM country WHERE length(name) < 4; -> null : name의 길이가 4보다 작은 경우는 없으므로 위의 쿼리문 사용 가능하다

-- 15.
SELECT DISTINCT replace(region, ' ', '_') AS 지역들 FROM country
ORDER BY length(region) DESC;

-- 16.
SELECT name, surfacearea, population, round(surfaceArea/population, 3) AS '1인당 점유면적' FROM country
WHERE population >= 100000000
ORDER BY surfaceArea/population ASC;

-- 17.
SELECT curdate() AS 오늘, 
	datediff(curdate(), '2022-01-01') AS '올해 지난 날', 
	date_add(curdate(), INTERVAL 100 DAY) AS '100일 후';

-- 18. important! case when then
SELECT name, continent, lifeExpectancy,
	CASE WHEN lifeExpectancy > 80 THEN '장수국가'
		WHEN lifeExpectancy > 60 THEN '일반국가'
		ELSE '단명국가'
	END AS '구분'
FROM country
WHERE continent = 'asia' AND lifeExpectancy IS NOT NULL
ORDER BY lifeExpectancy;

-- 19.
SELECT name, gnp, gnpold, ifnull(gnp-gnpold, '신규') AS 'GNP 향상' FROM country
ORDER BY name ASC;

-- 20.
SELECT weekday('2022-05-05'), IF(weekday('2022-05-05') > 4, '불행', '행복') AS '행복여부';

use world;

SELECT * FROM country;
SELECT * FROM city;
SELECT * FROM countrylanguage;

# 1. 
SELECT co.Code, co.Name
FROM country co, city ci
WHERE ci.CountryCode = co.Code AND ci.Name = 'kabul';


# 2.
SELECT co.Name, cl.Language, cl.Percentage
FROM country co, countrylanguage cl
WHERE co.Code = cl.CountryCode AND cl.IsOfficial = 'T' AND cl.Percentage = 100.0
ORDER BY co.Name;


# 3.
SELECT ci.Name, cl.Language, co.Name
FROM country co, countrylanguage cl, city ci
WHERE ci.CountryCode = cl.CountryCode AND ci.CountryCode = co.Code
		AND cl.IsOfficial = 'T' AND ci.Name = 'Amsterdam';
    
    
# 4.
SELECT co.Name, co.Capital, ci.Name '수도', ci.Population '수도인구'
FROM country co, city ci
WHERE co.Capital = ci.ID AND co.Name LIKE 'united%';


# 5.
SELECT co.Name, co.Capital, ifnull(ci.Name, '수도없음') '수도', ifnull(ci.Population, '수도없음') '수도인구'
FROM country co LEFT OUTER JOIN city ci
ON co.Capital = ci.ID
WHERE co.Name LIKE 'united%';


# 6.
SELECT count(DISTINCT(countryCode)) '국가수'
FROM countrylanguage
WHERE IsOfficial = 'T'
AND Percentage > (SELECT max(Percentage) FROM countrylanguage WHERE IsOfficial = 'T' AND countryCode = 'che' );


# 7.
-- Normal Query
SELECT cl.language
FROM country co, countrylanguage cl
WHERE co.Code = cl.countryCode AND co.name = 'south korea' AND cl.IsOfficial = 'T';

-- subQuery
SELECT language
FROM countrylanguage
WHERE IsOfficial = 'T' AND countryCode = (SELECT Code FROM country WHERE name = 'south korea');

-- subQuery FROM
SELECT cl.language
FROM countrylanguage cl, (SELECT * FROM country WHERE name = 'south korea') co
WHERE cl.IsOfficial = 'T' AND cl.countryCode = co.Code;


# 8.
-- Normal Query
SELECT co.name, co.code, count(ci.id) '도시 개수'
FROM country co, city ci
WHERE co.name LIKE 'bo%' AND co.code = ci.countryCode
GROUP BY co.name;

-- subQuery
SELECT co.name, co.code, ci.cnt
FROM country co, (SELECT countryCode, count(countryCode) 'cnt' FROM city GROUP BY countryCode) ci
WHERE co.name LIKE 'bo%' AND co.code = ci.countryCode;


# 9.
-- Normal Query
SELECT co.name, co.code,
		CASE WHEN count(ci.id) = 0 THEN '단독' ELSE count(ci.id) END '도시 개수'
FROM country co LEFT OUTER JOIN city ci
ON co.code = ci.countryCode
WHERE co.name LIKE 'bo%'
GROUP BY co.name;

-- subQuery
SELECT co.name, co.code, ifnull(ci.cnt, '단독')
FROM country co
	LEFT OUTER JOIN
	(SELECT countryCode, count(countryCode) 'cnt' FROM city GROUP BY countryCode) ci
ON co.code = ci.countryCode
WHERE co.name LIKE 'bo%';


# 10.
SELECT CountryCode, Name, Population
FROM city
WHERE Population = (SELECT max(Population) FROM city);


# 11.
-- subQuery
SELECT co.name, co.code, ci.name, ci.population
FROM city ci, country co
WHERE co.Code = ci.countryCode AND ci.population = (SELECT min(population) FROM city);

-- Nested subQuery
SELECT co.name, co.code, ci.name, ci.population
FROM country co, (SELECT CountryCode, Name, Population FROM city WHERE Population = (SELECT min(Population) FROM city)) ci
WHERE co.Code = ci.countryCode;


# 12.
-- Normal Query
SELECT ci1.countryCode, ci1.name, ci1.population
FROM city ci1, city ci2 -- self join
WHERE ci2.countryCode = 'KOR' AND ci2.name = 'seoul' AND ci1.population > ci2.population;

-- subQuery
SELECT countryCode, Name, Population
FROM city
WHERE Population > (SELECT population FROM city WHERE countryCode = 'KOR' AND name = 'seoul');


# 13.
-- Normal Query
SELECT cl.countryCode, cl.language
FROM countrylanguage cl, city ci
WHERE cl.IsOfficial = 'T' AND ci.name = 'san miguel' AND cl.countryCode = ci.countryCode;

-- subQuery FROM
SELECT cl.countryCode, cl.language
FROM countrylanguage cl, (SELECT countryCode FROM city WHERE name = 'san miguel') co
WHERE cl.IsOfficial = 'T' AND cl.countryCode = co.countryCode;

-- subQuery WHERE
SELECT countryCode, language
FROM countrylanguage
WHERE IsOfficial = 'T' AND countryCode IN (SELECT countryCode FROM city WHERE name = 'san miguel');


# 14.
-- Normal Query
SELECT countrycode, max(population) 'max_pop'
FROM city
GROUP BY countrycode
ORDER BY countrycode;
 
-- subQuery
SELECT ci.countryCode, ci.max_pop 'max_pop'
FROM country co, (SELECT countryCode, max(population) max_pop FROM city GROUP BY countryCode) ci
WHERE co.code = ci.countryCode
ORDER BY countryCode;


# 15.
SELECT countrycode, name, population
FROM city
WHERE (countryCode, population) IN (SELECT countrycode, max(population) FROM city GROUP BY countrycode)
ORDER BY countryCode;


# 16.
SELECT co.code, co.name, ci.name, ci.population
FROM country co
	LEFT OUTER JOIN
	(SELECT countrycode, name, population
		FROM city
		WHERE (countryCode, population) IN (SELECT countrycode, max(population) FROM city GROUP BY countrycode)
		ORDER BY countryCode ) ci
ON co.code = ci.countryCode;


# 17.
-- view는 자동갱신, 수정 불가능(readonly), 재사용 가능!
CREATE OR REPLACE VIEW summary AS
SELECT co.code, co.name 'co_name', ci.name 'ci_name', ci.population
FROM country co
	LEFT OUTER JOIN
	(SELECT countrycode, name, population
		FROM city
		WHERE (countryCode, population) IN (SELECT countrycode, max(population) FROM city GROUP BY countrycode)
		ORDER BY countryCode ) ci
ON co.code = ci.countryCode;


# 18.
SELECT * FROM summary WHERE code = 'KOR';
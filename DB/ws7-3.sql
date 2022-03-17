use world;

SELECT * FROM country;
SELECT * FROM city;
SELECT * FROM countrylanguage;

-- 1. 
SELECT co.Code, co.Name
FROM country co, city ci
WHERE ci.CountryCode = co.Code AND ci.Name = 'kabul';

-- 2.
SELECT co.Name, cl.Language, cl.Percentage
FROM country co, countrylanguage cl
WHERE co.Code = cl.CountryCode AND cl.IsOfficial = 'T' AND cl.Percentage = 100.0
ORDER BY co.Name;

-- 3.
SELECT ci.Name, cl.Language, co.Name
FROM country co, countrylanguage cl, city ci
WHERE ci.CountryCode = cl.CountryCode AND ci.CountryCode = co.Code
		AND cl.IsOfficial = 'T' AND ci.Name = 'Amsterdam';
        
-- 4.
SELECT co.Name, co.Capital, ci.Name '수도', ci.Population '수도인구'
FROM country co, city ci
WHERE co.Capital = ci.ID AND co.Name LIKE 'united%';

-- 5.
SELECT co.Name, co.Capital, ifnull(ci.Name, '수도없음') '수도', ifnull(ci.Population, '수도없음') '수도인구'
FROM country co LEFT OUTER JOIN city ci
ON co.Capital = ci.ID
WHERE co.Name LIKE 'united%';
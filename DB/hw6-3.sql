use world;

SELECT @@autocommit;
SET autocommit=false;

-- 1.
SELECT count(*) AS '전체',
		count(CASE WHEN IndepYear IS NOT NULL THEN 1 ELSE NULL END) AS '독립 연도 보유'
FROM country;
-- and
select count(code) "전체", count(indepyear) "독립 연도 보유" from country;

-- 2.
SELECT sum(LifeExpectancy) AS '합계',
		round(AVG(LifeExpectancy),2) AS '평균',
        max(LifeExpectancy) AS '최대',
        min(LifeExpectancy) AS '최소'
FROM country;

-- 3.
SELECT continent, count(*) AS '국가 수', sum(Population) AS '인구 합'
FROM country
GROUP BY continent
ORDER BY count(*) DESC;
-- and
select continent, count(code) "국가 수", sum(population) "인구 합"
from country group by continent order by 2 desc;

-- 4.
SELECT continent, sum(SurfaceArea) '표면적 합'
FROM country
GROUP BY continent
ORDER BY sum(SurfaceArea) DESC
LIMIT 3;

-- 5.
SELECT continent, sum(gnp) 'gnp 합'
FROM country
WHERE Population >= 50000000
GROUP BY continent
ORDER BY sum(gnp) ASC
LIMIT 5;

-- 6.
SELECT continent, sum(gnp) 'gnp 합'
FROM country
WHERE Population >= 50000000
GROUP BY continent
HAVING sum(gnp) >= 5000000;

-- 7.
SELECT IndepYear, count(*) '독립 국가 수'
FROM country
GROUP BY IndepYear
HAVING count(IndepYear) >= 10;

-- 8.
SELECT continent, name, gnp, avg(gnp) OVER ( PARTITION BY '*' ) '전세계 평균', AVG(gnp) OVER ( PARTITION BY continent ) '대륙 평균'
FROM country
GROUP BY continent, name
ORDER BY continent, name;
-- and
select continent, name, gnp, avg(gnp) over() "전세계 평균", avg(gnp) over(partition by continent) "대륙 평균" from country;
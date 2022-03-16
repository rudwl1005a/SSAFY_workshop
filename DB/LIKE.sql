SELECT * FROM address
WHERE address2 IS NULL; -- NULL은 IS, IS NOT 을 사용해야 한다

SELECT * FROM customer
WHERE first_name LIKE '_M%'; -- '%' : 자리수,캐릭터 무관 -> 'M%' : M으로 시작하는 것
							  -- '_' : 그 자리수에 캐릭터 한개 -> '_M%' : 두번째 자리가 M인것
                              -- '%AM%' : AM이 포함된 모든 것
SELECT * FROM customer
WHERE first_name LIKE 'M%'
AND last_name LIKE '%N';

-- !!주의!! INDEX 컬럼 first_name ==> LIKE 'LO%' -> 만들어진 INDEX를 이용 (탄다)
-- !!주의!! INDEX 컬럼 first_name ==> LIKE '%LO%' -> 앞에 %가 있으면 만들어진 INDEX를 이용x -> 느려짐

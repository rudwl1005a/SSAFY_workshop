use ssafydb;

-- LIVE CODE
select
	( select sum(salary) from employees where department_id = 50 ) sum50,
    ( select avg(salary) from employees where department_id = 60 ) avg60,
    ( select max(salary) from employees where department_id = 90 ) max90,
    ( select min(salary) from employees where department_id = 90 ) min90
from dual;

-- 개선 CODE
-- COUNT 를 제외한 SUM, AVG, MAX, MIN 은 NULL 을 제외
select 
    sum( case when department_id = 50 then salary else null  end ) sum50, -- else 인 경우 0 으로.
    avg( case when department_id = 60 then salary else null  end ) avg60, -- else 인 경우, 0 이 아닌 skip 이 되어야 함. null skip
    max( case when department_id = 90 then salary else null  end ) max90, -- else 인 경우, 0 으로
    min( case when department_id = 90 then salary else null  end ) min90 
from employees;

-- 개선 CODE ( department_id 에 index 가 있다면 )
select 
    sum( case when department_id = 50 then salary else null  end ) sum50, -- else 인 경우 0 으로.
    avg( case when department_id = 60 then salary else null  end ) avg60, -- else 인 경우, 0 이 아닌 skip 이 되어야 함. null skip
    max( case when department_id = 90 then salary else null  end ) max90, -- else 인 경우, 0 으로
    min( case when department_id = 90 then salary else null  end ) min90
from 
( select department_id, salary from employees where department_id in ( 50, 60, 90, 90 ) ) sub;
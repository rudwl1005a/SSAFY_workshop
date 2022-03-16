-- ROW 1개 1개 대신 ROW를 합치는 방식 GROUP BY
SELECT count(*) FROM employees;
SELECT department_id, count(*) FROM employees
GROUP BY department_id;

-- COUNT
SELECT department_id, count(*) FROM employees
WHERE department_id > 50
GROUP BY department_id;

-- SUM
SELECT department_id, sum(salary) FROM employees
GROUP BY department_id
ORDER BY sum(salary) DESC;

-- MIN, MAX
SELECT department_id, min(salary), max(salary) FROM employees
GROUP BY department_id;

-- AVG
SELECT department_id, job_id, AVG(salary) FROM employees
GROUP BY department_id, job_id;

-- HAVING -> GROUP BY 한 다음에 필터링
SELECT department_id, AVG(salary) FROM employees
GROUP BY department_id
HAVING AVG(salary) > 5000;

-- WINDOW FUCTION
-- OVER PARTITION BY
SELECT employee_id, department_id, AVG(salary) OVER ( PARTITION BY department_id )
FROM employees;
-- function --
SELECT concat(first_name, '-', last_name ) FROM customer; -- concat : 문자열 합쳐주기

SELECT email, replace(email, '.', '_') FROM customer; -- replace : 문자열 변경

SELECT lpad(name, 20, '*') FROM category; -- lpad : 자리수 맞추기 위한 함수
SELECT lpad('_', 5, '_');

SELECT name, left(name, 2) FROM category; -- left : 왼쪽에서부터 몇자 가져오기 / right : 오른쪽에서부터

SELECT name, length(name), char_length(name) FROM category; -- length : byte의 길이, char_length() : char의 길이
SELECT char_length('한글'), length('한글'), char_length('ENG'), length('ENG');

SELECT instr('ABCDEFG', 'CDE'); -- instr : 몇번째부터 시작인지

SELECT * FROM country
WHERE instr(country, 'au') > 0; -- LIKE와 똑같은 쿼리 ==> index필요할 경우 -> instr / 포함관계는 LIKE가 더 유리

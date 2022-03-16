-- TIMEZONE -> UTC 세계 표준 시
SELECT @@time_zone;

SELECT curdate(); -- 현재 날짜
SELECT now(); -- 현재날짜 + 시간 Asia/Seoul
SELECT utc_date(); -- UTC 날짜
SELECT utc_time(); -- UTC 시간

SELECT last_update, date_format(last_update, '%Y%m%d') FROM country; -- date_format : 날짜형식

SELECT str_to_date('2022/03/06', '%Y/%m/%d'); -- str_to_date : 문자열 날짜 형식으로 바꾸기

SELECT datediff('2022-05-27', '2022-03-16'); -- datediff : 날짜의 차이
SELECT last_update, datediff('2006-03-15', last_update) FROM country;

SELECT date_add('2022-03-16', INTERVAL 50 DAY); -- date_add : 날짜 더해서 표시
SELECT date_add(now(), INTERVAL 20 DAY);

SELECT weekday('2022-03-16'); -- weekday : 요일 -> zero-based 0:월, 1:화, 2:수, ... 6:일

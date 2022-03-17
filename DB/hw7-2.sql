# 1. test_user 라는 이름으로 새로운 schema를 생성하고, 해당 스키마를 사용하시오.
CREATE SCHEMA `test_user`;
USE test_user;

# 2. 만약 user 라는 테이블이 존재한다면 삭제하시오.
DROP TABLE if exists user;

# 3. test_user 에 다음 조건을 만족하는 user 테이블을 생성하시오.
CREATE TABLE user (
	`id` VARCHAR(40) NOT NULL,
    `password` VARCHAR(40) NOT NULL,
    `name` VARCHAR(40) NOT NULL,
    `email` VARCHAR(40) NOT NULL,
	`age` INT NOT NULL
)ENGINE=InnoDB;

# 4. user 테이블에 아래와 같이 phone_number 라는 컬럼을 삽입하시오.
ALTER TABLE user ADD `phone_number` INT;

# 5. user 테이블의 phone_number 컬럼을 아래와 같이 변경하시오.
ALTER TABLE user MODIFY `phone_number` VARCHAR(40);

# 6. phone_number 컬럼을 삭제하시오.
ALTER TABLE user DROP `phone_number`;

# 7. user 테이블에 아래와 같은 데이터를 삽입하시오.
INSERT INTO user (id, password, name, email, age)
VALUE	('BlackWidow', '1278','나타샤 로마노프', 'blackwidow@ssafy.com', 38),
		('CaptainAmerica', '5678','스티브 로저스', 'Captain@ssafy.com', 30),
        ('Hulk', '2486','브루스 배너', 'hulk@ssafy.com', 54),
		('Ironman', '1234','토니 스타크', 'ironman@ssafy.com', 53),
		('Thor', '1111','토르', 'GodOfThunder@ssafy.com', 1500),
		('Ultron', '2355','울트론', 'ultron@ssafy.com', 0);

-- and
-- INSERT INTO user VALUE ( 'BlackWidow', '1278',  '나타샤 로마노프', 'blackwidow@ssafy.com', 38 );
-- INSERT INTO user VALUE ( 'CaptainAmerica', '5678',  '스티브 로저스', 'Captain@ssafy.com', 30 );
-- INSERT INTO user VALUE ( 'Hulk', '2486',  '브루스 배너', 'hulk@ssafy.com', 54 );
-- INSERT INTO user VALUE ( 'Ironman', '1234',  '토니 스타크', 'ironman@ssafy.com', 53 );
-- INSERT INTO user VALUE ( 'Thor', '1111',  '토르', 'GodOfThunder@ssafy.com', 1500 );
-- INSERT INTO user VALUE ( 'Ultron', '2355',  '울트론', 'ultron@ssafy.com', 0 );

# 8. name이 토르 인 사용자의 eamil을 ‘Thor@ssafy.com’ 으로 변경하시오.
UPDATE user SET email = 'Thor@ssafy.com' WHERE name = '토르';

# 9. age가 1000 이상인 사용자를 삭제하시오.
DELETE FROM user WHERE age >= 1000;

# 10. user 테이블에 있는 모든 data를 삭제하시오.
DELETE FROM user;

SELECT * FROM user;
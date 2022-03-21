use happyhouse4;

-- 회원정보 테이블 생성
CREATE TABLE member (
	`user_id` VARCHAR(20) PRIMARY KEY NOT NULL,
    `password` VARCHAR(20) NOT NULL,
    `name` VARCHAR(20) NOT NULL,
    `address` VARCHAR(100) NOT NULL,
    `phoneNumber` VARCHAR(11)
);

-- 아파트 테이블 생성
CREATE TABLE apartment (
	`id` INT NOT NULL AUTO_INCREMENT,
	`district` VARCHAR(100) NOT NULL DEFAULT '지역정보 없음',
	`name` VARCHAR(45) NOT NULL DEFAULT '이름정보 없음',
	`price` INT NOT NULL,
	PRIMARY KEY (`id`)
);

-- 관심 지역 테이블 생성
CREATE TABLE favorite (
	`user_id` VARCHAR(20) NOT NULL,
	`district` VARCHAR(100)
);

-- member테이블의 user_id를 favorite테이블의 FK로 설정
ALTER TABLE `happyhouse4`.`favorite` 
ADD INDEX `FK_USER_ID_idx` (`user_id` ASC) VISIBLE;

ALTER TABLE `happyhouse4`.`favorite` 
ADD CONSTRAINT `FK_USER_ID`
  FOREIGN KEY (`user_id`)
  REFERENCES `happyhouse4`.`member` (`user_id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;
  
INSERT INTO member (user_id, password, name, address, phoneNumber)
VALUE	('id1', 'pw1', '민경대', '서울시 대방동', '01011112222'),
		('id2', 'pw2', '손준혁', '창원시 사파동', '01022223333'),
		('id3', 'pw3', '김싸피', '부산시 송정동', '01012345678'),
		('id4', 'pw4', '홍길동', '서울시 상도동', '01087654321');
        
INSERT INTO favorite (user_id, district)
VALUE	('id1', '대방동'),
		('id1', '송정동'),
		('id2', '사파동'),
		('id3', '송정동'),
		('id4', '상도동');

INSERT INTO apartment (`district`, `name`, `price`)
VALUE	('창원시 대방동', '대동아파트', 35000),
		('창원시 사파동', '사파동성아파트', 17000),
		('창원시 상남동', '은아아파트', 80000),
		('서울시 상도동', '쌍용스윗닷홈아파트', 95000),
		('서울시 신대방동', '보라매삼성쉐르빌아파트', 139000),
		('서울시 신대방동',  '보라매자이더포레스트', 120000);
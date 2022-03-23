use board;

CREATE TABLE `users` (
  `USER_SEQ` int NOT NULL AUTO_INCREMENT,
  `USER_NAME` varchar(100) NOT NULL,
  `USER_PASSWORD` varchar(50) NOT NULL,
  `USER_EMAIL` varchar(100) NOT NULL,
  `USER_PROFILE_IMAGE_URL` varchar(500) DEFAULT NULL,
  `USER_REGISTER_DATE` date DEFAULT NULL,
  PRIMARY KEY (`USER_SEQ`),
  UNIQUE KEY `USER_EMAIL_UNIQUE` (`USER_EMAIL`)
);

CREATE TABLE `board` (
  `BOARD_ID` int NOT NULL AUTO_INCREMENT,
  `USER_SEQ` int NOT NULL,
  `TITLE` varchar(500) DEFAULT NULL,
  `CONTENT` text,
  `REG_DT` datetime DEFAULT NULL,
  `READ_COUNT` int DEFAULT '0',
  PRIMARY KEY (`BOARD_ID`),
  KEY `FK_USER_idx` (`USER_SEQ`),
  CONSTRAINT `FK_USER` FOREIGN KEY (`USER_SEQ`) REFERENCES users (`USER_SEQ`)
);

INSERT INTO users (USER_NAME, USER_PASSWORD,USER_EMAIL, USER_REGISTER_DATE) 
VALUES ('홍길동', '1234', 'hong@gildong.com', now());
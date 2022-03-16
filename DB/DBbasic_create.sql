-- table 복사
CREATE TABLE jdbc_big_2 AS SELECT * FROM jdbc_big; -- 데이터 복사
INSERT INTO jdbc_big_2 SELECT * FROM jdbc_big; -- 한번 더 넣기

-- table 생성
CREATE TABLE `customer` (
  `customer_id` int NOT NULL,
  `customer_nm` varchar(45) NOT NULL,
  PRIMARY KEY (`customer_id`)
);

CREATE TABLE `customer_order` (
  `order_id` int NOT NULL,
  `customer_id` int DEFAULT NULL,
  `product_id` int DEFAULT NULL,
  `order_price` int DEFAULT NULL,
  PRIMARY KEY (`order_id`)
);

CREATE TABLE `product` (
  `product_id` int NOT NULL,
  `product_nm` varchar(45) NOT NULL,
  `product_price` int DEFAULT NULL,
  PRIMARY KEY (`product_id`)
);

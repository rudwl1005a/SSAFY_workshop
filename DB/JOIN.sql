use test;

-- 고객의 주문 정보를 처리
-- 원장 테이블 마스터 테이블 : 수정가능 / 거래 테이블 이력 테이블 : 단순 기록용

SELECT customer_order.order_id, customer_order.customer_id, customer_order.product_id, customer_order.order_price,
		customer.customer_nm, product.product_nm, product.product_price
FROM customer_order, customer, product
WHERE customer_order.product_id = product.product_id
AND customer_order.customer_id = customer.customer_id;

-- alias
SELECT co.order_id, co.customer_id, co.product_id, co.order_price,
		c.customer_nm, p.product_nm, p.product_price
FROM customer_order co, customer c, product p
WHERE co.product_id = p.product_id
AND co.customer_id = c.customer_id;

-- 각 테이블에 고유한 컬럼은 생략가능 -> 가독성 부분에서 권장하지는 않음
SELECT order_id, co.customer_id, co.product_id, co.order_price,
		customer_nm, product_nm, p.product_price
FROM customer_order co, customer c, product p
WHERE co.product_id = p.product_id
AND co.customer_id = c.customer_id;

-- LEFT OUTER JOIN
SELECT co.order_id, co.customer_id, co.product_id, co.order_price, c.customer_nm
FROM customer_order co, customer c
WHERE co.customer_id = c.customer_id;

SELECT co.order_id, co.customer_id, co.product_id, co.order_price, c.customer_nm
FROM customer c
LEFT OUTER JOIN customer_order co
ON co.customer_id = c.customer_id;


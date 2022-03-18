use test;

# Normal query
SELECT co.order_id, co.customer_id, c.customer_nm, 
       co.product_id, p.product_nm, co.order_price, p.product_price
FROM customer_order co, customer c, product p
WHERE co.customer_id = c.customer_id AND co.product_id = p.product_id AND p.product_price <= 1500;

# SubQuery
SELECT co.order_id, co.customer_id, c.customer_nm, co.product_id, co.order_price,
		(SELECT p.product_nm FROM product p WHERE co.product_id = p.product_id AND p.product_price <= 1500) product_nm,
        (SELECT p.product_price FROM product p WHERE co.product_id = p.product_id AND p.product_price <= 1500) product_price
FROM customer_order co, customer c
WHERE co.customer_id = c.customer_id;
 
# subQuery FROM
SELECT co.order_id, co.customer_id, c.customer_nm, co.product_id, p.product_nm, co.order_price, p.product_price
FROM customer_order co, customer c,
		(SELECT product_id, product_nm, product_price FROM product WHERE product_price <= 1500) p
WHERE co.customer_id = c.customer_id
AND co.product_id = p.product_id;

# subQuery WHERE
SELECT co.order_id, co.customer_id, c.customer_nm, co.product_id, co.order_price
FROM customer_order co, customer c
WHERE co.customer_id = c.customer_id AND co.product_id IN ( SELECT product_id FROM product WHERE product_price <= 1500 );
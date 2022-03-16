SELECT round(123.456, -1); -- round : 반올림

SELECT address, ifnull(address2, 'A'), address2 FROM address; -- ifnull : null이면 바꿔줘라

-- CASE WHEN THEN 
SELECT first_name, last_name,
	   CASE WHEN store_id = 1 THEN 'ONE'
			 WHEN store_id = 2 THEN 'TWO'
			ELSE 'ETC'
		END STORE_BLOCK
FROM customer;
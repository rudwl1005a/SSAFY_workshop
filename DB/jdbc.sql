use test;

# -----------------------------
SELECT * FROM temp;

INSERT INTO temp (col_5) VALUES ('hello');

INSERT INTO temp values ();	-- Error Code: 1062. Duplicate entry '1' for key 'temp.col_3_UNIQUE'
								-- col_3에서 unique속성 빼면 OK

# -----------------------------
CREATE TABLE jdbc_table (
  `col_id` int NOT NULL AUTO_INCREMENT,
  `col_nm` varchar(45) DEFAULT NULL,
  `col_not_null` varchar(45) NOT NULL,
  `col_default_val` varchar(45) DEFAULT 'hello',
  PRIMARY KEY (col_id)
);





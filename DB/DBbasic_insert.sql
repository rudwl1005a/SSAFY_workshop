-- data 삽입
INSERT INTO `test`.`customer` (`customer_id`, `customer_nm`) VALUES ('1', '홍길동');
INSERT INTO `test`.`product` (`product_id`, `product_nm`, `product_price`) VALUES ('111', 'TV', '1000');
INSERT INTO `test`.`product` (`product_id`, `product_nm`, `product_price`) VALUES ('222', '냉장고', '2000');
INSERT INTO `test`.`customer_order` 
            (`order_id`, `customer_id`, `product_id`, `order_price`) 
     VALUES ('11', '1', '111', '1000');
     
update customer_order
set customer_id = 3;


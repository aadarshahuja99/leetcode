# Write your MySQL query statement below
-- with temp as (
--     select distinct product_id, MAX(change_date) as last_date from products where change_date <= '2019-08-16'
--     group by product_id
-- ),
-- temp_1 as (
--     select products.product_id, IFNULL(new_price, 10) as price from products left join temp on products.product_id = temp.product_id
-- )
-- select * from temp_1;
-- select distinct(p.product_id) as product_id, new_price as price from products p left join temp t on t.product_id = p.product_id and t.last_date = p.change_date;

-- WITH cte AS
-- (SELECT *, RANK() OVER (PARTITION BY product_id ORDER BY change_date DESC) AS r 
-- FROM Products
-- WHERE change_date<= '2019-08-16')
-- select * from cte

SELECT product_id, COALESCE( MAX(IF(change_date <= '2019-08-16', new_price, NULL)), 10 ) AS price FROM products GROUP BY product_id;

# Write your MySQL query statement below
select distinct p.product_id as product_id, p.product_name as product_name from Product p inner join (
    select product_id as s_product_id,
    MIN(sale_date) OVER (PARTITION BY product_id) as start_date,
    MAX(sale_date) OVER (PARTITION BY product_id) as end_date
    from sales
) t on s_product_id = product_id where end_date <= '2019-03-31' AND start_date >= '2019-01-01';
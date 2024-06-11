# Write your MySQL query statement below
with cte as (
    select distinct product_id, MIN(year) OVER (PARTITION BY product_id) as first_year from sales
)
select p.product_id, p.year as first_year, p.quantity, price from sales p, cte where p.year = cte.first_year and p.product_id = cte.product_id;

-- select distinct product_id, MIN(year) OVER (PARTITION BY product_id ORDER BY year) as yr from sales
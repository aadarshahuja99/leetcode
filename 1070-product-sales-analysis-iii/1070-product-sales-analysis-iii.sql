# Write your MySQL query statement below
with first_year as (
    select distinct product_id, MIN(year) OVER (PARTITION BY product_id ORDER BY year) as yr from sales
)
select p.product_id, p.year as first_year, SUM(p.quantity) as quantity, price from sales p inner join
first_year on p.product_id = first_year.product_id WHERE first_year.yr = p.year
group by p.product_id, p.year, price;

-- select distinct product_id, MIN(year) OVER (PARTITION BY product_id ORDER BY year) as yr from sales
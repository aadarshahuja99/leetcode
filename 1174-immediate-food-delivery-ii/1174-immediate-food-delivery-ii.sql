# Write your MySQL query statement below
WITH cte as (
    select customer_id, MIN(order_date) as min_date from Delivery group by customer_id
),
cte_count as (
    select SUM(CASE WHEN min_date = customer_pref_delivery_date THEN 1 ELSE 0 END) as valid_count from
    Delivery inner join cte on cte.customer_id = Delivery.customer_id
)
select ROUND((cte_count.valid_count/(select count(distinct customer_id) from Delivery))*100, 2) as immediate_percentage from cte_count;
# Write your MySQL query statement below
with order_cte as (
    select * from orders where order_date <= '2019-12-31' AND order_date >= '2019-01-01'
)
select user_id as buyer_id, join_date, SUM(case when order_id is not null THEN 1 else 0 end) orders_in_2019 
from users left join order_cte on
users.user_id = order_cte.buyer_id group by user_id;
# Write your MySQL query statement below
with out_cte as (
    select paid_by as user_id, IFNULL(SUM(amount), 0) as total_out from Transactions group by paid_by order by paid_by
),
in_cte as (
    select paid_to as user_id, IFNULL(SUM(amount), 0) as total_in from Transactions group by paid_to order by paid_to
),
updated_users as (
    select * from users order by users.user_id
)

-- select * from out_cte;

select u.user_id as user_id, u.user_name as user_name, u.credit + IFNULL(total_in,0) - IFNULL(total_out, 0) as credit,
CASE WHEN u.credit + IFNULL(total_in,0) - IFNULL(total_out, 0) >= 0 THEN 'No' ELSE 'Yes' END as credit_limit_breached
from updated_users u left join out_cte on out_cte.user_id = u.user_id
left join in_cte on in_cte.user_id = u.user_id;
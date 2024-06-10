# Write your MySQL query statement below
WITH updated_users as (
    select * from Signups 
),
updated_con as (
    select * from confirmations
)
select u.user_id as user_id, ROUND(AVG(CASE WHEN c.action = 'confirmed' THEN 1 ELSE 0 END), 2) as confirmation_rate from
updated_users u left join updated_con c on u.user_id = c.user_id group by u.user_id;
-- select user_id, SUM(CASE WHEN action = 'confirmed' THEN 1 ELSE 0 END) as accepted_count from
--      Confirmations group by user_id order by user_id
# Write your MySQL query statement below
WITH login_cte as (
    select distinct id, login_date from logins
),
history_cte as (
    select a.id as user_id, a.name as name, login_date, LAG(login_date, 4) OVER (PARTITION BY login_cte.id ORDER BY login_date) as last from login_cte inner join accounts a
    on a.id = login_cte.id
)
-- select * from history_cte;

select distinct user_id as id, name from history_cte where DATEDIFF(login_date, last) = 4;

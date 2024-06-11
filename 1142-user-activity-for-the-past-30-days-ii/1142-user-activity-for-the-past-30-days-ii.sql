# Write your MySQL query statement below
select IFNULL(ROUND(COUNT(distinct session_id)/COUNT(distinct user_id), 2), 0) as average_sessions_per_user
from Activity
where activity_date BETWEEN '2019-06-28' AND '2019-07-27'
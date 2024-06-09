# Write your MySQL query statement below
select users.name as name, IFNULL(SUM(r.distance), 0) as travelled_distance from users left join
rides r on r.user_id = users.id group by r.user_id order by travelled_distance desc, name asc;
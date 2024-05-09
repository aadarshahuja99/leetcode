# Write your MySQL query statement below
select t.name as name from (select c.id as id, c.name as name, Count(v.id) votecount from candidate c inner join vote v on
v.candidateid = c.id group by c.id order by votecount desc limit 1) AS t;
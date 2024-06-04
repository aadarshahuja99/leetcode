# Write your MySQL query statement below
select t.name from (select emp.name as name, COUNT(e.id) from Employee emp inner join Employee e on emp.id = e.managerId group by
emp.id having COUNT(e.id) >= 5) as t;
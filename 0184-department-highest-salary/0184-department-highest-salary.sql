# Write your MySQL query statement below
select d.name as Department, e.name as Employee, e.salary as Salary
from (select id, name, salary, departmentId from (select *, DENSE_RANK() OVER (PARTITION BY departmentId order by salary desc) as ranking from Employee) t where t.ranking = 1) e 
inner join Department d
on e.departmentId = d.id;
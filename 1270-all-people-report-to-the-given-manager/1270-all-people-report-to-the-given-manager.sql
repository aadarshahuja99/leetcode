# Write your MySQL query statement below
WITH RECURSIVE rec_cte as (
    select employee_id from employees where manager_id = 1 and employee_id <> 1
    union all
    select e.employee_id from employees e inner join rec_cte on rec_cte.employee_id = e.manager_id
)
select employee_id from rec_cte;
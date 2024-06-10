# Write your MySQL query statement below
with query as (
    select e.name as name from (
        select distinct employee.managerId as id, COUNT(employee.id) OVER (PARTITION BY employee.managerId) as employee_count
        from employee
    ) t, Employee e where t.employee_count >= 5 AND t.id = e.id
)
select query.name from query;
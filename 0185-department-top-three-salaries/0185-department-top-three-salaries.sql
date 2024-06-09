# Write your MySQL query statement below

select dept.name as Department, emp.name as Employee, emp.salary as Salary from Employee emp inner join
(
    select id, DENSE_RANK() OVER(PARTITION BY departmentId Order By salary desc) AS dept_salary_rank
    from Employee
) t on t.id = emp.id inner join Department dept on dept.id = emp.departmentId where t.dept_salary_rank < 4;
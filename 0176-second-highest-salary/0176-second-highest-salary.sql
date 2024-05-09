# Write your MySQL query statement below
SELECT Max(salary) AS SecondHighestSalary

FROM Employee 

WHERE salary NOT IN (SELECT MAX(salary) FROM employee);
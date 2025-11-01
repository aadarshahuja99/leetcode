# Write your MySQL query statement below
select distinct email as Email from (
    select email, COUNT(*) OVER (PARTITION BY email) as email_count
    from Person
) t where email_count > 1;
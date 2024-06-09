# Write your MySQL query statement below
select v.customer_id, SUM(case when t.amount is null then 1 else 0 end) as count_no_trans from Visits v left join Transactions t
on t.visit_id = v.visit_id and t.amount > 0 where t.amount is null group by v.customer_id;
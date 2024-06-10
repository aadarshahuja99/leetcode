# Write your MySQL query statement below
with updated_p as (
    select * from prices order by product_id, start_date, end_date
),
updated_s as (
    select * from unitssold order by product_id, purchase_date
)
select p.product_id as product_id, IFNULL(ROUND(SUM(s.units*p.price)/SUM(s.units), 2), 0) as average_price from
 prices p left join unitssold s on s.product_id = p.product_id AND
s.purchase_date between p.start_date and p.end_date group by p.product_id;

-- select * from unitssold order by product_id, purchase_date;
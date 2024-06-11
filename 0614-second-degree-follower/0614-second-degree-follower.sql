# Write your MySQL query statement below
with follower_count as (
    select followee, count(*) as followed from Follow group by followee having followed >= 1
),
followee_count as (
    select follower, count(*) as follows from Follow group by follower having follows >= 1
)
select followee as follower, followed as num from follower_count inner join followee_count on
follower = followee order by followee;
# Write your MySQL query statement below
with follower_count as (
    select followee, count(*) as followed from Follow group by followee
),
followee_count as (
    select follower, count(*) as follows from Follow group by follower
)
select followee as follower, followed as num from follower_count inner join followee_count on
follower = followee where followed >= 1 AND follows >= 1 order by followee;
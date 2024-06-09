# Write your MySQL query statement below
select ROUND(SUM(tiv_2016), 2) AS tiv_2016 from (
    select tiv_2016, count(*) OVER (PARTITION BY tiv_2015) AS tiv_2015_count,
    count(*) OVER (PARTITION BY lat, lon) AS loc_count from Insurance
) insurance_data WHERE tiv_2015_count > 1 AND loc_count = 1;
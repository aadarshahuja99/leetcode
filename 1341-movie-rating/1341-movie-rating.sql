# Write your MySQL query statement below
select name as results from (
    select u.name as name, u.user_id, COUNT(u.user_id) as review_count from movierating mr inner join
    users u on u.user_id = mr.user_id group by u.user_id, u.name order by COUNT(u.user_id) desc, u.name LIMIT 1
) as t1
UNION ALL
select name as results from (
    select m.title as name, m.movie_id, AVG(mr.rating) as max_rating from movierating mr inner join
    movies m on m.movie_id = mr.movie_id where MONTH(mr.created_at) = 2 AND YEAR(mr.created_at) = 2020 group by m.movie_id, m.title order by AVG(mr.rating) desc, m.title LIMIT 1
) as t2;
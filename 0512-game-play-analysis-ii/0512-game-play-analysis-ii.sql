# Write your MySQL query statement below
select player_id, device_id from Activity where (event_date, player_id) in (
    select MIN(a.event_date) OVER(PARTITION BY a.player_id) as event_date, a.player_id as player_id
    from Activity a
);
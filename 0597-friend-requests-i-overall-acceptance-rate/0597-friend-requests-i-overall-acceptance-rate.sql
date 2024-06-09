# Write your MySQL query statement below
select ROUND((count(distinct a.requester_id, a.accepter_id)) / (count(distinct r.sender_id, r.send_to_id)), 2)
as accept_rate from RequestAccepted a, FriendRequest r;
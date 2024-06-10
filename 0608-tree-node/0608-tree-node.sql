# Write your MySQL query statement below
with child_counts as (
    select p_id as node_id, COUNT(id) as child_count from Tree group by p_id having p_id is not null
)
select id,
(
    CASE
    WHEN p_id is null THEN 'Root'
    WHEN child_count is null THEN 'Leaf'
    WHEN child_count > 0 AND p_id is null THEN 'Root'
    ELSE 'Inner'
    END
) as type from Tree left join child_counts on Tree.id = child_counts.node_id;
WITH ManagerReports AS (
    SELECT
        managerId,
        COUNT(*) AS manager_report_count
    FROM
        Employee
    WHERE
        managerId IS NOT NULL
    GROUP BY
        managerId
    HAVING
        manager_report_count >= 5
)
SELECT
    e.name
FROM
    Employee e
INNER JOIN
    ManagerReports mr ON e.id = mr.managerId;
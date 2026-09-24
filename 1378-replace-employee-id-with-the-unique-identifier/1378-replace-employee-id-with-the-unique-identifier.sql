# Write your MySQL query statement below
SELECT un.unique_id , e.name
FROM Employees as e
LEFT JOIN EmployeeUNI as un
ON e.id=un.id;
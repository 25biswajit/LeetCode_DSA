/* Write your PL/SQL query statement below */

SELECT max(salary) as SecondHighestSalary
FROM (
    SELECT salary,
           DENSE_RANK() OVER (ORDER BY salary DESC) AS rank
    FROM Employee
) T
WHERE rank = 2

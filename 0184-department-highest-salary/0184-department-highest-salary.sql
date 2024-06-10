/* Write your PL/SQL query statement below */


Select T.emp_name Employee, T.dept_name Department, T.salary salary
from
(select
Dense_rank() over ( PARTITION BY E.departmentId ORDER BY salary desc) as rank,
E.name emp_name , D.name dept_name, E.salary
from 
Employee E
join 
Department D
on E.departmentId = D.id) T
where T.Rank = 1;
/* Write your PL/SQL query statement below */

Select Department, Employee, Salary from 
(
Select D.name as Department, E.name as Employee, E.Salary as Salary,
DENSE_RANK() over (partition by D.name Order by (E.Salary) DESC) as rank
from Employee E Left Join Department D on E.departmentId = D.id
)
where rank <= 3
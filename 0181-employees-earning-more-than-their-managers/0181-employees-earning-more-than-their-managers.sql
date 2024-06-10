/* Write your PL/SQL query statement below */

select T.emp_name Employee from 
(
select e1.id emp_id, e1.salary emp_sal, e1.name emp_name,
e2.id mgr_id, e2.salary mgr_sal 
from 
Employee e1
left join
Employee e2
on e1.managerId = e2.id
) T
where T.emp_sal > T.mgr_sal
/* Write your PL/SQL query statement below */


select email from
(select count(email) cnt, email from Person
group by email)
where cnt > 1;
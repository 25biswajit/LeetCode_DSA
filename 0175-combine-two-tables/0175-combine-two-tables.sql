# Write your MySQL query statement below


select P.firstName, P.lastName, A.city, A.State
from 
Person P
Left Join
Address A
on P.personId = A.personId
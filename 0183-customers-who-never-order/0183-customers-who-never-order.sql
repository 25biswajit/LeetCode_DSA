/* Write your PL/SQL query statement below */

Select C.name Customers from Customers C
Left JOIN Orders O
on C.ID = O.customerId
where O.customerId IS NULL
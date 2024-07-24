/* Write your PL/SQL query statement below */


select CURR.ID
from Weather CURR Left Join Weather PREV
ON CURR.recordDate - 1 = PREV.recordDate
where CURR.temperature > PREV.temperature
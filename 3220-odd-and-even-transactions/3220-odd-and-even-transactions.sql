# Write your MySQL query statement below

Select transaction_date,
SUM(CASE WHEN amount % 2 = 1 THEN amount ELSE 0 END) AS odd_sum,
SUM(CASE WHEN amount % 2 = 0 THEN amount ELSE 0 END) AS even_sum
from transactions
group by transaction_date
order by transaction_date
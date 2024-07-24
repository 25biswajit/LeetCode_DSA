/* Write your PL/SQL query statement below */


-- SELECT num ConsecutiveNums
-- FROM 
-- (
--     SELECT
--         num,
--         LAG(num, 1) OVER (ORDER BY id) AS prev_num,
--         LEAD(num, 1) OVER (ORDER BY id) AS next_num
--     FROM
--         Logs
-- )
-- WHERE num = prev_num AND num = next_num;


SELECT DISTINCT L1.num AS ConsecutiveNums FROM 
Logs L1 
left join Logs L2 on L1.num=L2.num
left join Logs L3 on L2.num=L3.num
WHERE L1.id=L2.id - 1 and  L2.id=L3.id-1;
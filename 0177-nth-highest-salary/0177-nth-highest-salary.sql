CREATE FUNCTION getNthHighestSalary(@N INT) RETURNS INT AS
BEGIN
    RETURN (
        /* Write your T-SQL query statement below. */
       select max(T.salary) from 
             (select salary, 
                Dense_Rank() over (order by salary desc) as rank from Employee) T
               where T.rank = @N

    );
END
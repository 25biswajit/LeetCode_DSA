/* Write your PL/SQL query statement below */

select request_at DAY,
ROUND(cancelled / total_count, 2) "Cancellation Rate"
from
(
Select request_at, 
count(request_at) total_count,
SUM(CASE when T.status != 'completed' then 1 else 0 END) cancelled
from Trips T 
left join Users U1 on T.client_id = U1.users_id
left join Users U2 on T.driver_id = U2.users_id 
where U1.banned = 'No' and U2.banned = 'No' 
and request_at between '2013-10-01' and '2013-10-03'
group by request_at
)
order by request_at







-- Select T.*
-- from Trips T 
-- left join Users U1 
-- on T.client_id = U1.users_id 
-- where U1.banned = 'No'
-- order by request_at

-- left join Users U2 on T.driver_id = U2.users_id and U2.banned = 'No'
-- group by request_at



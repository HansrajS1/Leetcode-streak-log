# Write your MySQL query statement below
SELECT user_id, email
FROM Users
WHERE email LIKE '%.com'
AND email REGEXP '^[A-Za-z0-9_]+@[A-Za-z]+\\.com$'
ORDER BY user_id;

# Write your MySQL query statement below
WITH ranked_reviews AS (
    SELECT
        employee_id,
        review_date,
        rating,
        ROW_NUMBER() OVER (
            PARTITION BY employee_id
            ORDER BY review_date DESC
        ) AS rn
    FROM performance_reviews
),
last_three AS (
    SELECT
        employee_id,
        review_date,
        rating,
        ROW_NUMBER() OVER (
            PARTITION BY employee_id
            ORDER BY review_date ASC
        ) AS seq
    FROM ranked_reviews
    WHERE rn <= 3
)
SELECT
    e.employee_id,
    e.name,
    MAX(lt.rating) - MIN(lt.rating) AS improvement_score
FROM employees e
JOIN last_three lt
    ON e.employee_id = lt.employee_id
GROUP BY e.employee_id, e.name
HAVING COUNT(*) = 3
   AND MAX(CASE WHEN seq = 1 THEN rating END)
       < MAX(CASE WHEN seq = 2 THEN rating END)
   AND MAX(CASE WHEN seq = 2 THEN rating END)
       < MAX(CASE WHEN seq = 3 THEN rating END)
ORDER BY improvement_score DESC, e.name ASC;


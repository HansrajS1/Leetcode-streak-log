# Write your MySQL query statement below
WITH top_performers AS (
    SELECT user_id
    FROM course_completions
    GROUP BY user_id
    HAVING COUNT(*) >= 5
       AND AVG(course_rating) >= 4
),
course_sequence AS (
    SELECT
        user_id,
        course_name,
        LEAD(course_name) OVER (
            PARTITION BY user_id
            ORDER BY completion_date, course_id
        ) AS next_course
    FROM course_completions
    WHERE user_id IN (
        SELECT user_id
        FROM top_performers
    )
)
SELECT
    course_name AS first_course,
    next_course AS second_course,
    COUNT(*) AS transition_count
FROM course_sequence
WHERE next_course IS NOT NULL
GROUP BY course_name, next_course
ORDER BY
    transition_count DESC,
    first_course ASC,
    second_course ASC;

# Write your MySQL query statement below
WITH daily_sales AS (
    SELECT
        visited_on,
        SUM(amount) AS daily_amount
    FROM Customer
    GROUP BY visited_on
)

SELECT
    visited_on,
    SUM(daily_amount) OVER (
        ORDER BY visited_on
        ROWS BETWEEN 6 PRECEDING AND CURRENT ROW
    ) AS amount,
    ROUND(
        AVG(daily_amount) OVER (
            ORDER BY visited_on
            ROWS BETWEEN 6 PRECEDING AND CURRENT ROW
        ),
        2
    ) AS average_amount
FROM daily_sales
LIMIT 18446744073709551615 OFFSET 6;

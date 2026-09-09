SELECT
    customer_id,
    COUNT(*) AS total_orders,

    ROUND(
        100.0 * SUM(
            CASE
                WHEN TIME(order_timestamp) BETWEEN '11:00:00' AND '14:00:00'
                  OR TIME(order_timestamp) BETWEEN '18:00:00' AND '21:00:00'
                THEN 1
                ELSE 0
            END
        ) / COUNT(*)
    ) AS peak_hour_percentage,

    ROUND(AVG(order_rating), 2) AS average_rating

FROM restaurant_orders

GROUP BY customer_id

HAVING
    COUNT(*) >= 3

    AND SUM(
        CASE
            WHEN TIME(order_timestamp) BETWEEN '11:00:00' AND '14:00:00'
              OR TIME(order_timestamp) BETWEEN '18:00:00' AND '21:00:00'
            THEN 1
            ELSE 0
        END
    ) * 1.0 / COUNT(*) >= 0.60

    AND ROUND(AVG(order_rating), 2) >= 4.00

    AND COUNT(order_rating) * 1.0 / COUNT(*) >= 0.50

ORDER BY
    average_rating DESC,
    customer_id DESC;


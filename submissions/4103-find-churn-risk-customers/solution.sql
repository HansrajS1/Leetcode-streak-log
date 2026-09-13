SELECT
    user_id,
    current_plan,
    current_monthly_amount,
    max_historical_amount,
    DATEDIFF(last_date, first_date) AS days_as_subscriber
FROM (
    SELECT
        user_id,

        SUBSTRING_INDEX(
            GROUP_CONCAT(
                plan_name
                ORDER BY event_date DESC, event_id DESC
            ),
            ',',
            1
        ) AS current_plan,

        CAST(
            SUBSTRING_INDEX(
                GROUP_CONCAT(
                    monthly_amount
                    ORDER BY event_date DESC, event_id DESC
                ),
                ',',
                1
            ) AS DECIMAL(10,2)
        ) AS current_monthly_amount,

        MAX(monthly_amount) AS max_historical_amount,

        MIN(event_date) AS first_date,
        MAX(event_date) AS last_date,

        MAX(
            CASE
                WHEN event_type = 'downgrade' THEN 1
                ELSE 0
            END
        ) AS has_downgrade,

        SUBSTRING_INDEX(
            GROUP_CONCAT(
                event_type
                ORDER BY event_date DESC, event_id DESC
            ),
            ',',
            1
        ) AS last_event

    FROM subscription_events
    GROUP BY user_id
) t
WHERE last_event <> 'cancel'
  AND has_downgrade = 1
  AND current_monthly_amount < max_historical_amount * 0.5
  AND DATEDIFF(last_date, first_date) >= 60
ORDER BY days_as_subscriber DESC, user_id ASC;

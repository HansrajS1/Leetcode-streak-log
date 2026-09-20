# Write your MySQL query statement below
WITH ranked_inventory AS (
    SELECT
        store_id,
        product_name,
        quantity,
        price,
        ROW_NUMBER() OVER (
            PARTITION BY store_id
            ORDER BY price DESC
        ) AS expensive_rank,
        ROW_NUMBER() OVER (
            PARTITION BY store_id
            ORDER BY price ASC
        ) AS cheap_rank
    FROM inventory
),

store_stats AS (
    SELECT
        store_id,
        COUNT(*) AS product_count
    FROM inventory
    GROUP BY store_id
    HAVING COUNT(*) >= 3
)

SELECT
    s.store_id,
    s.store_name,
    s.location,
    MAX(CASE
        WHEN r.expensive_rank = 1
        THEN r.product_name
    END) AS most_exp_product,
    MAX(CASE
        WHEN r.cheap_rank = 1
        THEN r.product_name
    END) AS cheapest_product,
    ROUND(
        MAX(CASE
            WHEN r.cheap_rank = 1
            THEN r.quantity
        END) /
        MAX(CASE
            WHEN r.expensive_rank = 1
            THEN r.quantity
        END),
        2
    ) AS imbalance_ratio
FROM stores s
JOIN ranked_inventory r
    ON s.store_id = r.store_id
JOIN store_stats ss
    ON s.store_id = ss.store_id
GROUP BY
    s.store_id,
    s.store_name,
    s.location
HAVING
    MAX(CASE
        WHEN r.expensive_rank = 1
        THEN r.quantity
    END)
    <
    MAX(CASE
        WHEN r.cheap_rank = 1
        THEN r.quantity
    END)
ORDER BY
    imbalance_ratio DESC,
    s.store_name ASC;

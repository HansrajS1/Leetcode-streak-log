# Write your MySQL query statement below
WITH invalid_ips AS (
    SELECT ip
    FROM logs
    WHERE
        -- Must have exactly 4 octets
        ip NOT REGEXP '^([0-9]+\\.){3}[0-9]+$'
        
        -- Any octet > 255
        OR CAST(SUBSTRING_INDEX(ip, '.', 1) AS UNSIGNED) > 255
        OR CAST(SUBSTRING_INDEX(SUBSTRING_INDEX(ip, '.', 2), '.', -1) AS UNSIGNED) > 255
        OR CAST(SUBSTRING_INDEX(SUBSTRING_INDEX(ip, '.', 3), '.', -1) AS UNSIGNED) > 255
        OR CAST(SUBSTRING_INDEX(ip, '.', -1) AS UNSIGNED) > 255
        
        -- Leading zeros in any octet
        OR ip REGEXP '(^|\\.)0[0-9]+'
)
SELECT
    ip,
    COUNT(*) AS invalid_count
FROM invalid_ips
GROUP BY ip
ORDER BY invalid_count DESC, ip DESC;

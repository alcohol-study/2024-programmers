SELECT f.flavor as FLAVOR
FROM FIRST_HALF f JOIN JULY j ON f.flavor = j.flavor
GROUP BY f.flavor
ORDER BY SUM(f.total_order)+ SUM(j.total_order) DESC
LIMIT 3;

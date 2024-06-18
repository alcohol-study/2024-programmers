-- 코드를 입력하세요
SELECT fp.product_id, fp.product_name, fp.price * fo.total_amount as total_price
FROM(SELECT product_id, SUM(amount) as total_amount
        FROM FOOD_ORDER
        WHERE YEAR(produce_date) = 2022 AND MONTH(produce_date) = 5
        GROUP BY product_id
    ) fo join FOOD_PRODUCT fp
    ON fo.product_id = fp.product_id
ORDER BY total_price DESC, fp.product_id ASC;

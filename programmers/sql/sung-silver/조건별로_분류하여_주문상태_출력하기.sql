SELECT order_id, product_id, DATE_FORMAT(out_date, "%Y-%m-%d") as datetime,
CASE WHEN DATEDIFF('2022-05-01', DATE_FORMAT(out_date, "%Y-%m-%d")) >= 0 
            THEN "출고완료"
     WHEN DATEDIFF('2022-05-01', DATE_FORMAT(out_date, "%Y-%m-%d")) < 0 
            THEN "출고대기"
     ELSE "출고미정" END as "출고여부"
FROM FOOD_ORDER
ORDER BY order_id asc;

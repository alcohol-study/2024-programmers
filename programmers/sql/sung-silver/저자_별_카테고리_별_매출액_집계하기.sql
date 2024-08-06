-- 코드를 입력하세요
SELECT a.author_id as AUTHOR_ID, a.author_name as AUTHOR_NAME, b.category as CATEGORY,
SUM(bs.SALES * b.PRICE) as SALES
FROM BOOK b JOIN AUTHOR a ON b.author_id = a.author_id JOIN BOOK_SALES bs on bs.book_id = b.book_id
WHERE YEAR(bs.sales_date) = 2022 AND MONTH(bs.sales_date) = 1
GROUP BY AUTHOR_ID, AUTHOR_NAME, CATEGORY
ORDER BY AUTHOR_ID ASC, CATEGORY DESC;

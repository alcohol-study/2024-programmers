SELECT b.category, sum(bs.sales) as tatal_sales
FROM BOOK b JOIN BOOK_SALES bs on b.book_id = bs.book_id
WHERE YEAR(bs.sales_date)=2022 AND MONTH(bs.sales_date)=1
GROUP BY b.category
ORDER BY b.category ASC;

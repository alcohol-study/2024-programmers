-- 코드를 입력하세요
SELECT user_id, nickname, 
       CONCAT(city," ", street_address1," ", street_address2) AS 전체주소, 
       CONCAT(SUBSTRING(tlno, 1, 3), '-', SUBSTRING(tlno, 4, 4), '-', SUBSTRING(tlno, 8, 4)) AS 전화번호
FROM USED_GOODS_USER
WHERE user_id IN (
    SELECT writer_id
    FROM USED_GOODS_BOARD
    GROUP BY writer_id
    HAVING COUNT(*) >= 3
)
ORDER BY user_id DESC;

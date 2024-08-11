-- 코드를 입력하세요
SELECT host_id FROM PLACES GROUP BY host_id HAVING count(*)>=2

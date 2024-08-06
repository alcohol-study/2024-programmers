-- 코드를 입력하세요
-- SELECT MONTH(START_DATE) MONTH, CAR_ID, COUNT(HISTORY_ID) RECORDS
-- FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
-- WHERE START_DATE >= '2022-08-01' AND START_DATE < '2022-11-01'
-- GROUP BY MONTH(START_DATE), CAR_ID
-- HAVING COUNT(HISTORY_ID) >= 5
-- ORDER BY MONTH(START_DATE), CAR_ID DESC;
-- --> 틀린 코드

-- 코드를 입력하세요
SELECT MONTH(START_DATE) MONTH, CAR_ID, COUNT(HISTORY_ID) RECORDS
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
WHERE CAR_ID IN (
    SELECT CAR_ID -- 1. 먼저 08~10월에 해당하는 총 car 개수가 5개 넘는 애들을 대상으로 커팅
    FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
    WHERE START_DATE >= '2022-08-01' AND START_DATE < '2022-11-01'
    GROUP BY CAR_ID
    HAVING COUNT(CAR_ID) >= 5
    ) AND START_DATE >= '2022-08-01' AND START_DATE < '2022-11-01' -- 2. 근데 그 애들이 7월이나 다른 원에 빌린게 있을수 있으니까 커팅
GROUP BY MONTH, CAR_ID -- 3. 월, 차 번호로 그룹바이
HAVING COUNT(HISTORY_ID) > 0 -- 4. 각 월별로 0개 되거나 그러면 커팅 --> 어차피 총 개수는 5개 넘으니까
ORDER BY MONTH(START_DATE), CAR_ID DESC;
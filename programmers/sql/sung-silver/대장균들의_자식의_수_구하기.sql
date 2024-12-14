-- 코드를 작성해주세요
SELECT f.id, 
       (SELECT COUNT(*) 
        FROM ecoli_data s 
        WHERE s.parent_id = f.id) AS child_count
FROM ecoli_data f
ORDER BY f.id ASC;

SELECT i.name, i.datetime
FROM ANIMAL_INS i LEFT JOIN ANIMAL_OUTS o
ON i.animal_id = o.animal_id
WHERE o.animal_id IS NULL
ORDER BY i.datetime ASC
LIMIT 3;

SELECT ai.animal_id, ai.name
FROM ANIMAL_INS ai JOIN ANIMAL_OUTS ao
ON ai.animal_id = ao.animal_id
WHERE TIMESTAMPDIFF(SECOND, ai.datetime, ao.datetime) < 0
ORDER BY ai.datetime ASC;

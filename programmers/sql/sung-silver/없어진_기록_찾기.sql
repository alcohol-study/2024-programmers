SELECT o.animal_id, o.name
FROM ANIMAL_INS i right join ANIMAL_OUTS o
on i.animal_id = o.animal_id
WHERE i.animal_id IS NULL;

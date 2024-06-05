SELECT i.animal_id, i.name
FROM animal_ins i join animal_outs o
on i.animal_id = o.animal_id
order by (o.datetime - i.datetime) DESC
limit 2;

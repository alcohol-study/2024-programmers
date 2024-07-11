select hd.dept_id as DEPT_ID, hd.dept_name_en as DEPT_NAME_EN, ROUND(AVG(he.sal)) as AVG_SAL
from hr_department hd join hr_employees he
on hd.dept_id = he.dept_id
group by he.dept_id
order by AVG_SAL desc;

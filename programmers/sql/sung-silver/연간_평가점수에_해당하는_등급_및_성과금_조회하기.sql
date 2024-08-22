-- 코드를 작성해주세요
select c.emp_no, c.emp_name,
    case 
        when(h.score >= 96) then 'S'
        when(h.score >= 90) then 'A'
        when(h.score >= 80) then 'B'
        else 'C'
    end as grade,
    case
        when(h.score >= 96) then c.sal_sum*0.2
        when(h.score >= 90) then c.sal_sum*0.15
        when(h.score >= 80) then c.sal_sum*0.1
        else 0
    end as bonus
from (select  emp_no, emp_name, sum(sal) as sal_sum
from hr_employees
group by emp_no, emp_name) c join 
    (select emp_no, AVG(score) as score
     from hr_grade
     group by emp_no) h
     on c.emp_no = h.emp_no
order by c.emp_no asc;

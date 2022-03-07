-- SELECT * FROM EMPLOYEES;

-- job_id�� ��� salay�� 10000 �̻��� job_id�� ���salary�� ���salary�� ������������ ���� ��

SELECT JOB_ID, AVG(SALARY) FROM EMPLOYEES GROUP BY JOB_ID HAVING AVG(SALARY) >= 10000 ORDER BY AVG(SALARY) DESC ;

-- MANAGER_ID�� ���(�ݿø�), �ִ�, �ּ� salary�� MANAGER_ID�� ������������ ���� ��

SELECT MANAGER_ID, round(AVG(SALARY)), MAX(SALARY), min(salary) FROM EMPLOYEES GROUP BY MANAGER_ID ORDER BY MANAGER_ID ASC ;

select e.first_name, e.last_name, j.job_title from employees e right join jobs j on e.job_id = j.job_id;
select e.first_name, e.last_name, j.job_title from employees e ,jobs j where e.job_id(+) = j.job_id;

select e.first_name, e.hire_date, d.department_name from employees e, departments d where e.department_id = d.department_id(+) order by first_name;


--1. SMITH라는 직원 부서명 검색
SELECT d.DEPTNO, d.DNAME
FROM emp e, dept d
WHERE e.ename = 'SMITH' AND e.DEPTNO = d.DEPTNO;

SELECT deptno, dname
FROM DEPT d 
WHERE deptno = (
				SELECT deptno 
				FROM emp 
				WHERE ename = 'SMITH'
);

--2. SMITH와 동일한 직급(job)을 가진 사원들의 모든 정보 검색(SMITH 포함)
select * 
from emp e
where job = (select job from emp where ename = 'SMITH');

--SMITH 제외
select * 
from emp e
where job = (select job from emp where ename = 'SMITH')
and ename != 'SMITH';

--3. SMITH와 급여가 동일하거나 더 많은(>=) 사원명과 급여 검색
-- SMITH 제외해서 검색하기
SELECT ename, sal
FROM EMP
WHERE sal >= (SELECT sal FROM emp WHERE ename = 'SMITH')
and ename != 'SMITH';

--4. DALLAS에 근무하는 사원의 이름, 부서 번호 검색
SELECT ename, deptno
FROM EMP 
WHERE DEPTNO = (SELECT DEPTNO FROM DEPT d WHERE loc = 'DALLAS');

--5. 평균 급여보다 더 많이 받는(>) 사원만 검색
SELECT ename, sal FROM emp 
WHERE sal > (SELECT avg(SAL) FROM EMP);

-- 1~5번까지는 sub query의 결과가 단일

-- 다중행 서브 쿼리(sub query의 결과값이 하나 이상)
-- 6.급여가 3000이상 사원이 소속된 부서에 속한  사원이름, 급여 검색
	--급여가 3000이상 사원의 부서 번호
	-- in
SELECT sal, deptno FROM emp WHERE SAL >= 3000;

SELECT ename, sal FROM emp 
WHERE deptno IN (SELECT DEPTNO FROM emp where sal >= 3000);

--7. in 연산자를 이용하여 
-- 부서별로 가장 급여를 많이 받는 사원의 정보(사번, 사원명, 급여, 부서번호) 검색
SELECT empno, ename, sal, deptno FROM emp 
WHERE (deptno, sal) in(SELECT deptno, max(sal) FROM emp GROUP BY DEPTNO);
--8. 직급(job)이 MANAGER인 사람이 속한 부서의 
-- 부서 번호와 부서명(dname)과 지역검색(loc)
SELECT deptno, dname, loc FROM dept 
WHERE deptno IN (SELECT deptno FROM emp WHERE job = 'MANAGER');
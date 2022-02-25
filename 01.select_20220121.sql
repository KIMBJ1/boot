-- 11 2022.01.21

-- SCOTT/TIGER

-- 검색 문장 학습 (select)
/*
1. select 문장 기본 syntatx
    select절
    from절;
2. 정렬 포함
    select절
    from절
    order by절;
3. 조건절 포함
    select
    from
    where절;

* 참고
    - dual table
        - 잉여 table / 데이터 없음 / syntax적으로 from 필요시 사용
        - select 2+3 from dual;
        - select sysdate from dual;
*/
sqlplus SCOTT/TIGER

set linesize 200
set pagesize 200

-- 1. 해당 계정이 사용 가능한 모든 table 검색
select * from tab;

-- 2. emp table의 모든 내용(모든 row, column) 검색
select * from emp;

-- 3. emp 구조 검색
desc emp;
-- 4. emp의 사번 검색
select empno from emp;

-- 5. emp의 사번, 이름 검색
select empno, ename from emp;

-- 6. emp의 사번, 이름 검색 (별칭 적용)
select empno as 사번, ename as 이름 from emp;

-- 7. 부서 번호
select deptno from emp;

-- 8. 중복 제거된 부서 번호 검색 : distinct
select distinct deptno from emp;

-- 9. 정렬 : order by asc / desc
select distinct deptno from emp order by deptno asc;
select distinct deptno from emp order by deptno desc;

-- 실행 순서
from -> select -> order by

-- 10. 사번 내림차순 과 이름 검색
select empno, ename from emp order by empno desc;

-- 11. dept table의 deptno값만 검색 오름차순
select deptno from dept order by deptno asc;

-- 12. 입사일hiredate 검색, 입사일이 오래된 직원부터 검색
-- 고려사항 : date 타입 정렬 가능?
select hiredate from emp; : hiredate 존재 확인
select hiredate, ename from emp order by hiredate asc;

-- 13. 모든 사원의 이름, 월 급여, 연봉 검색
select ename, sal, sal*12 as 연봉 from emp;

-- 14. 모든 사원의 이름, 월 급여, 연봉 검색, 단 comm도 고려
    -- SALESMAN만 comm 존재 나머지는 null
    -- null 보유 column, 데이터 보유 column 연산 -> 모든 data null
    -- null을 0값으로 대체
    -- 모든 db는 지원하는 내장 함수 있
    -- null -> 숫자 값 대체함수 : nvl(Null value)
select comm, nvl(comm,0) from emp;
select ename, sal*12+nvl(comm,0) as 연봉 from emp;

-- *** 조건식 where***

-- 15. comm이 null 검색
select * from emp where comm is null;

-- 16. comm이 not null 검색
-- 부정 연산자 not
select * from emp where comm is not null;

-- 17. 사원명이 스미스인 사원의 사번, 이름 검색
select empno, ename from emp where ename = 'SMITH';

-- 2022.01.24

-- 18. 부서번호가 10번 이름 사번 부서번호 검색
-- 사번이 내림차순
select empno, ename, deptno 
from emp 
where deptno = 10 
order by empno desc;

-- 19. emp table에서 sal>= 1000 사원 이름순 정렬
select * from emp where sal >= 1000 order by ename asc;

-- 20. sal >= 900이상 이름 사번 급여
select empno, ename, sal 
from emp 
where sal >= 900 
order by sal desc;

-- 21. deptno = 10, jpb = 'MANAGER'
-- and
select * from emp where deptno = 10 and job = 'MANAGER';

-- 'manager' != 'MANAGER'
select * from emp where deptno = 10 and job = 'manager';

-- 대소문자 구분 없이 검색 : 대소문자 호환 함수
--upper() / lower()
/*
함수 - 독립적으로 개발되는 기능 / 참조 변수없이 함수명만으로 호출
메소드 - 클래스 내부애 구현되는 기능 / 객체 참조 변수로 호출
*/
select * from emp where deptno = 10 and job = upper('manager');

--22. deptno 가 10이 아닌 *
-- !=
select * from emp where deptno != 10;
-- not
select * from emp where not deptno = 10;
-- <>
select * from emp where deptno <> 10;

-- 23. sal <= 2000 or sal >= 3000
select * from emp where sal <= 2000 or sal >= 3000;

-- 24. comm 300 or 500 or 1400
-- in 연산식
select * from emp where comm in(300, 500, 1400);

-- 25. comm 이 300 500 1400 아닌애들
select * from emp where comm not in(300, 500, 1400);

-- 26. HIREDATE - date 타입
-- date 타입 비교 학습
-- date 타입 ''로 문자열처럼 표현 가능
-- 81/09/28 입사 검색
-- yy/mm/dd 포멧 나중에 변경 예정(함수 사용)
select * from emp where hiredate = '81/09/28';
-- date 타입의 yy mm dd 구분자는 / or -
select * from emp where hiredate = '81-09-28';

-- 27. 날짜 타입의 범위 검색
-- berween
select * from emp where hiredate between '80-12-17' and '81-02-22';
select * from emp where hiredate between '80-12-17' and '81/02/22';

-- 28. 검색시 포함된 모든 데이터 검색
-- like
select * from emp where ename like 'S%';
select * from emp where ename like 'S____';
select * from emp where ename like 'S_I%';

sqlplus hr/hr
set linesize 400
set pagesize 400


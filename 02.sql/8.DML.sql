--8.DML.sql
/* 
- DML : Data Mainpulation Language
            데이터 조작 언어
	   (select/insert/update/delete 모두 다 DML)
	   - 이미 존재하는 table에 데이터 저장, 수정, 삭제, 검색 

- create 는 트랜젝션과 무관
- insert/update/delete 문장의 필수 항목
	: 작업 후에 실제 db 저장시 commit; 필수
	: db 자체에는 임시 저장소 / 영구 저장소 분리
		- insert/update/delete 작업은 commit 명령어 전까지 임시 저장소
		- commit 실행시 영구 저장영역으로 이관
		- rollback 실행시 임시 저장소에서도 휘발
	- 트랜젝션
		- 여러 작업을 마치 하나의 작업으로 간주
			ex) 계좌 이체의 개별 작업이 다 성공해야 실제 계좌 이체 성공
		- commit : 영구 저장/ rollback : 복원
		- application 개발 시 
		db에 insert후에 commit 안하고 데이터 검색시 검색 불가

		*) dbeaver 는 기본이 auto commit
*/

/*
1. insert sql문법
	1-1. 모든 칼럼에 데이터 저장시 
		- table 구조상의 컬럼 순서에 맞게 모든 데이터 저장시 사용하는 문법
		- 컬럼명 명시 생략 
		insert into table명 values(데이터값1, ...)

	1-2.  특정 칼럼에만 데이터 저장시,
		명확하게 칼럼명 기술해야 할 경우 
		insert into table명 (칼럼명1, ...) values(칼럼과매핑될데이터1...)

	1-3. 하나의 sql문장으로 다수의 table에 데이터 입력 방법
		insert all 
			into table명 [(칼럼명,...)] values(데이터,,,)		
		select 검색칼럼 from....;

2. update 
	2-1. 모든 table(다수의 row)의 데이터 한번에 수정
		- where조건문 없는 문장
		- update table명 set 칼럼명=수정데이타;

	2-2. 특정 row값만 수정하는 방법
		- where조건문으로 처리하는 문장
		- update table명 set 칼럼명=수정데이타 where 조건sql;
*/

drop table people;

-- people은 제약 조건이 없음
-- 컬럼 모두 null 허용
-- 하나의 컬럼에만 데이터 insert 가능
create table people(
	name varchar2(10),
	age number(3)
);

desc people;

-- *** insert ****
--1. 칼럼명 기술없이 데이터 입력
insert into people values ('asdf', 20);

--2. 칼럼명 기술후 데이터 입력 
insert into people (name) values ('qwer');
insert into people (age, name) values (100, 'zxcv');

--3. 다중 table에 한번에 데이터 insert하기 
drop table emp01;
drop table emp02;
create table emp01 as select empno, ename, deptno from emp where 1=0;
create table emp02 as select empno, ename, deptno from emp where 1=0;
select * from emp01;
select * from emp02;


insert all
	into emp01 (empno, ename, deptno) values (empno, ename, deptno)
	into emp02 (empno, ename, deptno) values (empno, ename, deptno)
select empno, ename, deptno from emp;

commit;

select * from emp01;
select * from emp02;

--4. ? 부서 번호가 10인 데이터는 emp01에 저장, 
-- 부서 번호가 20 or 30인 데이터는 emp02에 저장
-- 조건 표현 : when~then
insert all
	when deptno = 10 then 
		into emp01(empno, ename, deptno) values (empno, ename, deptno)
	when deptno = 20 or deptno = 30  then 
		into emp02 (empno, ename, deptno) values (empno, ename, deptno)
select empno, ename, deptno from emp;

commit;

select * from emp01;
select * from emp02;

-- ?  1, asdf, 20 emp01 / 2, zxcv,100 emp02 insert
insert all
	into emp01 (empno, ename, deptno) values (1, 'asdf', 20)
	into emp02 (empno, ename, deptno) values (2, 'zxcv', 99)
select * from dual;



-- 데이터만 삭제 - rollback으로 복구 불가능한 데이터 삭제 명령어
-- tx(트랜젝션 약자) 명령어와 무관한 명령어
-- 날리면 복구 ㄴㄴ
truncate table emp01;
truncate table emp02;

select * from emp01;

i

select * from emp01;

-- *** update ***
--1. 테이블의 모든 행 변경
drop table emp01;
create table emp01 as select * from emp;
select deptno from emp01;

update emp01 set deptno = 60;

select deptno from emp01;

-- 이전의 데이터로 복원
rollback;
select deptno from emp01;

--2. ? emp01 table의 모든 사원의 급여를 10%(sal*1.1) 인상하기
--? emp table로 부터 empno, sal, hiredate, ename 순으로 table 생성
update emp01 set sal = sal*1.1;
select * from emp01;

--3. emp01의 모든 사원의 입사일을 오늘(sysdate)로 바꿔주세요
update emp01 set hiredate = sysdate;
select * from emp01;

-- 4. 급여가 3000이상(where sal >= 3000)인 사원의 급여만 10%인상
update emp01 set sal = sal*1.1 where sal >= 3000;
select * from emp01;

--5. ?emp01 table 사원의 급여가 1000이상인 사원들의 급여만 500원씩 삭감 
-- insert/update/delete 문장에 한해서만 commit과 rollback 영향을 받음
update emp01 set sal = sal - 500 where sal >= 1000;
select * from emp01;

--6. emp01 table에 DALLAS(dept의 loc)에 위치한 부서의 소속 사원들의 급여를 1000인상
-- 서브쿼리 사용
drop table emp01;
create table emp01 as select * from emp;
select * from emp01;

update emp01 set sal = sal + 1000 
where deptno = (select deptno from dept where loc = 'DALLAS');
select * from emp01;

--7. emp01 table의 SMITH 사원의 부서 번호를 30으로, 직급은 MANAGER 수정
-- 두개 이상의 칼럼값 동시 수정
select deptno, job from emp01 where ename='SMITH';

update emp01 set deptno = 30, job = 'MANAGER'
where ename = 'SMITH';

select deptno, job from emp01 where ename='SMITH';

-- *** delete ***
--tx 필수 명령어
--8. 하나의 table의 모든 데이터 삭제
delete from emp01;
commit;

--9. 특정 row 삭제(where 조건식 기준)
delete from emp02 where deptno = 20;
select * from emp02;
commit;

--10. emp01 table에서 comm 존재 자체가 없는(null) 사원 모두 삭제
drop table emp01;
create table emp01 as select * from emp;
select * from emp01;
delete from emp01 where comm is null;
select * from emp01;

--11. emp01 table에서 comm이 null이 아닌 사원 모두 삭제
delete from emp01 where comm is not null;
select * from emp01;

--12. emp01 table에서 부서명이 RESEARCH 부서에 소속된 사원 삭제 
-- 서브쿼리 활용
select * from emp01;

delete from emp01 
where deptno = (select deptno from dept where dname = 'RESEARCH');

select * from emp01;

--13. table내용 삭제
/*
tx 무관한 명령어 - truncate
수행속도 빠른건 truncate
*/
delete from emp01;
truncate emp01;

-- *** merge[병합] ***
--14. 병합을 위한 test table생성 및 데이터 insert
-- 판매 관련 table들
drop table produce01;
drop table produce02;
drop table produce_total;

create table produce01(
	판매번호 varchar2(5), 
	제품번호 char(4),
	수량 number(3),
	금액 number(5)
);
create table produce02(
	판매번호 varchar2(5), 
	제품번호 char(4),
	수량 number(3),
	금액 number(5)
);
create table produce_total(
	판매번호 varchar2(5), 
	제품번호 char(4),
	수량 number(3),
	금액 number(5)
);

-- test용 데이터 insert
insert all
	into produce01 values('101', '1001', 1, 500)
	into produce01 values('102', '1002', 1, 400)
	into produce01 values('103', '1003', 1, 300)
	into produce02 values('201', '1004', 1, 500)
	into produce02 values('202', '1005', 1, 600)
	into produce02 values('203', '1006', 1, 700)
select * from dual;

commit;
select * from produce01;
select * from produce02;
select * from produce_total;

-- merge 작업 : produce01과 produce_total 병합
-- ? 문법 이해를 위한 문제 분석해 보기 
/*
produce_total로 생산된 데이터들을 insert또는 update
1. 새로운 제품 : insert
2 이미 존재하는 데이터 : update
*/
select * from produce_total;

merge into produce_total t
using produce01 p1
on (t.판매번호 = p1.판매번호)
when matched then
	update set t.수량 = t.수량+p1.수량
when not matched then 
	insert values(p1.판매번호, p1.제품번호, p1.수량, p1.금액);

-- 실행 결과 확인
select * from produce_total;

--? produce02 table과 produce_total table 병합 
select * from produce_total;

merge into produce_total t
using produce02 p2
on (t.판매번호 = p2.판매번호)
when matched then
	update set t.수량 = t.수량+p2.수량
when not matched then 
	insert values(p2.판매번호, p2.제품번호, p2.수량, p2.금액);

select * from produce_total;

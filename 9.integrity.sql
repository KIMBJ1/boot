-- 9.integrity.sql
-- DB 자체적으로 강제적인 제약 사항 설정
-- 개발자 능력 + 시스템(HW/SW) 다 유기적으로 연계
-- 모델링하는 테이블의 제약조건 설정은 개발자의 책임
-- 설정은 개발자의 책임

/*
참고 1
	emp의 deptno는 dept의 deptno에 종속적 - fk
	emp의 deptno에는 무관한 데이터 저장시 에러
	emp의 empno / dept의 deptno는 중복 불허, 널 불허 - pk
참고 2
	dictionary table
		db별 db 자체 관리 table
		user들은 read만 가능
		제약조건, view 정보 등 저장

1. table 생성시 제약조건을 설정하는 기법 

2. 제약 조건 종류
	emp와 dept의 관계
	
	2-1. PK[primary key] - 기본키, 중복불가, null불가, 데이터들 구분을 위한 핵심 데이터
		: not null + unique
	2-2. not null - 반드시 데이터 존재, 데이터 중복 허용
	2-3. unique - 중복 불가, null 허용
	2-4. check - table 생성시 규정한 범위의 데이터만 저장 가능 
	2-5. default - insert시에 특별한 데이터 미저장시에도 자동 저장되는 기본 값
					- 자바 관점에는 멤버 변수 선언 후 객체 생성 직후 멤버 변수 기본값으로 초기화
	* 2-6. FK[foreign key] 
		- 외래키[참조키], 다른 table의 pk를 참조하는 데이터 
		- table간의 주종 관계가 형성
		- pk 보유 table이 부모, 참조하는 table이 자식
		- 부모의 미 존재하는 데이터를 자식에서 새로 생성가능? 불가 
		- 자식 table들이 존재할 경우 부모table만 삭제 가능? 불가
			- 해결책 : 관계를 해제도 가능하나 가급적 분석설계시 완벽하리만큼 고민후 설계
	

3. 사용자 정의하는 제약 조건에 제약 조건명 명시하는 방법
	3-1. oracle engine이 기본적으로 설정
		- 사용자가 제약 조건에 별도의 이름을 부여하지 않으면 오라클 자체적으로 SYS_시작하는 이름을 자동 부여
		- SYS_Xxxx

	3-2. sql개발자가 직접 설정
		- table명_컬럼명_제약조건명등 기술..단 순서는 임의 변경 가능
			: dept의 deptno이 제약조건명
				PK_DEPT
				pk_dept_deptno
		- 약어 사용도 가능[분석, 설계시 용어사전 제시후 작성 권장]
	
4. 제약조건 선언 위치
	4-1. 컬럼 레벨 단위
		- 컬럼선언 라인에 제약조건 설정 

	4-2. 테이블 레벨 단위 
		- 모든 컬럼 선언 직후 별도로 마지막 라인에 제약조건 설정 
	4-3. 이미 생성된 table에 제약 조건 추가 및 수정
		- alter
		- 현업에선 model tool로 모델링 필수로 작업
			- 잘 구축된 모델링인 경우 tool로 sql 자동 생성
			- 대부분의 tool table생성 후 alter명령어로 제약조건
			- 추가 형식으로 sql 생성
		참고
			alter - add / modify / drop
	
5. 오라클 자체 특별한 table
	5-1. user_constraints
		- 제약조건 정보 보유 table
		- 개발자가 table의 데이터값 직접 수정 불가
		- select constraint_name, constraint_type, table_name 
			from user_constraints;

6. 이미 존재하는 table의 제약조건 수정(추가, 삭제)명령어
	6-1. 제약조건 추가
		alter table 테이블명 add constraint 제약조건명 제약조건(컬럼명);
		alter table dept01 add constraint dept01_deptno_pk primary key(deptno);
		
	6-2. 제약조건 삭제(drop)
		- table삭제 
		alter table 테이블명 cascade constraint;
		
		alter table 테이블명 drop 제약조건명;
		alter table dept01 drop primary key;
		
	6-3. 제약조건 임시 비활성화
		alter table emp01 disable constraint emp01_deptno_fk;

	6-4. 제약조건 활성화
		alter table emp01 enable constraint emp01_deptno_fk;
	
*/

-- 1.  딕셔너리 table 검색
select * from user_constraints;
desc user_constraints;

--2. 사용자 정의 제약 조건명 명시하기
-- emp02_empno_nn 이름으로 직접 제약조건명 명시
-- user_constraints table에 자동 저장
-- emp02_empno_nn 이름으로 emp02의 empno는 not null 설정
-- 협약 : table과 컬럼명 제약조전을 적절히 표현 가능한 이름 권장
-- 참고 : 현업에선 not null 제약조건명 설정하지 않음
-- 단순 문법 습득을 의한 설정으로 제시
drop table emp02;

create  table emp02(
	empno number(4) constraint emp02_empno_nn not null,
	ename varchar2(10)
);

select constraint_name, constraint_type, table_name
from user_constraints where table_name='EMP02';

/*
EMP02_EMPNO_NN : 제약조건
C : 제약조건 타입
EMP02 : 제약조건이 설정된 table명
		소문자로 생성해도 db는 대문자로 변환해서 사전 table 저장
*/
-- 사전 table에서 소문자로 테이블명 검색시 데이터 없음

--3. 사용자 정의 제약조건명 설정 후 위배시 출력되는 메세지에 사용자정의 제약조건명
	-- 확인 가능 : not null을 제외한 제약조건명은 에러 발생시 가시적인 확인 가능
-- emp02는 empno에 not null
insert into emp02 values(1, 'tester');
insert into emp02 (empno)) values(2);

select * from emp02;

insert into emp02 (ename) values ('asdf');
select * from emp02;

--4. 제약조건명을 오라클 엔진이 자동적으로 지정
	-- 에러 발생시 SYS_xxxx로 출력됨 
	-- unique : null 허용 / 중복 불허
drop table emp02;
create table emp02(
	empno number(4)  unique,
	ename varchar2(10)
);

select constraint_name, constraint_type, table_name
from user_constraints where table_name='EMP02';

insert into emp02 values(1, 'tester');
-- insert into emp02 values(1, 'master');
-- ORA-00001: 무결성 제약 조건(SCOTT.SYS_C004577)에 위배됩니다
/*
에러 발생시 사전 table에 자동 생성되어 저장된 이름으로 에러 메시지 확인 가능
1행에 오류:
ORA-00001: 무결성 제약 조건(SCOTT.SYS_C004577)에 위배됩니다
*/

select * from emp02;

-- 사용자 정의 제약조건 명명 방식 학습
--5. pk설정 : 선언 위치에 따른 구분 학습
drop table emp02;

-- 5-1. 컬럼 레벨 단위로 설정하는 방식
create table emp02(
	empno number(4) constraint emp02_empno_pk primary key,
	ename varchar2(10) not null
);

insert into emp02 values(1, 'asdf');
insert into emp02 values(1, 'asdf'); -- 무결성 에러
/*
1행에 오류:
ORA-00001: 무결성 제약 조건(SCOTT.EMP02_EMPNO_PK)에 위배됩니다
*/

select * from emp02;

-- 5-2. 테이블 레벨 단위로 설정하는 방식
create table emp02(
	empno number(4),
	ename varchar2(10) not null,
	constraint emp02_empno_pk primary key(empno)
);

insert into emp02 values(1, 'asdf');
insert into emp02 values(1, 'asdf');
/*
1행에 오류:
ORA-00001: 무결성 제약 조건(SCOTT.EMP02_EMPNO_PK)에 위배됩니다
*/

select * from emp02;

-- ? emp02_empno_pk 이름의 정보는 user_constraint 라는 딕셔너리 테이블에 저장
-- 이 테이블에서 해당 정보가 삭제되는 시점은 table이 drop될 때

select constraint_name, constraint_type, table_name
from user_constraints where table_name='EMP02';
-- empno는 pk, 재약조건명 명시
-- ename은 not null, 제약조건명 없음
-- empno : EMP02_EMPNO_PK, 타입 P
-- ename : SYS_C004578 오라클이 자체적으로 이름 부여, 타입 C

--6. 외래키[참조키]
-- 이미 제약 조건이 설정된 dept table의 pk컬럼인 deptno값을 기준으로
-- emp02의 deptno에도 반영(참조키, 외래키, fk)
-- 6-1. 컬럼 레벨 단위 설정
drop table emp02;
create table emp02(
	empno number(4) constraint emp02_empno_pk primary key,
	ename varchar2(10) not null,
	deptno number(2) constraint emp02_deptno_fk references dept (deptno)
);

insert into emp02 values(1, 'asdf', 10);
insert into emp02 values(2, 'asdf', 70); --에러
--1행에 오류:
--ORA-02291: 무결성 제약조건(SCOTT.EMP02_DEPTNO_FK)이 위배되었습니다- 부모 키가 없습니다
select * from emp02;

-- 6-2. 테이블 레벨 단위 설정
drop table emp02;
create table emp02(
	empno number(4) constraint emp02_empno_pk primary key,
	ename varchar2(10) not null,
	deptno number(2),
	constraint emp02_deptno_fk foreign key (deptno) references dept (deptno)
);

insert into emp02 values(1, 'asdf', 10);
-- insert into emp02 values(2, 'master', 60);
/*
1행에 오류:
ORA-02291: 무결성 제약조건(SCOTT.EMP02_DEPTNO_FK)이 위배되었습니다- 부모 키가 없습니다
*/
select * from emp02;

--7. 6번의 내용을 table 레벨 단위로 설정해 보기
drop table emp02;
create table emp02(
	empno number(4) ,
	ename varchar2(10) not null,
	deptno number(2),
	constraint emp02_empno_pk primary key(empno),
	constraint emp02_deptno_fk foreign key (deptno) references dept (deptno)
);

insert into emp02 values(1, 'tester', 10);
-- 오류 : insert into emp02 values(2, 'master', 60);
select * from emp02;

--8. emp01과 dept01 table 생성

drop table dept01;
drop table emp01;
create table dept01 as select * from dept;
create table emp01 as select * from emp;

-- 제약 조건 없음
select table_name, constraint_type, constraint_name
from user_constraints 
where table_name='DEPT01';
select table_name, constraint_type, constraint_name
from user_constraints 
where table_name='EMP01';

--9. 이미 존재하는 table에 제약조건 추가하는 명령어 
-- dept와 emp처럼 dept01, emp01에 제약조건 추가

alter table dept01 add constraint dept01_deptno_pk primary key (deptno);
select table_name, constraint_type, constraint_name
from user_constraints 
where table_name='DEPT01';

-- ? emp01에 제약조건 추가해 보기

alter table emp01 add constraint emp01_deptno_fk foreign key (deptno) references dept01(deptno);
select table_name, constraint_type, constraint_name
from user_constraints 
where table_name='EMP01';

select table_name, constraint_type, constraint_name
from user_constraints 
where table_name='DEPT01';

--10. 참조 당하는 key의 컬럼이라 하더라도 자식 table에서 미 사용되는 데이터에 한해서는
	-- 삭제 가능  
-- emp01이 이미 참조하는 데이터가 있는 dept01 table 삭제해보기 

--dept table에서 deptno 40은 소속 사원 ㄴㄴ
select * from emp01;
select * from dept01;

delete from dept01 where deptno = 40;
-- delete from dept01 where deptno = 30;
/*
1행에 오류:
ORA-02292: 무결성 제약조건(SCOTT.EMP01_DEPTNO_FK)이 위배되었습니다- 자식 레코드가 발견되었습니다
*/

--11.참조되는 자식이 부모의 특정  컬럼을 사용한다(참조) 하더라도 삭제 가능한 명령어
	-- *** 현업에선 부득이하게 이미 개발중에 table 구조를 변경해야 할 경우가 간혹 발생
	-- 자식 존재 유무 완전 무시하고 부모 table삭제 
drop table dept01 cascade constraint;

--12. check : if 조건식과 같이 저장 직전의 데이터의 유효 유무 검증하는 제약조건 
-- age값이 1~100까지만 DB에 저장
drop table emp01;

create table emp01(
	ename varchar2(10),
	age number(3) constraint emp01_age_check check(age between 1 and 100)
);

-- insert into emp01 values('master', 10);
-- 에러 발생 : 1~100까지만 유효 
/*1행에 오류:
ORA-02290: 체크 제약조건(SCOTT.EMP01_AGE_CHECK)이 위배되었습니다
*/
insert into emp01 values('master', 102);

select * from emp01;
select table_name, constraint_type, constraint_name
	from user_constraints where table_name='EMP01';


-- 13.? gender라는 컬럼에는 데이터가 M 또는(or) F만 저장되어야 함
drop table emp01;

create table emp01(
	ename varchar2(10),
	gender char(1) constraint emp01_gender_check check (gender in('M','F'))
);

insert into emp01 values('master', 'F');
-- 오류 : insert into emp01 values('master', 'T'); 
/*1행에 오류:
ORA-02290: 체크 제약조건(SCOTT.EMP01_GENDER_CHECK)이 위배되었습니다
*/
select * from emp01;

--14. default : insert시에 데이터를 생략해도 자동으로 db에 저장되는 기본값 
drop table emp01;

create table emp01(
	id varchar2(10),
	gender varchar2(1) default 'M'
);

insert into emp01 (id) values('master');
insert into emp01 values('tester', 'M');
select * from emp01;

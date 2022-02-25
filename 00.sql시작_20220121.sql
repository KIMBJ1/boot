-- oracle db
-- --:oracle db 단일 라인 주석, /* */ 블록 주석 / # : properties / // /* */ : java

-- 1. sqlplus tool 특징
/*
1. 접속 방식 > sqlplus id/pw
2. sqlplus 창 검색시 보기 좋게 라인 및 가로 너비 조절명령어 사용해서 보기 좋게 검색
    set linesize 200
    set pagesize 200
*/

-- 2. select 문장 학습 - 학습용 table 활용해서 데이터 검색
/*
1. SCOTT/TIGER 계정에서 사용가능한 제공받은 table
    1. emp - 사원 정보 table
        1. empno : 사번 (PK : 중복 불가 / 검색 기준 데이터 / 핵심 데이터 / not null)
        2. ename : 사원명
        3. job : 어무
        4. mgr : 상사의 사번
        5. hiredate : 입사일
        6. sal : 월 급여
        7. comm : 보너스(sale 영업부 직무만 있음)
        8. deptno : 소속 부서 번호
            - dept table의 ddeptno에 종속적인 컬럼 데이터
            - deptno 컬럼을 기준으로 emp table을 dept table 의 자식 table
            - dept는 emp table 의 부모 table
            - deptno가 외부 table 을 참조 - FK, 외래키
    2. dept - 부서 정보 table
        1. deptno : 부서 번호 (PK)
        2. dname : 부서명
        3. loc : 부서 위치
    3. salgrade - 급여 등급 table
        1. grade : 등급
        2. losal : 최저금액
        3. hisal : 최고금액
*/

-- 3. table의 구조 확인(검색) 명령어
/*
DB 데이터 타입
1.  table 생성 시점에 타입 지정(정해진 타입의 데이터만 저장 가능)
2. 타입 종류
    1. 문자열
        1. 동적 사이즈 - 큰 문자열 작은 문자열에 맞게 메모리 활용
            varchar2(최대사이즈)
                - 문자열 크기만큼 최대 사이즈를 초과 시키지 않는 범위내에서 저장
        2. 고정 사이즈
            char(고정사이즈)
                - 문자열 크기와 무관하게 고정 사이즈 메모리 저장
                - 단 초과된 크기로 저장 시도하면 에러
                - ex)
                    늘 고정된 데이터
                        남/여 char(4바이트)
                        M/F char(1바이트)
    2. 숫자
        1. 정수
            number(정수 자릿수 크기)
                3 or 99 저장 : number(2)
        2. 실기
            number(정수 자릿수 크기, 소수점 이하 자릿수)
            3.5 or 99.12 저장 : number(4,2)
    3. 날짜
        1. date
*/
desc emp;
desc dept;
desc salgrade;

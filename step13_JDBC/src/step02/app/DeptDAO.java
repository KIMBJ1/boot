/* 학습 내용
 * 1. 중복 코드 분리
 * 2. 최적의 구조로 변환
 * 3. 최적의 코드로 개선 : 리팩토링
 * 4. DAO 클래스로 개발
 * 
 * DBUtil.java - 모든 DAO들이 공유하는 로직으로만 구성
 * JDBCTest3 -> DeptDAO로 변경
 */
package step02.app;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import util.DBUtil_original;

public class DeptDAO {

	public static void main(String[] args) {
//		insert();
		try {
			select();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/* 현업 개발자
	 * parameter 즉 insert하는 데이터는 브라우저에서 입력받는 가변적인 데이터
	 * 
	 * 설계 1 - 컬럼 수 만큼 즉 insert하려는 데이터수만큼 parameter 선언
	 * 설계 2 - DTO 형식으로 parameter 선언 ************************************ 권장
	 * 	단, pk 하나 값으로 하나의 컬럼값 수정시에는 두개의 parameter값 선언이 더 적합
	 * 
	 * 고려사항
	 * ☆★☆ 정상 저장  or 비정상 저장에 대한 모든 상황은 client는 알아야 함
	 * 	deptno가 중복되었다는 메세지는 당연히 client가 알아야 할 상황
	 * 	db 접속 문제(서버 내부 문제 발생시)일 경우 유연하게 신뢰를 떨어뜨리지 않는 범위내에서 재시도 유도
	 * 
	 * 결론
	 * 	DAO의 crud메소드는 예외를 throws로 던짐
	 * 		controller에서 예외 발생시 fail view화면으로 정상 응답 처리
	 * 
	 * 1. 정상 저장
	 * 	- 새로운 데이터 저장
	 * 2. 비정상 실행
	 * 	- 예외 발생
	 * 		db 접속 문제 / idpw 틀렸거나 / pk 중복 / ...
	 */
	public static void insert() {
		// try 블록내에서 선언된 변수는 try 외부에서 사용 불가 -> finally에서 사용 안되니까 try밖에서 선언
		Connection con = null;
		Statement stmt = null;
		try {
			con = DBUtil_original.getConnection();
			stmt = con.createStatement();
			int rset = stmt.executeUpdate("insert into dept values(60, 'a', 'b')");
			System.out.println(rset + " 행 저장 성공");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil_original.close(con, stmt);
		}
	}

	public static void select() throws Exception{
		Connection con = null;
		Statement stmt = null;
		ResultSet rset = null;
		try {
			con = DBUtil_original.getConnection();
			stmt = con.createStatement();
			rset = stmt.executeQuery("select * from dept");
			while (rset.next()) {
				System.out.println(rset.getInt("deptno") + "\t" + rset.getString("dname") + "\t" + rset.getString("loc"));
			}
		} catch (Exception e) {
			e.printStackTrace(); //상세 정보 확인을 위한 코드
			throw e; //catch 블록 생략과 동일
		}finally {
			DBUtil_original.close(con, stmt, rset);
		}
	}
}

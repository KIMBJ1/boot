/* oracle 접속 db 연동코드를 mysql db접속 코드로 변환
 * 1. driver를 build path에 추가
 * 2. 로딩 ~ 자원반환 코드 일부 수정
 * 3. 힌트
 * database이름은 playdata
 * 4. insert update delete 추가 구현방식 학습
 */
package step01.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCTest2 {
	
	public static void main(String[] args) {
//		insert();
		select();
	}

	// 특정 데이터를 메소드 내부에 구성해서 저장
	public static void insert() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://mydb1.c3ssvhrfvzlu.ap-northeast-2.rds.amazonaws.com:3306/playdata?serverTimezone=UTC";
			Connection con = DriverManager.getConnection(url, "encore", "playdata");
			Statement stmt = con.createStatement();
			// sql 문장 실행
			int rset = stmt.executeUpdate("insert into dept values(60, 'a', 'b')");
			System.out.println(rset + " 행 저장 성공");
			
			// 자원 반환 - ResultSet -> Statement -> Connection 순서로 반환
			stmt.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void select () {
		try {
			// driver 로딩
			Class.forName("com.mysql.cj.jdbc.Driver");
			// 접속
			String url = "jdbc:mysql://mydb1.c3ssvhrfvzlu.ap-northeast-2.rds.amazonaws.com:3306/playdata?serverTimezone=UTC";
			// oracle 접속 객체
			Connection con = DriverManager.getConnection(url, "encore", "playdata");
			// oracle 하고만 소통하는 문장 실행 객체
			Statement stmt = con.createStatement();
			ResultSet rset = stmt.executeQuery("select * from dept");
			// 실행 결과 활용
			while(rset.next()) {
				System.out.println(rset.getInt("deptno") + "\t" + rset.getString("dname") + "\t" + rset.getString("loc"));
			}
			// 자원 반환 - ResultSet -> Statement -> Connection 순서로 반환
			rset.close();
			stmt.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

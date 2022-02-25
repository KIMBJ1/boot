/* dept table 검색
 * 부정적인 경우의 수
 * 1. driver 로딩시 없을 수 있음
 * 	- ClassNotFoundException
 * 2. ip / id / pw 오류 - 접속 오류 SQLException
 * 3. sql 문법 오류...
 * 4. sql 문법은 맞으나 무결성 문제 등 발생 - sql 오류 SQLException
 */
package step01.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCTest1 {

	public static void main(String[] args) {
		try {
			// driver 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			// 접속
			String url = "http:oracle:thin:@localhost:1521:xe";
			
			// oracle 접속 객체
			Connection con = DriverManager.getConnection(url, "SCOTT", "TIGER");
			
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

package probono.model.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.io.FileReader;
import java.sql.DriverManager;
import java.util.Properties;
//두개의 Properties 객체 필요
//DB 정보 & sql 문장만 보유한 객체

public class DBUtil {
	// db의 설정 정보를 보유한 객체
	private static Properties dbInfo = new Properties();
//		static static Properties sql = new Properties();
	static {
		try {
//				1단계
//				Class.forName("com.mysql.cj.jdbc.Driver");

//				2단계
			dbInfo.load(new FileReader("src/db.properties"));
			Class.forName(dbInfo.getProperty("jdbc.driver"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 절대 공유해서는 안되는 객체/요청시 마다 새로 생성해서 제공
	// 접속 성공시 Connection 객체 반환/접속 실패시 예외 발생
	/*
	 * 예외 처리는 문제가 생기면 반드시 호출한곳에서도 상황 파악 필수 try~catch로 예외 처리보다 throws로 상황에 대한 알림으로도
	 * 사용
	 * 
	 * 메소드 body {} 1. throw new Exception생성시 필수 2. 예외 처리 없이 발생된 예외를 호출한 곳으로 던지고자 할
	 * 경우에도 catch 블록 내부에서 throw 예외변수;로 처리 하기도 함
	 * 
	 * 
	 */
	public static Connection getConnection() throws SQLException {
//			방법 1
//			      String url = "jdbc:mysql://mydb1.c3ssvhrfvzlu.ap-northeast-2.rds.amazonaws.com:3306/playdata?serverTimezone=UTC";
//			      다른 user들과 공유 불가
//			      return DriverManager.getConnection(url, "encore", "playdata");
//			방법 2
		return DriverManager.getConnection(dbInfo.getProperty("jdbc.url"), dbInfo.getProperty("jdbc.id"),
				dbInfo.getProperty("jdbc.pw"));
	}

	public static void main(String[] args) {
		try {
			System.out.println(getConnection());
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	// 모든 DAO 클래스들의 모든 메소드가 반드시 실행하는 자원반환 로직의 메소드
	// select - ResultSet -> Statement -> Connection순
	public static void close(Connection con, Statement stmt, ResultSet rset) {
		try {
			if (rset != null) {
				rset.close();
				rset = null;
			}
			if (stmt != null) {
				stmt.close();
				stmt = null;
			}
			if (con != null) {
				con.close();
				con = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// insert/update/delete -> Statement -> Connection순
	public static void close(Connection con, Statement stmt) {
		try {
			if (stmt != null) {
				stmt.close();
				stmt = null;
			}
			if (con != null) {
				con.close();
				con = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
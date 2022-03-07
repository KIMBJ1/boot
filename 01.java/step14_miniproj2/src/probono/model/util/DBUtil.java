package probono.model.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.io.FileReader;
import java.sql.DriverManager;
import java.util.Properties;
//�ΰ��� Properties ��ü �ʿ�
//DB ���� & sql ���常 ������ ��ü

public class DBUtil {
	// db�� ���� ������ ������ ��ü
	private static Properties dbInfo = new Properties();
//		static static Properties sql = new Properties();
	static {
		try {
//				1�ܰ�
//				Class.forName("com.mysql.cj.jdbc.Driver");

//				2�ܰ�
			dbInfo.load(new FileReader("src/db.properties"));
			Class.forName(dbInfo.getProperty("jdbc.driver"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// ���� �����ؼ��� �ȵǴ� ��ü/��û�� ���� ���� �����ؼ� ����
	// ���� ������ Connection ��ü ��ȯ/���� ���н� ���� �߻�
	/*
	 * ���� ó���� ������ ����� �ݵ�� ȣ���Ѱ������� ��Ȳ �ľ� �ʼ� try~catch�� ���� ó������ throws�� ��Ȳ�� ���� �˸����ε�
	 * ���
	 * 
	 * �޼ҵ� body {} 1. throw new Exception������ �ʼ� 2. ���� ó�� ���� �߻��� ���ܸ� ȣ���� ������ �������� ��
	 * ��쿡�� catch ��� ���ο��� throw ���ܺ���;�� ó�� �ϱ⵵ ��
	 * 
	 * 
	 */
	public static Connection getConnection() throws SQLException {
//			��� 1
//			      String url = "jdbc:mysql://mydb1.c3ssvhrfvzlu.ap-northeast-2.rds.amazonaws.com:3306/playdata?serverTimezone=UTC";
//			      �ٸ� user��� ���� �Ұ�
//			      return DriverManager.getConnection(url, "encore", "playdata");
//			��� 2
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

	// ��� DAO Ŭ�������� ��� �޼ҵ尡 �ݵ�� �����ϴ� �ڿ���ȯ ������ �޼ҵ�
	// select - ResultSet -> Statement -> Connection��
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

	// insert/update/delete -> Statement -> Connection��
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
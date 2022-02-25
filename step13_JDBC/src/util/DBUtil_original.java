// ��� DAO�� ���������� ���Ǵ� �ڵ��θ� ������ ������ ����
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil_original {
	/* static {} - �� �ѹ� ���� 100% ����
	 * - �̸��� �����ϱ� ȣ�� �Ұ�
	 * - �������� �����ϴ� �ڿ��� �ѹ��� �ʱ�ȭ �ϰ��� �ϴ� �������� ����
	 */
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	//���� �����ϸ� �ȵǴ� ��ü , ��û�ø��� ���� �����ؼ� ����
	/* ���� ó���� ������ ����� �ݵ�� ȣ���� �������� ��Ȳ �ľ� �ʼ�
	 * try~catch�� ����ó������ throws�� ��Ȳ�� ���� �˸����ε� ���
	 * 
	 * �޼ҵ� body{}
	 * throw new Exception ������ �ʼ�
	 * ���� ó�� ���� �߻��� ���ܸ� ȣ���� ������ �������� �� ���
	 * catch ��� ���ο��� throw ���ܺ���; �� ó�� ����
	 */
	// ���� ������ Connection ��ü ��ȯ / ���� ���н� ���� �߻�
	public static Connection getConnection() throws SQLException {
		String url = "jdbc:mysql://mydb1.c3ssvhrfvzlu.ap-northeast-2.rds.amazonaws.com:3306/playdata?serverTimezone=UTC";
		// �ٸ� user��� ���� �Ұ�
		return DriverManager.getConnection(url, "encore", "playdata");
	}

	// ��� DAO Ŭ�������� ��� �޼ҵ尡 �ݵ�� �����ϴ� �ڿ� ��ȯ ������ �޼ҵ�
	// select - ResultSet -> Statement -> Connection ������ �ڿ� ��ȯ
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
	// insert update delte - Statement -> Connection ������ �ڿ� ��ȯ
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

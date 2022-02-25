// ��� DAO�� ���������� ���Ǵ� �ڵ��θ� ������ ������ ����
/* Properties ��ü ���� ��ġ?
 * ��� ����? ���� ����? ***************** ����� ����
 * �� ��ü�� �뵵
 * 	properties�� ������ ����
 * 	static{} : driver ���� Ȱ��
 * 	getConnection() : url / id / pw ���� Ȱ��
 */
package util;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DBUtil {
	static Properties dbInfo = new Properties();
	/* static {} - �� �ѹ� ���� 100% ����
	 * - �̸��� �����ϱ� ȣ�� �Ұ�
	 * - �������� �����ϴ� �ڿ��� �ѹ��� �ʱ�ȭ �ϰ��� �ϴ� �������� ����
	 */
	static {
		try {
			dbInfo.load(new FileReader("src/dbinfo.properties"));
			Class.forName(dbInfo.getProperty("jdbc.driver"));
		} catch (Exception e) {
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
		// �ٸ� user��� ���� �Ұ�
		return DriverManager.getConnection(dbInfo.getProperty("jdbc.url"), dbInfo.getProperty("jdbc.id"), dbInfo.getProperty("jdbc.pw"));
	}

//	public static void main(String[] args) {
//		try {
//			System.out.println(getConnection());
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
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

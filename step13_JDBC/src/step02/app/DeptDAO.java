/* �н� ����
 * 1. �ߺ� �ڵ� �и�
 * 2. ������ ������ ��ȯ
 * 3. ������ �ڵ�� ���� : �����丵
 * 4. DAO Ŭ������ ����
 * 
 * DBUtil.java - ��� DAO���� �����ϴ� �������θ� ����
 * JDBCTest3 -> DeptDAO�� ����
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

	/* ���� ������
	 * parameter �� insert�ϴ� �����ʹ� ���������� �Է¹޴� �������� ������
	 * 
	 * ���� 1 - �÷� �� ��ŭ �� insert�Ϸ��� �����ͼ���ŭ parameter ����
	 * ���� 2 - DTO �������� parameter ���� ************************************ ����
	 * 	��, pk �ϳ� ������ �ϳ��� �÷��� �����ÿ��� �ΰ��� parameter�� ������ �� ����
	 * 
	 * �������
	 * �١ڡ� ���� ����  or ������ ���忡 ���� ��� ��Ȳ�� client�� �˾ƾ� ��
	 * 	deptno�� �ߺ��Ǿ��ٴ� �޼����� �翬�� client�� �˾ƾ� �� ��Ȳ
	 * 	db ���� ����(���� ���� ���� �߻���)�� ��� �����ϰ� �ŷڸ� ����߸��� �ʴ� ���������� ��õ� ����
	 * 
	 * ���
	 * 	DAO�� crud�޼ҵ�� ���ܸ� throws�� ����
	 * 		controller���� ���� �߻��� fail viewȭ������ ���� ���� ó��
	 * 
	 * 1. ���� ����
	 * 	- ���ο� ������ ����
	 * 2. ������ ����
	 * 	- ���� �߻�
	 * 		db ���� ���� / idpw Ʋ�Ȱų� / pk �ߺ� / ...
	 */
	public static void insert() {
		// try ��ϳ����� ����� ������ try �ܺο��� ��� �Ұ� -> finally���� ��� �ȵǴϱ� try�ۿ��� ����
		Connection con = null;
		Statement stmt = null;
		try {
			con = DBUtil_original.getConnection();
			stmt = con.createStatement();
			int rset = stmt.executeUpdate("insert into dept values(60, 'a', 'b')");
			System.out.println(rset + " �� ���� ����");
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
			e.printStackTrace(); //�� ���� Ȯ���� ���� �ڵ�
			throw e; //catch ��� ������ ����
		}finally {
			DBUtil_original.close(con, stmt, rset);
		}
	}
}

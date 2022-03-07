package step01.basic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

import org.junit.Test;

import model.domain.DeptDTO;
import util.DBUtil;

public class JDBCTest3 {

//	public void insertDept(DeptDTO dto){
	// parameter 3���ۿ� ��� �� ���� ����
	public void insertDept(int deptno, String dname, String loc) {
		Connection con = null;
		Statement stmt = null;
		
		try {
			con = DBUtil.getConnection();
			stmt = con.createStatement();
			// insert into dept values(����, '��', '��2');
			int result = stmt.executeUpdate("insert into dept values (" + deptno + ", '" + dname + "', '" + loc + "')");
			System.out.println(result + " �� �Է�");
			
			stmt.close();
			con.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			DBUtil.close(con, stmt);
		}
	}
	/* step2
	 * 	- insert update delete�ÿ� ������ ǥ���� ���� ���⽺���� �ڵ� ��İ� ���� �ӵ� ����� ���� ���� ���
	 * 
	 * ����
	 *	Statement�� sql ���� �����
	 *		���ึ�� db�� sql���� �м� �� ���� �� db �� �°� ��ȯ�ؼ� ����
	 *	PreparedStatement�� sql ���� �����
	 *		ù �����db�� sql���� �м� �� ���� �� db �� �°� ��ȯ�ؼ� ���� �� ����
	 *		�ι�° ���� ���ʹ� �̹� �����ϴ� ��ȯ�� �ڿ����� ����
	 * 
	 * 	- ���� ���
	 * 		Statement�� ��ӹ޴� PreparedStatement API ���
	 * 			- ��ü ���� ������ ���� sql �������� ����
	 * 			- executeUpdate()���� ���� ����
	 */
	public void insertDept2(int deptno, String dname, String loc) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = DBUtil.getConnection();
			// �� ���ܵ� ���� sql �������� ��ü ����
			pstmt = con.prepareStatement("insert into dept values(?, ?, ?)");
			// sql �� ����
			pstmt.setInt(1,  deptno);
			pstmt.setString(2, dname);
			pstmt.setString(3, loc);
			// ���� �ִ� insert sql ���� ����
			int result = pstmt.executeUpdate();
			System.out.println(result + " �� �Է�");
			
			pstmt.close();
			con.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			DBUtil.close(con, pstmt);
		}
	}
	
	/* step3
	 * 1. DTO Ÿ���� parameter�� ����
	 */
	public void insertDept3(DeptDTO dept) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = DBUtil.getConnection();
			// �� ���ܵ� ���� sql �������� ��ü ����
			pstmt = con.prepareStatement("insert into dept values(?, ?, ?)");
			// sql �� ����
			pstmt.setInt(1, dept.getDeptno());
			pstmt.setString(2, dept.getDname());
			pstmt.setString(3, dept.getLoc());
			// ���� �ִ� insert sql ���� ����
			int result = pstmt.executeUpdate();
			System.out.println(result + " �� �Է�");
			
			pstmt.close();
			con.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			DBUtil.close(con, pstmt);
		}
	}
	@Test
	public void insertTest() {
//		insertDept(63, "�λ��", "����");
//		insertDept2(63, "�λ��", "����");
		insertDept3(new DeptDTO(655, "�λ��", "����"));
	}
}

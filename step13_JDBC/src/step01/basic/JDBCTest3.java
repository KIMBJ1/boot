package step01.basic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

import org.junit.Test;

import model.domain.DeptDTO;
import util.DBUtil;

public class JDBCTest3 {

//	public void insertDept(DeptDTO dto){
	// parameter 3개밖에 없어서 걍 따로 받음
	public void insertDept(int deptno, String dname, String loc) {
		Connection con = null;
		Statement stmt = null;
		
		try {
			con = DBUtil.getConnection();
			stmt = con.createStatement();
			// insert into dept values(숫자, '값', '값2');
			int result = stmt.executeUpdate("insert into dept values (" + deptno + ", '" + dname + "', '" + loc + "')");
			System.out.println(result + " 행 입력");
			
			stmt.close();
			con.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			DBUtil.close(con, stmt);
		}
	}
	/* step2
	 * 	- insert update delete시에 데이터 표현에 따른 번잡스러운 코딩 방식과 실행 속도 향상을 위한 개발 방식
	 * 
	 * 참고
	 *	Statement로 sql 문장 실행시
	 *		실행마다 db가 sql문장 분석 및 검증 후 db 에 맞게 변환해서 실행
	 *	PreparedStatement로 sql 문장 실행시
	 *		첫 실행시db가 sql문장 분석 및 검증 후 db 에 맞게 변환해서 보관 및 실행
	 *		두번째 실행 부터는 이미 존재하는 변환된 자원으로 실행
	 * 
	 * 	- 개발 방식
	 * 		Statement를 상속받는 PreparedStatement API 사용
	 * 			- 객체 생성 시점에 고정 sql 문장으로 생성
	 * 			- executeUpdate()전에 값만 대입
	 */
	public void insertDept2(int deptno, String dname, String loc) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = DBUtil.getConnection();
			// 값 제외된 고정 sql 문장으로 객체 생성
			pstmt = con.prepareStatement("insert into dept values(?, ?, ?)");
			// sql 값 대입
			pstmt.setInt(1,  deptno);
			pstmt.setString(2, dname);
			pstmt.setString(3, loc);
			// 값이 있는 insert sql 문장 실행
			int result = pstmt.executeUpdate();
			System.out.println(result + " 행 입력");
			
			pstmt.close();
			con.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			DBUtil.close(con, pstmt);
		}
	}
	
	/* step3
	 * 1. DTO 타입을 parameter로 적용
	 */
	public void insertDept3(DeptDTO dept) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = DBUtil.getConnection();
			// 값 제외된 고정 sql 문장으로 객체 생성
			pstmt = con.prepareStatement("insert into dept values(?, ?, ?)");
			// sql 값 대입
			pstmt.setInt(1, dept.getDeptno());
			pstmt.setString(2, dept.getDname());
			pstmt.setString(3, dept.getLoc());
			// 값이 있는 insert sql 문장 실행
			int result = pstmt.executeUpdate();
			System.out.println(result + " 행 입력");
			
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
//		insertDept(63, "인사과", "서초");
//		insertDept2(63, "인사과", "서초");
		insertDept3(new DeptDTO(655, "인사과", "서초"));
	}
}

/*
 * CREATE TABLE probono (
       probono_id           	VARCHAR2(50) PRIMARY KEY,
       probono_name     	VARCHAR2(50) NOT NULL,
       probono_purpose  VARCHAR2(200) NOT NULL
);  */
package probono.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import probono.model.dto.ProbonoDTO;
import probono.model.util.DBUtil;

public class ProbonoDAO {	
	
	//����
	public static boolean addProbono(ProbonoDTO probono) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("insert into probono values(?, ?, ?)");
			pstmt.setString(1, probono.getProbonoId());
			pstmt.setString(2, probono.getProbonoName());
			pstmt.setString(3, probono.getProbonoPurpose());
			
			int result = pstmt.executeUpdate();
		
			if(result == 1){
				return true;
			}
			
		}catch(SQLException s){
			s.printStackTrace();
			throw s;
		}finally{
			DBUtil.close(con, pstmt);
		}
		return false;
	}

	//����
	//���κ��� id�� ���κ��� ���� �����ϱ�
	public static boolean updateProbono(String probonoId, String probonoPurpose) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("update probono set probono_purpose=? where probono_id=?");
			pstmt.setString(1, probonoPurpose);
			pstmt.setString(2, probonoId);
			
			int result = pstmt.executeUpdate();
			if(result == 1){
				return true;
			}
		}catch(SQLException s){
			s.printStackTrace();
			throw s;
		}finally{
			DBUtil.close(con, pstmt);
		}
		return false;
	}


	//���� 
	public static boolean deleteProbono(String probonoId) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("delete from probono where probono_id=?");
			pstmt.setString(1, probonoId);
			int result = pstmt.executeUpdate();
			if(result == 1){
				return true;
			}
		}catch(SQLException s){
			s.printStackTrace();
			throw s;
		}finally{
			DBUtil.close(con, pstmt);
		}
		return false;
	}
	
	//�������� ���̵�� �ش� ���κ��� ��� ���� �˻�
	public static ProbonoDTO getProbono(String probonoId) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ProbonoDTO probono = null;
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select * from probono where probono_id=?");
			pstmt.setString(1, probonoId);
			rset = pstmt.executeQuery();
			if(rset.next()){
				probono = new ProbonoDTO(rset.getString(1), rset.getString(2), rset.getString(3));
			}
		}catch(SQLException s){
			s.printStackTrace();
			throw s;
		}finally{
			DBUtil.close(con, pstmt, rset);
		}
		return probono;
	}

	//��� ���κ��� �˻�
	public static ArrayList<ProbonoDTO> getAllProbonos() throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<ProbonoDTO> list = null;
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select * from probono");
			rset = pstmt.executeQuery();
			
			list = new ArrayList<ProbonoDTO>();
			while(rset.next()){
				list.add(new ProbonoDTO(rset.getString(1), rset.getString(2), rset.getString(3)) );
			}
		}catch(SQLException s){
			s.printStackTrace();
			throw s;
		}finally{
			DBUtil.close(con, pstmt, rset);
		}
		return list;
	}
}

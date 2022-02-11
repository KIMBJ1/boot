/*
fanclub_id VARCHAR2(20) PRIMARY KEY,
name VARCHAR2(20) NOT NULL,
fanclub_old VARCHAR2(20) NOT NULL,
application VARCHAR2(20) NOT NULL,
fanclub_size VARCHAR2(50) NOT NULL
*/
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.dto.FanclubDTO;
import model.util.DBUtil;

public class FanclubDAO {

	public static boolean addFanclub(FanclubDTO fanclub) throws SQLException {

		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("insert into fanclub values(?, ?, ?, ?)");
			pstmt.setString(1, fanclub.getFanclub_id());
			pstmt.setString(2, fanclub.getName());
			pstmt.setString(3, fanclub.getFanclub_old());
			pstmt.setString(4, fanclub.getApplication());
			pstmt.setString(5, fanclub.getFanclub_size());

			int result = pstmt.executeUpdate();

			if (result == 1) {
				return true;
			}
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}

	// 수정
	// fanclub_id로 주요 팬클럽 정보 수정
	public static boolean updateFanclub(String fanclub_id, String fanclub_size) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();

			pstmt = con.prepareStatement("update fanclub set fanclub_size=? where fanclub_id=?");
			pstmt.setString(1, fanclub_size);
			pstmt.setString(2, fanclub_id);

			int result = pstmt.executeUpdate();
			if (result == 1) {
				return true;
			}
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}

	// 삭제
	// sql - delete from fanclub where fanclub_id=?
	public static boolean deleteFanclub(String fanclub_id) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("delete from fanclub where fanclub_id=?");
			pstmt.setString(1, fanclub_id);
			int result = pstmt.executeUpdate();
			if (result == 1) {
				return true;
			}
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}

	// id로 해당 팬클럽의 모든 정보 반환
	public static FanclubDTO getFanclub(String fanclub_id) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		FanclubDTO fanclub = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select * from fanclub where fanclub_id=?");
			pstmt.setString(1, fanclub_id);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				fanclub = new FanclubDTO(rset.getString(1), rset.getString(2), rset.getString(3), rset.getString(4), rset.getString(5));
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return fanclub;
	}

	// 모든 팬클럽 검색해서 반환
	public static ArrayList<FanclubDTO> getAllFanclubs() throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<FanclubDTO> list = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select * from fanclub");
			rset = pstmt.executeQuery();

			list = new ArrayList<FanclubDTO>();
			while (rset.next()) {
				list.add(new FanclubDTO(rset.getString(1), rset.getString(2), rset.getString(3), rset.getString(4), rset.getString(5)));
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return list;
	}

}

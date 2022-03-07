/*
singer_id VARCHAR2(20) PRIMARY KEY,
name VARCHAR2(20) NOT NULL,
age NUMBER(2) NOT NULL,
company VARCHAR2(20) NOT NULL,
debut_year number(5) NOT NULL
*/
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.dto.SingerDTO;
import model.util.DBUtil;

public class SingerDAO {

	public static boolean addSinger(SingerDTO singer) throws SQLException {

		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("insert into singer values(?, ?, ?, ?, ?)");
			pstmt.setString(1, singer.getSinger_id());
			pstmt.setString(2, singer.getName());
			pstmt.setInt(3, singer.getAge());
			pstmt.setString(4, singer.getCompany());
			pstmt.setInt(5, singer.getDebut_year());

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
	// singer_id로 주요 가수 정보 수정
	public static boolean updateSinger(String singer_id, String company) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();

			pstmt = con.prepareStatement("update singer set company=? where singer_id=?");
			pstmt.setString(1, company);
			pstmt.setString(2, singer_id);

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
	// sql - delete from singer where singer_id=?
	public static boolean deleteSinger(String singer_id) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("delete from singer where singer_id=?");
			pstmt.setString(1, singer_id);
			int result = pstmt.executeUpdate();
			if (result == 1) {
				return true;
			}
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}

	// id로 해당 가수의 모든 정보 반환
	public static SingerDTO getSinger(String singer_id) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		SingerDTO singer = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select * from singer where singer_id=?");
			pstmt.setString(1, singer_id);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				singer = new SingerDTO(rset.getString(1), rset.getString(2), rset.getInt(3), rset.getString(4), rset.getInt(5));
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return singer;
	}

	// 모든 가수 검색해서 반환
	public static ArrayList<SingerDTO> getAllSingers() throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<SingerDTO> list = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select * from singer");
			rset = pstmt.executeQuery();

			list = new ArrayList<SingerDTO>();
			while (rset.next()) {
				list.add(new SingerDTO(rset.getString(1), rset.getString(2), rset.getInt(3), rset.getString(4), rset.getInt(5)));
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return list;
	}

}

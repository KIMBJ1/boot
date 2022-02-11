/*
song_id VARCHAR2(50) PRIMARY KEY,
song_name VARCHAR2(50) NOT NULL
*/
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.dto.SongDTO;
import model.util.DBUtil;

public class SongDAO {

	public static boolean addSong(SongDTO song) throws SQLException {

		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("insert into song values(?, ?, ?, ?)");
			pstmt.setString(1, song.getSong_id());
			pstmt.setString(2, song.getSong_name());

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
	// song_id로 주요 노래 정보 수정
	public static boolean updateSong(String song_id, String song_name) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();

			pstmt = con.prepareStatement("update song set song_name=? where song_id=?");
			pstmt.setString(1, song_name);
			pstmt.setString(2, song_id);

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
	public static boolean deleteSong(String song_id) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("delete from song where song_id=?");
			pstmt.setString(1, song_id);
			int result = pstmt.executeUpdate();
			if (result == 1) {
				return true;
			}
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}

	// id로 해당 노래의 모든 정보 반환
	public static SongDTO getSong(String song_id) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		SongDTO song = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select * from song where song_id=?");
			pstmt.setString(1, song_id);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				song = new SongDTO(rset.getString(1), rset.getString(2));
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return song;
	}

	// 모든 노래 검색해서 반환
	public static ArrayList<SongDTO> getAllSongs() throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<SongDTO> list = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select * from song");
			rset = pstmt.executeQuery();

			list = new ArrayList<SongDTO>();
			while (rset.next()) {
				list.add(new SongDTO(rset.getString(1), rset.getString(2)));
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return list;
	}

}

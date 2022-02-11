/*
song_project_id varchar2(20) PRIMARY KEY,
song_project_name VARCHAR2(50) NOT NULL,
song_id VARCHAR2(50) NOT NULL,       
singer_id VARCHAR2(20) NOT NULL,
fanclub_id VARCHAR2(20) NOT NULL,
song_project_content VARCHAR2(100) NOT NULL
*/
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.dto.SongProjectDTO;
import model.util.DBUtil;

public class SongProjectDAO {

	public static boolean addSongProject(SongProjectDTO song) throws SQLException {

		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("insert into song values(?, ?, ?, ?)");
			pstmt.setInt(1, song.getSong_project_id());
			pstmt.setString(2, song.getSong_project_name());
			pstmt.setString(3, song.getSong_id());
			pstmt.setString(4, song.getSinger_id());
			pstmt.setString(5, song.getFanclub_id());
			pstmt.setString(6, song.getSong_project_content());

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
	// Song_project_id로 Song_project_content 정보 수정
	public static boolean updateSongProject(int Song_project_id, String Song_project_content) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();

			pstmt = con.prepareStatement("update song set Song_project_content=? where Song_project_id=?");
			pstmt.setString(1, Song_project_content);
			pstmt.setInt(2, Song_project_id);

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
	public static boolean deleteSongProject(int Song_project_id) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("delete from songproject where Song_project_id=?");
			pstmt.setInt(1, Song_project_id);
			int result = pstmt.executeUpdate();
			if (result == 1) {
				return true;
			}
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}

	// id로 해당 노래 프로젝트의 모든 정보 반환
	public static SongProjectDTO getSongProject(int Song_project_id) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		SongProjectDTO song = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select * from song where song_id=?");
			pstmt.setInt(1, Song_project_id);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				song = new SongProjectDTO(rset.getInt(1), rset.getString(2),rset.getString(3), rset.getString(4),rset.getString(5), rset.getString(6));
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return song;
	}

	// 모든 노래 프로젝트 검색해서 반환
	public static ArrayList<SongProjectDTO> getAllSongProjects() throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<SongProjectDTO> list = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select * from song_project");
			rset = pstmt.executeQuery();

			list = new ArrayList<SongProjectDTO>();
			while (rset.next()) {
				list.add(new SongProjectDTO(rset.getInt(1), rset.getString(2),rset.getString(3), rset.getString(4),rset.getString(5), rset.getString(6)));

			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return list;
	}

}

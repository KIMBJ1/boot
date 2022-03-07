package model;

import java.sql.SQLException;
import java.util.ArrayList;

import exception.MessageException;
import exception.NotExistException;
import model.dto.FanclubDTO;
import model.dto.SingerDTO;
import model.dto.SongDTO;
import model.dto.SongProjectDTO;

public class Service {

	private static final String String = null;

	//song - CRUD
	public static void notExistSong(String Song_id) throws NotExistException, SQLException{
		SongDTO song = SongDAO.getSong(Song_id);
		if(song == null){
			throw new NotExistException("검색하신 노래 정보가 없습니다.");
		}
	}
	//모든 song 정보 반환
	public static ArrayList<SongDTO> getAllSongs() throws SQLException{
		return SongDAO.getAllSongs();
	}
	//song id로 검색
	public static SongDTO getSong(String Song_id) throws SQLException, NotExistException{
		SongDTO song = SongDAO.getSong(Song_id);
		if(song == null){
			throw new NotExistException("검색하신 노래의 정보가 없습니다.");
		}
		return song;
	}
	//새로운 song 저장
	public static boolean addSong(SongDTO song) throws SQLException{
		return SongDAO.addSong(song);
	}
	//기존 song 수정
	public static boolean updateSong(String song_id, String song_name) throws SQLException, NotExistException{
		notExistSong(song_id);
		return SongDAO.updateSong(song_id, song_name);
	}
	//song 삭제
	public boolean deleteSong(String song_id) throws SQLException, NotExistException{
		notExistSong(song_id);
		return SongDAO.deleteSong(song_id);
	}
		
	
	
	//가수(Singer) - CRUD
	public static void notExistSinger(String Singer_id) throws NotExistException, SQLException{
		SingerDTO singer = SingerDAO.getSinger(Singer_id);
		if(singer == null){
			throw new NotExistException("검색하는 가수가 미존재합니다.");
		}
	}
	public static boolean addSinger(SingerDTO Singer) throws MessageException{
		boolean result = false;
		try{
			result = SingerDAO.addSinger(Singer);
		}catch(SQLException s){
			throw new MessageException("이미 존재하는 ID입니다 다시 시도 하세요");
		}
		return result;
	}
	
	//가수 수정 메소드[SingerDAO의 updateSinger()]
	public static boolean updateSinger(String singer_id, String company) throws SQLException, NotExistException{		
		notExistSinger(singer_id);
		boolean result = SingerDAO.updateSinger(singer_id, company);
		if(!result){
			throw new NotExistException("가수 정보 갱신 실패");
		}
		return result;
	}
	
	
	//가수 삭제 메소드[ SingerDAO.deleteSinger()]
	public static boolean deleteSinger(String singer_id) throws SQLException, NotExistException{
		notExistSinger(singer_id);
		boolean result = SingerDAO.deleteSinger(singer_id);
		if(!result){
			throw new NotExistException("가수 정보 삭제 실패");
		}
		return result;
	}
	
	public static SingerDTO getSinger(String Singer_id) throws SQLException, NotExistException{
		SingerDTO singer = SingerDAO.getSinger(Singer_id);
		if(singer == null){
			throw new NotExistException("검색하는 가수가 미 존재합니다.");
		}
		return singer;
	}
	
	public static ArrayList<SingerDTO> getAllSingers() throws SQLException{
		return SingerDAO.getAllSingers();
	}
	
	//팬클럽 - CRUD
	public static void notExistFanclub(String fanclub_id) throws NotExistException, SQLException{
		FanclubDTO fanclub = FanclubDAO.getFanclub(fanclub_id);
		if(fanclub == null){
			throw new NotExistException("검색하는 팬클럽이 미존재합니다.");
		}
	}
	public static boolean addfanclub(FanclubDTO fanclub) throws SQLException{
		return FanclubDAO.addFanclub(fanclub);
	}
	public boolean deleteFanclub(String fanclub_id) throws SQLException, NotExistException{
		notExistFanclub(fanclub_id);
		return FanclubDAO.deleteFanclub(fanclub_id);
	}
	public static FanclubDTO getFanclub(String fanclub_id) throws SQLException{
		return FanclubDAO.getFanclub(fanclub_id);
	}
	public static ArrayList<FanclubDTO> getAllFanclubs() throws SQLException{
		return FanclubDAO.getAllFanclubs();
	}
	
	//팬클럽 수정 메소드[SingerDAO의 updateSinger()]
		public static boolean updateFanclub(String fanclub_id, String fanclub_size) throws SQLException, NotExistException{		
			notExistFanclub(fanclub_id);
			boolean result = FanclubDAO.updateFanclub(fanclub_id, fanclub_size);
			if(!result){
				throw new NotExistException("팬클럽 정보 갱신 실패");
			}
			return result;
		}
	
	//SongProjectDAO - CRUD
	public static void notExistSongProject(int songprojectId ) throws NotExistException, SQLException{
		SongProjectDTO songproject = SongProjectDAO.getSongProject(songprojectId);
		if(songproject == null){
			throw new NotExistException("검색하는 노래 프로젝트가 미 존재합니다.");
		}
	}
	
	//새로운 Song Project 등록
	public static boolean addsongproject(SongProjectDTO songproject) throws SQLException{
		return SongProjectDAO.addSongProject(songproject);
	}
	//존재하는 Song Project의 내용 수정
	public static boolean updateSongProjectSinger(int songprojectId, String Song_project_content) throws SQLException, NotExistException{
		notExistSongProject(songprojectId);
		return SongProjectDAO.updateSongProject(songprojectId, Song_project_content);
	}
	
	//존재하는 Song Project의 ?? ? ? ? ? ?수정
	public static boolean updatesongprojectReceive(int songprojectId, String  receiveId) throws SQLException, NotExistException{
		notExistSongProject(songprojectId);
		return SongProjectDAO.updateSongProject(songprojectId, receiveId);
	}
	
	//존재하는 Song Project 삭제
	public static boolean deletesongproject(int songprojectId) throws SQLException, NotExistException{
		notExistSongProject(songprojectId);
		return SongProjectDAO.deleteSongProject(songprojectId);
	}
	
	//특정 Song Project 검색 
	public static SongProjectDTO getsongproject(int songprojectId) throws SQLException, NotExistException{
		SongProjectDTO songproject = SongProjectDAO.getSongProject(songprojectId);
		if(songproject == null){
			throw new NotExistException("검색하는 노래 프로젝트가 미 존재합니다.");
		}
		return songproject;
	}
	
	//모든 노래 Project 검색 
	public static ArrayList<SongProjectDTO> getAllsongprojects() throws SQLException,NotExistException{
		ArrayList<SongProjectDTO> songprojectAll = SongProjectDAO.getAllSongProjects();
	
		if(songprojectAll == null){
			throw new NotExistException("검색하는 재능기부 프로젝트가 미 존재합니다.");
		}
		
		return songprojectAll;
	}
}

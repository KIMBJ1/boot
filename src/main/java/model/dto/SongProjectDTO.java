package model.dto;

public class SongProjectDTO {
	private int song_project_id;
	private String song_project_name;
	private String song_id;
	private String singer_id;
	private String fanclub_id;
	private String song_project_content;
	
	public SongProjectDTO() {}
	
	public SongProjectDTO(int song_project_id, String song_project_name, String song_id, String singer_id, String fanclub_id, String song_project_content) {
		super();
		this.song_project_id = song_project_id;
		this.song_project_name = song_project_name;
		this.song_id = song_id;
		this.singer_id = singer_id;
		this.fanclub_id = fanclub_id;
		this.song_project_content = song_project_content;
	}
	public int getSong_project_id() {
		return song_project_id;
	}
	public void setSong_project_id(int song_project_id) {
		this.song_project_id = song_project_id;
	}
	public String getSong_project_name() {
		return song_project_name;
	}
	public void setSong_project_name(String song_project_name) {
		this.song_project_name = song_project_name;
	}
	public String getSong_id() {
		return song_id;
	}
	public void setSong_id(String song_id) {
		this.song_id = song_id;
	}
	public String getSinger_id() {
		return singer_id;
	}
	public void setSinger_id(String singer_id) {
		this.singer_id = singer_id;
	}
	public String getFanclub_id() {
		return fanclub_id;
	}
	public void setFanclub_id(String fanclub_id) {
		this.fanclub_id = fanclub_id;
	}
	public String getSong_project_content() {
		return song_project_content;
	}
	public void setSong_project_content(String song_project_content) {
		this.song_project_content = song_project_content;
	}
	@Override
	public String toString() {
		return "SongProject [song_project_id=" + song_project_id + ", song_project_name=" + song_project_name + ", song_id=" + song_id + ", singer_id=" + singer_id + ", fanclub_id=" + fanclub_id + ", song_project_content="
				+ song_project_content + "]";
	}
	
	
}

package model.dto;

public class SongDTO {
	private String song_id;
	private String song_name;
	
	public SongDTO() {}
	
	public SongDTO(String song_id, String song_name) {
		super();
		this.song_id = song_id;
		this.song_name = song_name;
	}
	public String getSong_id() {
		return song_id;
	}
	public void setSong_id(String song_id) {
		this.song_id = song_id;
	}
	public String getSong_name() {
		return song_name;
	}
	public void setSong_name(String song_name) {
		this.song_name = song_name;
	}
	@Override
	public String toString() {
		return "SongDTO [song_id=" + song_id + ", song_name=" + song_name + "]";
	}
	

}

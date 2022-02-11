package model.dto;

public class FanclubDTO {

	String fanclub_id;
	String name;
	String fanclub_old;
	String application;
	String fanclub_size;

	public FanclubDTO() {}

	public FanclubDTO(String fanclub_id, String name, String fanclub_old, String application, String fanclub_size) {
		super();
		this.fanclub_id = fanclub_id;
		this.name = name;
		this.fanclub_old = fanclub_old;
		this.application = application;
		this.fanclub_size = fanclub_size;
	}

	public String getFanclub_id() {
		return fanclub_id;
	}

	public void setFanclub_id(String fanclub_id) {
		this.fanclub_id = fanclub_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFanclub_old() {
		return fanclub_old;
	}

	public void setFanclub_old(String fanclub_old) {
		this.fanclub_old = fanclub_old;
	}

	public String getApplication() {
		return application;
	}

	public void setApplication(String application) {
		this.application = application;
	}

	public String getFanclub_size() {
		return fanclub_size;
	}

	public void setFanclub_size(String fanclub_size) {
		this.fanclub_size = fanclub_size;
	}

	@Override
	public String toString() {
		return "FanclubDTO [fanclub_id=" + fanclub_id + ", name=" + name + ", fanclub_old=" + fanclub_old + ", application=" + application + ", fanclub_size=" + fanclub_size + "]";
	}

}

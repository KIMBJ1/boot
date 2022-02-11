package model.dto;

public class SingerDTO {
	private String singer_id;
	private String name;
	private int age;
	private String company;
	private int debut_year;

	public SingerDTO() {}

	public SingerDTO(String singer_id, String name, int age, String company, int debut_year) {
		super();
		this.singer_id = singer_id;
		this.name = name;
		this.age = age;
		this.company = company;
		this.debut_year = debut_year;
	}

	public String getSinger_id() {
		return singer_id;
	}

	public void setSinger_id(String singer_id) {
		this.singer_id = singer_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public int getDebut_year() {
		return debut_year;
	}

	public void setDebut_year(int debut_year) {
		this.debut_year = debut_year;
	}

	@Override
	public String toString() {
		return "SingerDTO [singer_id=" + singer_id + ", name=" + name + ", age=" + age + ", company=" + company + ", debut_year=" + debut_year + "]";
	}
}

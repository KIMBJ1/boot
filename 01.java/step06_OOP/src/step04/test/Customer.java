package step04.test;

public class Customer extends Person {

	private String grade;

	public Customer() {
		super();
	}

	public Customer(String name, int age) {
		super(name, age);
	}

	public Customer(String name, int age, String grade) {
		super(name, age);
		this.grade = grade;
 	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		return super.toString() + "grade";
	}

//	public void setGrade(String grade) {
//		this.grade = grade;
//	}
}

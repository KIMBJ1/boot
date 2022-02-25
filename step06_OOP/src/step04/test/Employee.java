package step04.test;

public class Employee extends Person {

	private String dept;

	public Employee() {
		super();
	}

	public Employee(String name, int age) {
		super(name, age);
	}

	public Employee(String name, int age, String dept) {
		super(name, age);
		this.dept = dept;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	@Override
	public String toString() {
		return super.toString() + "dept";
	}

}

//1. publicData()
//	- Person[] �迭�� �� �� �� / ���� �� �� ����
//	- �迭 ��ȯ
//2. print(�Ķ���� �˾Ƽ�)
//	- �迭 �޾Ƽ� �� ���(grade) ���

package step04.test;

public class ShopAdmin {

	public static Person[] publicData() {
		Person[] p = { new Customer("���̸�", 1995, "gold"), new Employee("���̸�", 2001, "IT") };
		return p;

	}

	public static void print(Person[] p) {
		Customer c = (Customer) p[0];
		System.out.println(c.getGrade());
	}

	public static void main(String[] args) {

		System.out.println(publicData());
	}

}

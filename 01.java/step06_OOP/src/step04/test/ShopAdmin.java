//1. publicData()
//	- Person[] 배열에 고객 한 명 / 직원 한 명 저장
//	- 배열 반환
//2. print(파라미터 알아서)
//	- 배열 받아서 고객 등급(grade) 출력

package step04.test;

public class ShopAdmin {

	public static Person[] publicData() {
		Person[] p = { new Customer("김이름", 1995, "gold"), new Employee("김이름", 2001, "IT") };
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

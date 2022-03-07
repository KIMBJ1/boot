/* data용(domain)
 * - Data Transfer Object(DTO) / Value Objec(VO)
 * - 기본 구조 : 멤버 변수 / 기본 생성자 / parameter 있는 생성자 / getter, setter / toSring() 재정의@Override
 * 		재정의 권장 메소드
 * 		- 객체 보유값 비교(보유한 모든 멤버 변수들 값 비교) 기능의 메소드
 * 		- public, boolean, equals(Object o){}
 * 			: java.lang.Object의 메소드 기능
 * 				- 생성된 객체의 주소값 비교
 * 				- ==
 * 					- 참조타입 비교시 연산자가 객체들 주소값 비교 연산자
 * 					- 기본타입 비교시 값 비교
 * - 재저으이 rule
 * 	- 반환타입 메소드명(argument) : 100% 부모와 동일
 */
package step05.oop;

class Person{
	private String name;
	private int age;
	public Person() {}
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	//생성자, getter, setter 다 있다고 가정
	
	//Person 객체들의 내용값(데이터값) 비교 메소드로 재정의
	/* Person 타입 여부 확인
	 * 	if Person 타입이 아님 : false
	 * 	if Person 타입:
	 * 		- if name 같고 age 같다 : true
	 * 		- if name 같고 age 다르다 : false
	 * 		- if name 다르고 age 같다 : false
	 * 
	 * 		- name(String) : equals()
	 * 		- age(int) : == 동등비교 연산자
	 * 조건식1 && 조건식2 - 빠른 연산자, and 연산자
	 * 	: 조건식 둘 다 참이어야 true
	 * 	: 조건식1이 거짓이면 조건식2 실행(검증)하지 않음
	 */
	public boolean equals(Object o) {
		if (o instanceof Person) {
			//형변환 먼저
			//Person p = (Person)o
			//if(name.equals((p.name) &&(age == (p.age)) 가능********************************
			if(name.equals(((Person)o).name) &&(age == ((Person)o).age)) {
				return true;
			}
		}else {
		return false;
		}
		
		return false;
}
}
class A{}
class B extends A{}
class C extends A{}
/* Objec o = new A(); / = new B(); / = new C();
 * A a = new A(); / = new B(); / = new C();
 * B b = new B();
 * C c = new C();
 * 
 * A a = new C(); / Object생성 -> A 생성 -> C 생성 순으로 생성
 * a 변수 타입 : A 타입
 * a 변수로 활용 가능한 객체 - C > A > Object
 */

public class OverrideTest {

	public static void m1(){
		
		System.out.println("------- String 값 비교");

		String s1 = "a"; //객체 생성
		String s2 = new String("a"); //새로운 객체 생성
		String s3 = "a"; //이미 new 없이 생성된 문자열 객체가 동일한 데이터 값으로 존재하면 재사용
		String s4 = new String("a"); //그저 새로운 객체 생성

		System.out.println("s1, s2 주소값 비교 : " + (s1 == s2)); //s2는 new로 생성
		System.out.println("s1, s3 주소값 비교 : " + (s1 == s3)); //이미 있는 값 재사용
		System.out.println("s2, s4 주소값 비교 : " + (s2 == s4)); //s4는 new로 생성
		System.out.println("\ns1, s2 내용값 비교 : " + s1.equals(s2));
		System.out.println("s1, s3 내용값 비교 : " + s1.equals(s3));
		System.out.println("s2, s4 내용값 비교 : " + s2.equals(s4));

	}
	/* instanceof
	 * - 객체 타입 비교 연산자
	 * - 상속 관계를 무시하지 않음
	 * 	- 상위타입 변수로 생성된 객체들은 상위타입을 상속받는 모든 클래스 타입과 비교 가능
	 * - 문법
	 * 	: 참조변수 instanceof 비교타입
	 */
	
	public static void m2() {
		A a1 = new B(); // B > A
//		A a2 = new C();
		System.out.println("\n------- 객체 타입 비교 연산자 instanceof");
		System.out.println(a1 instanceof A);
		//상위타입 변수로 생성된 객체들은 상위타입을 상속받는 모든 클래스 타입과 비교 가능
		//B와 C는 A를 상속받음
		System.out.println(a1 instanceof B);
		System.out.println(a1 instanceof C);
		System.out.println(a1 instanceof Object);
		System.out.println();
		B b1 = new B(); //B > A > Object
		System.out.println(b1 instanceof A);
		System.out.println(b1 instanceof B);
//		System.out.println(b1 instanceof C); //문법 오류, B랑 C는 관계 없 : instanceof 사용 불가, 상속이 있어야 다형성 가능
		System.out.println(b1 instanceof Object);
		
	}
	
	public static void main(String[] args) {
		m1();
		m2();
		System.out.println("\n------- Person 객체 생성해서 equals()로 객체들 내용값 비교");
		Person p1 = new Person("asdf", 1995);
		Person p2 = new Person("asdf", 1995); //p1과 같음
		
		Person p3 = new Person("asdf", 2001); //나이 다름
		Person p4 = new Person("qwer", 1995); //이름 다름
		Person p5 = new Person("qwer", 2001); //이름 나이 다름
		System.out.println(p1.equals(p2));
		System.out.println(p1.equals(p3));
		System.out.println(p1.equals(p4));
		System.out.println(p1.equals(p5));
		
		System.out.println(p2.equals(p3));
		System.out.println(p2.equals(p4));
		System.out.println(p2.equals(p5));
		
		System.out.println(p3.equals(p4));
		System.out.println(p3.equals(p5));
		
		System.out.println(p4.equals(p5));
		
		System.out.println(p1.equals("zxcv"));
	}

}




















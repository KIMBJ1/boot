/* data��(domain)
 * - Data Transfer Object(DTO) / Value Objec(VO)
 * - �⺻ ���� : ��� ���� / �⺻ ������ / parameter �ִ� ������ / getter, setter / toSring() ������@Override
 * 		������ ���� �޼ҵ�
 * 		- ��ü ������ ��(������ ��� ��� ������ �� ��) ����� �޼ҵ�
 * 		- public, boolean, equals(Object o){}
 * 			: java.lang.Object�� �޼ҵ� ���
 * 				- ������ ��ü�� �ּҰ� ��
 * 				- ==
 * 					- ����Ÿ�� �񱳽� �����ڰ� ��ü�� �ּҰ� �� ������
 * 					- �⺻Ÿ�� �񱳽� �� ��
 * - �������� rule
 * 	- ��ȯŸ�� �޼ҵ��(argument) : 100% �θ�� ����
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
	//������, getter, setter �� �ִٰ� ����
	
	//Person ��ü���� ���밪(�����Ͱ�) �� �޼ҵ�� ������
	/* Person Ÿ�� ���� Ȯ��
	 * 	if Person Ÿ���� �ƴ� : false
	 * 	if Person Ÿ��:
	 * 		- if name ���� age ���� : true
	 * 		- if name ���� age �ٸ��� : false
	 * 		- if name �ٸ��� age ���� : false
	 * 
	 * 		- name(String) : equals()
	 * 		- age(int) : == ����� ������
	 * ���ǽ�1 && ���ǽ�2 - ���� ������, and ������
	 * 	: ���ǽ� �� �� ���̾�� true
	 * 	: ���ǽ�1�� �����̸� ���ǽ�2 ����(����)���� ����
	 */
	public boolean equals(Object o) {
		if (o instanceof Person) {
			//����ȯ ����
			//Person p = (Person)o
			//if(name.equals((p.name) &&(age == (p.age)) ����********************************
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
 * A a = new C(); / Object���� -> A ���� -> C ���� ������ ����
 * a ���� Ÿ�� : A Ÿ��
 * a ������ Ȱ�� ������ ��ü - C > A > Object
 */

public class OverrideTest {

	public static void m1(){
		
		System.out.println("------- String �� ��");

		String s1 = "a"; //��ü ����
		String s2 = new String("a"); //���ο� ��ü ����
		String s3 = "a"; //�̹� new ���� ������ ���ڿ� ��ü�� ������ ������ ������ �����ϸ� ����
		String s4 = new String("a"); //���� ���ο� ��ü ����

		System.out.println("s1, s2 �ּҰ� �� : " + (s1 == s2)); //s2�� new�� ����
		System.out.println("s1, s3 �ּҰ� �� : " + (s1 == s3)); //�̹� �ִ� �� ����
		System.out.println("s2, s4 �ּҰ� �� : " + (s2 == s4)); //s4�� new�� ����
		System.out.println("\ns1, s2 ���밪 �� : " + s1.equals(s2));
		System.out.println("s1, s3 ���밪 �� : " + s1.equals(s3));
		System.out.println("s2, s4 ���밪 �� : " + s2.equals(s4));

	}
	/* instanceof
	 * - ��ü Ÿ�� �� ������
	 * - ��� ���踦 �������� ����
	 * 	- ����Ÿ�� ������ ������ ��ü���� ����Ÿ���� ��ӹ޴� ��� Ŭ���� Ÿ�԰� �� ����
	 * - ����
	 * 	: �������� instanceof ��Ÿ��
	 */
	
	public static void m2() {
		A a1 = new B(); // B > A
//		A a2 = new C();
		System.out.println("\n------- ��ü Ÿ�� �� ������ instanceof");
		System.out.println(a1 instanceof A);
		//����Ÿ�� ������ ������ ��ü���� ����Ÿ���� ��ӹ޴� ��� Ŭ���� Ÿ�԰� �� ����
		//B�� C�� A�� ��ӹ���
		System.out.println(a1 instanceof B);
		System.out.println(a1 instanceof C);
		System.out.println(a1 instanceof Object);
		System.out.println();
		B b1 = new B(); //B > A > Object
		System.out.println(b1 instanceof A);
		System.out.println(b1 instanceof B);
//		System.out.println(b1 instanceof C); //���� ����, B�� C�� ���� �� : instanceof ��� �Ұ�, ����� �־�� ������ ����
		System.out.println(b1 instanceof Object);
		
	}
	
	public static void main(String[] args) {
		m1();
		m2();
		System.out.println("\n------- Person ��ü �����ؼ� equals()�� ��ü�� ���밪 ��");
		Person p1 = new Person("asdf", 1995);
		Person p2 = new Person("asdf", 1995); //p1�� ����
		
		Person p3 = new Person("asdf", 2001); //���� �ٸ�
		Person p4 = new Person("qwer", 1995); //�̸� �ٸ�
		Person p5 = new Person("qwer", 2001); //�̸� ���� �ٸ�
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




















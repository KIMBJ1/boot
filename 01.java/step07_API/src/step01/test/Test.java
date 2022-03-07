/* . : ������ / dot ������
 * - ������ ��ü ���� ������ �ش� ��ü�� ����� ȣ��ÿ� ���
 * - static���� ����� ����� Ŭ������. ���� ȣ��
 * - package�� import
 * 
 * ��ü�� ���� ȣ�� ����
 */

package step01.test;

class A extends Object{
	String v1 = "String";
	A(){
		super();
		//v1 ��� ���� ����
		System.out.println("A");
	} //c1 ���� string���� ���ڿ� ��ü�� A��ü ���� �Ϸ�
}
class B extends Object{
	A a = new A();
	int v2 = 10;
	B(){
		super();
		// B�� ������ a����, v2 ����
		System.out.println("B");
	}
}
class C extends Object{
	B b = new B();
	int v3 = 30;
	C(){
		super();
		//super();�Ϸ� : ������ ��� ������ �Ϻ��ϰ� �޸𸮿� ����
		System.out.println("C");
	}
}

public class Test {
	
	public static void main(String[] args) {
		//? � ��ü������ ����?
		System.out.println("----- ��ü ���� ����");
		C c = new C(); //������ ȣ���� ��ü ����-��ü ���� �ϼ� : ��� ������ �޸𸮿� ��� �����ϰ� ����
		
		//? ���� ���̻��� ��ü ���� ���� v1 ������ ���
		/* c.b.a.v1
		 * c : C ��ü
		 * c.b : B ��ü
		 * c.b.a : A ��ü
		 * c.b.a.v1 : String ��ü
		 */
		System.out.println();
		System.out.println("----- v1 ������ ���");
		System.out.println(c.b.a.v1);
		
	}
	
}


/* �н� ����
 * 1. static Ű���� �н�
 * 2. static Ű���� Ȱ�� ����
 * 	1. ��� ������ ���� 	- static Ÿ�� ����;
 * 	2. �޼ҵ忡 ����	- static ����Ÿ�� �޼ҵ��(){}
 * 	3. static{}		- �� �̷��� ����
 */

package step01.basic;

public class L04Static {

	// ������� ���� ���� �� ȣ�� ���� ����
	// ��� ������ ��ü ���� ������ �ڵ����� �⺻ �� �ʱ�ȭ
	// �Ǽ� = 0.0, ���� = 0, boolean = false, char = '|u0000' �̰� null
	// ��� ���� Ÿ�� = null
	int i; // instance���� : ��ü �ʼ�
	static int i2; // static ����

	L04Static() {
		i++;
		i2++;
	}

	void m1() {
		System.out.println("�Ϲ� �޼ҵ� = instance �޼ҵ�");
	}

	static void m2() {
		System.out.println("static �޼ҵ�");
	}

	static {
		System.out.println("static ��� 1++++++***-------////================");
	}

	public static void main(String[] args) {

		L04Static l = new L04Static();
		System.out.println(l.i + " " + i2); // ����� 1 1
		L04Static l2 = new L04Static();
		System.out.println(l2.i + " " + i2); // ����� 1 2

		l.m1();
		l2.m1();
		m2();

		/*
		 * System.out.println(i2);
		 * 
		 * L04Static l = new L04Static(); System.out.println(l.i);
		 */

	}

}

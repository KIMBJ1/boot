package step01.basic;

public class L02Method {

	/*
	 * ������ �뵵 - ��ü�� ���鶧 �ʼ��� ���Ǵ� ��� �����ڰ� �ڵ�� �̱����� ������ ������ �ڵ� ���� - �ڹ� ����� ��ü ���� �⺻��
	 * ���⼭�� L02Method��� �̸����� �ڵ� ����
	 */

	// �� ���� ���� �޾Ƽ� ��ġ��
	int sum(int v1, int v2) {
		return v1 + v2;
	}

	int sum2(int v1, int v2) {
		int result = v1 + v2;
		return result;
	}

	// java L02Method ���� ��û�� �ش� Ŭ������ main �޼ҵ带 jre���� �ڵ� ȣ��
	// main() ������ �츮�� ������ ��� �޼ҵ�(���)�� ���� �ڵ�� ȣ��
	public static void main(String[] args) {
		/*
		 * �ܼ� �޼ҵ� ��ɵ��� ȣ���ؼ� ����ϱ� ���� ���������� ��ü ���� sum() ȣ���ؼ� �٤���ȯ���� ������� main()���� �ܼ�â�� ���
		 * ��ü ���� - sum(), sum2() ������ Ŭ�����κ��� ��ü ���� L02Method(�̰� int, String���� ����)
		 * variablename - java�� Ȯ�强 ���� ���� Ŭ������ �ڹ� Ÿ������ ��� ���� Ŭ������ ������� ���ο� �����Ͱ� �����Ǿ��ٴ�
		 * ��ü �������� ����
		 */

		L02Method newvariable = new L02Method(); // new : ��ü ���� Ű����
													// L02Method() : ������
		// System.out.println(newvariable);
		// �̰� �����
		// step01.basic.L02Method@123a439b
		// newvariable : ������ ��ü�� �����ϴ� ������ �ּҰ� ����, ��������(reference ����)

		int daedab = newvariable.sum(10, 15);
		int daedab2 = newvariable.sum2(17, 25);
		System.out.println("10 + 15 : " + daedab);
		System.out.println("17 + 25 : " + daedab2);

	}
}
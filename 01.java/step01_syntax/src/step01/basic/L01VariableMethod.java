// �� ���� �ּ�

/* ���� ���� �ּ�
 * block �ּ�
 */

/* �н� ����
 * 	1. �ڹ� ������ ����
 *  	- Ÿ�� ������ = ��;
 *  
 *  2. ����
 *  	- ���� �ΰ��� ������ ������ ����
 *  	- ����
 *  		- ���� �ΰ� : ���� Ÿ��
 *  		- ������ - ��Ģ ������ ��� �� ������ ���� ������ 4���� �޼ҵ�
 *  			- ����� ������� ��� ó���� ��?
 *  				1. �ܼ�â�� �ܼ� ���
 *  				2. �� ����� ������ �� ������ ��ġ�� ���� ���� : ���⼭�� �̰ɷ� �ϰ���
 *  					- �޼ҵ� ȣ�� -> �����ϸ鼭 ���� ���� -> ���� �� ����� ȣ���� ������ ��ȯ(return)
 *  
 *  3. ���ø� ������� �� ����
 *  	1. ���ϱ�
 *  		- ����ÿ� �ΰ��� ���ڰ� ���� -> ���ϱ� ���� -> ����� ��ȯ
 *  		
 *  		���� ���ϱ�(��1, ��2){
 *  			��1 + ��2;
 *  			return �����
 *  		}
 *  
 *  		�� �޼ҵ� ������ : ��
 *  		�� �޼ҵ� ȣ���ؼ� ����� ��� : �ٸ� �����
 *  			- ����ڴ� �޼ҵ� ���𱸸� ���� ȣ���ؼ� ����� �Ѵ�
 *  			- �޼ҵ� �����α��� �ϳ��ϳ� Ȯ�� ���ʿ�
 */

package step01.basic;

public class L01VariableMethod {

	// asdf
	int sum(int v1, int v2) {
		return v1 + v2;
		// return ����

	}

	void sum2(int v1, int v2) {
		// void : return ���� ��
		System.out.println(v1 + v2);
		// return ����
	}

	double div(int v1, int v2) {
		return v1 / v2;

	}

	void div2(int v1, int v2) {
		System.out.println(v1 / v2);
		// return ����
	}

	// ���̸� ���ڿ� ��ȯ�ϴ� �޼ҵ� ����
	String getName() {
		return "���̸�";
	}

	int getAge() {
		return 30;
	}

	double getPay() {
		return 3.5;
	}

	public static void main(String[] args) {

		String name = "���̸�";
		int age = 28;

		System.out.println(name);
		System.out.println(age);
		System.out.println(name + " " + age);

	}

}

/*
 * �н� ����
 * 
 * class ���ο� �����ؾ� �ϴ� ��ҵ� : ���� ������ �޼ҵ�
 * 
 * 1. ���� ���� �� ȣ��
 * 	- ������
 * 	- Ÿ�� ������;
 * 	- Ÿ�� ������ = ��;
 * 2. ������ ���� �� ȣ��
 * 	- Ŭ���� ��� ����, (){}�ʿ�
 * 	- only ��ü ���� �뵵
 * 		- new ��� ��ü ���� Ű����
 * 		- ��ü ���� ����
 * 			- new ������([��]);
 * 		- Ŭ������ ������ �޼ҵ� ȣ���� ù �ܰ�� ��ü ������ ���� ������ �޼ҵ� ȣ��
 * 3. �޼ҵ� ���� �� ȣ��
 * 	- ��ü �����ÿ� ȣ��Ǵ� �����ڿ� �ٸ�
 * 	- ��ȯŸ�� �޼ҵ�� (arguments){[logif]}
 */

package step01.basic;

public class L03Review {
	String name;
	int age;
	
	L03Review(){} // �̱����� ������ ������ �ڵ����� �߰�
	// Ŭ���� �̸��� ���� (){}�ִ� ������
	
	//�޼ҵ� ����
	//�̸� ��ȯ�ϴ� getName()
	String getName() {
		return "�达";
	}
	
	public static void main(String[] args) {
		//���⼭�� ���� ����°� ����
		//name = "���̸�"; �̷��� ���� ���� name ���� ����
		
		L03Review newvariable = new L03Review(); //��ü ���� &nd �޸� ����
		
		System.out.println(newvariable.name);
		//main���� name ȣ������ ������ null
		//ctrl alt �Ʒ� ����Ű�� �ڵ� ����
		//alt �Ʒ� ����Ű�� �ڵ� �̵�
		newvariable.name = "���̸�";
		System.out.println(newvariable.name);
//========		String getName		==============================
		
		String n = newvariable.getName();
		System.out.println(n);
		
/*
 * ==========
 * ���� ����
 * 1. name age ���� �� �����Ͱ� ���� ���� ����(��� ����)�ϰ� �ý��ۿ� �޸𸮸� �����ϴ� ����?
 * 	= ��ü ���� ����
 */
	}

}

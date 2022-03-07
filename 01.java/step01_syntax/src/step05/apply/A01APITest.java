/* �н� ����
 * 1. API ����
 * 	- Application Programming Interface
 * 	- �̹� �����Ǽ� ��� �����ϰ� �������ִ� �ڵ��
 * 		Ŭ���� / ���� / ������ / �޼ҵ�
 * 	- library��� ǥ���ϱ⵵ ��(lib)
 * 
 * 2. ���� ǥ��
 * 	src - source
 * 	lib - library
 * 	bun - binary
 * 
 * 3. API Ȱ�� ����
 * 	1. ���� / ������ / �޼ҵ� ȣ�� ����
 * 	2. ȣ�� ����
 * 		1. ��ü ���� ���Ŀ� ȣ��
 * 			- instance ������ instance �޼ҵ�
 * 		2. ��ü �������� ȣ��
 * 			- static ������ static �޼ҵ�
 * 	3. �ܺ� package ���
 * 		- import package��.class��;
 * 		- java.lang package�� �����ϰ� import ���� ����
 * 
 */


package step05.apply;

public class A01APITest {

	public static void main(String[] args) {
		// java.lang.Math Ŭ������ �޼ҵ� Ȱ��
		// -3 �� �ְ� ���밪(abs) ��ȯ int �ְ� int ��ȯ �޾� ���
		System.out.println(Math.abs(-3));
		
		//�� ���ڿ����� '?��° ����'�� ���
		
		/*API ������ ����
		 * ���ڿ� String ������ �����ϴ� ����
		 * ���� �޾Ƽ�argument �ش� ���� ��ġ�� ���� �ϳ�char ��ȯ
		 * 
		 * char ?(int index){
		 * 	���ڿ� ��ü���� index�� �ش� char ���� �� ��ȯ
		 * }������ ��
		 * 
		 * ����� �� static�̸�?
		 * static char ?(int index){
		 * 	���ڿ� ��ü���� index�� �ش� char ���� �� ��ȯ
		 * }
		 * 
		 * System.out.println(String.charAt(1)); �ȵ�
		 * 
		 * ���� static �����Ϸ���
		 * static char charAt(String data, int index){
		 * 	parameter�� ���� ���ڿ� ��ü���� �ε��� �� �ش� char ���� �� ��ȯ
		 * 
		 */
		String data = "��� �����ڻ� ��ġ ��� - ���";
		System.out.println(data.charAt(5));
		
		/*
		 * java.lang.Integer ��� Ŭ������ �޼ҵ� ���
		 * "3" -> 3���� �����ؼ� ���
		 */
		
		System.out.println(Integer.parseInt("57"));
		
		/* int�� ��ȯ �Ұ� ����
		 * ���Ŀ� Exception �� ó�� �����Ѱ���� ���� ����� �н� �ʼ�
		 * System.out.println(Integer.parseInt("�����ٶ�"));
		 * �̷���
		 */
		
	}

}

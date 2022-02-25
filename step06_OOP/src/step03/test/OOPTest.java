/* 1.Object �� ��� Ŭ������ ����Ÿ��
 * 2. ��� ��ü Ÿ�� �� ����
 * 3. ������ �������� ������ ��ü���� ���� Ÿ���� ������ ���� ����
 * 	= ����ȯ
 * 4. Object ���� = "test"; ����
 */
package step03.test;

public class OOPTest {

	//Object ���� = "string"
	static Object m1() { //Object Ÿ������ ����ȯ �� ������ ����Ǿ� ����Ÿ������ ��ȯ�Ǿ� ��ȯ
		return "string"; //String ��ü ���� �� ����
	}
	
	//���ڿ� 2��, People ��ü �� �پ��� Ÿ���� ��ü���� �ϳ��� �������� ����
	//�̻����� ������ Ÿ����? - �迭?
	//������� - String�� People�� �� �ٸ� ���� Ÿ��
	// ���� ���� ���� ��ü�� ����Ÿ���� ���� �� �����Ϸ��� �迭 Ÿ���� Object[]�� ������ ��
	
	static Object[] m2() {
		Object[] o = {"string", "playdata", new Integer("3")};
		return o;
	}
	
	public static void main(String[] args) {
		
		System.out.println("-------step01");
		String s = (String)m1(); //�� s�� �ݵ�� StringŸ���̾�� ��
		//Object Ÿ�� �������� String �ڽĸ��� ��� ȣ�� �Ұ�
		//String���� ����ȯ �� String���� ��� ȣ��
		System.out.println(s.charAt(3)); //String ���ڿ� �� 4��° ���
										 //charAt String Ŭ������ ����
		
		System.out.println("-------step02");
		Object[] v = m2();
		String v1 = (String)v[1];
		System.out.println("-------playdata���� p");
		System.out.println(v1.charAt(0));
		/*public int intValue(){ 
		 * Integer��� ��ü�� ������ ���� int�⺻ Ÿ������ ��ȯ�ؼ� ��ȯ�ϴ� �޼ҵ�
		 * }
		 * 
		 * main �޼ҵ忡�� m2()ȣ��
		 * ù��° ��� : playdata���� p
		 * �ι�° ��� : Integer ��ü �̾Ƽ� intValue() ȣ�� �� ���
		 */
		System.out.println("-------Integer ��ü �̾Ƽ� intValue() ȣ�� �� ���");
		Integer v2 = (Integer)v[2];
		System.out.println(v2.intValue());
		
	}
}

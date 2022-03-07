/* �н�����
 * 1. ������ Ÿ�� �н�
 * 2. ������ Ÿ���� Ȱ���� �Ǵ� �������� ��ġ
 * 	1. ��� ����, ���� ���� ����� Ÿ��
 * 		- ���� : ������, �޼ҵ� argument�� {} ���ο� ����
 * 	2. ���� Ÿ��
 * 3. ������ Ÿ�� ����
 * 	1. �⺻ Ÿ�� (���� Ÿ��, built in)
 * 		1. �� 8����
 * 		2. class ������ ���·� �ҹ��ڷ� ������ ����
 * 		3. ���·� ����
 * 			������ / ���� / �Ǽ��� / ������
 * 		4. ���º��� ������� ����ȭ
 * 			1. ������ - char, 16��Ʈ(�ٱ��� ���� ������)
 * 			2. ���� - boolean(true or false)
 * 			3. �Ǽ��� - float, 32bit / double, 64bit
 * 			4. ������ - byte, 8bit / short, 16bit/ long, 64bit / int, 32bit
 * 	2. ��ü Ÿ�� (���� Ÿ��, class type)
 * 		1. �⺻�� �ƴ� ��� Ÿ��
 * 		2. class�� ������� Ÿ�� ����
 * 		3. API �� �̹� ���� �����ڿ��� ����϶�� �����ϴ� library�� �ټ��� class �� Ÿ�� ����
 * 			- String
 * 		4. ���ڿ� : String.java�� �����Ǵ� Ŭ����, ���󵵰� ���Ƽ� �⺻ Ÿ��ó�� ������ ����
 * 		5.��ü ���� ����
 * 			Ÿ�� ���� = new ������([...]);
 * 			String ���� = new String([���ڿ�]); ���� �̰� ���� but
 * 			String ���� = "���ڿ�"; ǥ�⸸���� �ڵ����� String ��ü ����
 * 		6. ������ ��ü�� ���� ����Ǵ� �޸� - heap
 * 			- heap �޸� Ư¡
 * 				- ��ü�� ����
 * 				- �����Ǵ� ��ü�� ������ ��� ��� ������ ������ ���� ����
 * 				- ��ü�� �޸� ȸ���� garbage collector(GC)
 */


package step04.datatype;

public class L01DataType {
	
	String getName() {
		String s = "���̸�";
		return s;
	}
	
	Person getPerson() {
		Person p = new Person();
		return p;
	}
	
	void setName(String name) {
		String n = "���� �̸��� : " + name;
	}
	
	void setPerson(Person p) {
		Person p2 = p;
	}
		
	public static void main(String[] args) {
		L01DataType l = new L01DataType();
		String n = l.getName();
		

	}

}

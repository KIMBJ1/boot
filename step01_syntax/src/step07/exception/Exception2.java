//����ó�� ���� �н�

package step07.exception;

class B{
	static {
		System.out.println("B Class �ε�");
	}
}
public class Exception2 {
	
	public static void m1() {
		System.out.println("���� �߻� ����");
	}

	//��Ÿ�� ����
	public static void m2() {
		System.out.println("���� ����");
		System.out.println(10/0);// 0���� ������*************************************
		System.out.println("try~catch ���� �����Ƿ� ���� �߻� -> ���� �Ұ�");
	}
	
	//������ ���� - try~catch ���� �ʼ�
	public static void m3() {
		try{
			System.out.println("�ε� ��01");
			Class.forName("step07.exception.B"); //���� �߻� ���ɼ� �ִ� ����
			System.out.println("�ε� ��01");
		}
		catch(ClassNotFoundException e) { // ���� ���� �߻� �� ó���ϴ� ���
			System.out.println("B �ε��� ���� �߻�01");
		}
		try{
			System.out.println("�ε� ��02");
			Class.forName("step07.exception.Basdf"); //���� �߻� ���ɼ� �ִ� ����
			System.out.println("�ε� ��02");
		}
		catch(ClassNotFoundException e) { // ���� ���� �߻� �� ó���ϴ� ���
			System.out.println("B �ε��� ���� �߻�02");
		}finally {
			//�߰��� �ʼ� ������ �����ϴ� ��� : sys. �ڿ� ��ȯ �������� ���
			System.out.println("���� �߻� ���ο� �����ϰ� 99% ���� ���� ���");
		}
		System.out.println("B��� ������ ����Ǵ� ����");
	}
	
	//���� �߻��ؼ� ���� ȣ���� ������ throws �غ���
	//m4() ȣ���� ������ ���� ó��
	//java.lang.Exception Ŭ������ Ȱ��
	//0107-�н�����.txt/2.3�ܰ�
	//���� - ���� playdata�� �ƴϸ� ���� �߻�
	//! : ����������, !true -> false. !false -> true
	/* throws - body���� �߻��� ���� �ִ� ���ܸ� ȣ���� ������ ������ ���� �޼ҵ� ���𱸿� ���� Ű����
	 * throw - �޼ҵ� body���� ���� ��Ȳ�� ���ܸ� �����ؼ� ������ Ű����, new�� ����
	 */
	public static void m4(String v) throws Exception{
		//playdata�� �ƴ� ��츸 true�� �Ǵ� ���ǽ�
		//if ������ ���� ��� if ��� �� ���ܰ�ü ������ ���� �������� �޼ҵ� �ڵ� ����
		if(!v.equals("playdata")) {
			//Exception�� message ��� ������ �ʱ�ȭ�ϴ� ������
			throw new Exception("playdata�� �ƴ�, ���� �ɰ�");
		}
		System.out.println("playdata�� ��쿡�� ����Ǵ� ������");
	}
	
	public static void main(String[] a) {
		m1();
//		m2(); //�߻� Ȯ��
		m3();

		try {
			m4("playdata");
			m4("asdf");
		} catch (Exception e) {
			System.out.println(e.getMessage()); //���� ��ü�����ڿ� ������ parameter�� ��ȯ�ϴ� �޼ҵ�
			e.printStackTrace();// �߻��� ������ ��ġ ���
		}
	}
}

//���� 4-5���� �����

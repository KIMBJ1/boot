//int 2�� ������ ��� ������ ��
//0���� ������� try~catch ����ؼ� ����ó�� �ϼ���
package step07.exception;

public class ExceptionMission {
	
	public static void m(int v1, int v2) throws Exception{
		if(v2 == 0) {
			throw new Exception("������ �Ұ�");
		}
		System.out.println(v1/v2);
	}
	
	public static void main(String[] args) {
		try {
			m(50,2);
			m(30,3);
			m(10,0);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();// ���� ��ġ ǥ��
		} finally {
			System.out.println("fin");
		}
	}
}
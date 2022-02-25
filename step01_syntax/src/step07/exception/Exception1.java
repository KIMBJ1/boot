/* ClassNotFoundException
 * ArrayIndexOutOfBoundsException
 * 
 * 1. �ǽ�
 * 	���� / ������ ��Ȳ ����
 * 2. �迭 ����
 * 	������ ok / ����� ArrayIndexOutOfBoundsException �߻�
 * 	���� ���� �߻��� �� �����ؼ� �� try~catch��� ����ó�� ���� ���� �����ؼ� ���� ����
 *	���� �߻��ÿ��� sys. stop
 * 3. class �ε� ����
 * 	����ó�� ������ ���� ��쿡 ��Ÿ �������� Ȯ�� ���� ������ ���� �߻�
 * 	ClassNotFoundException	
 * 	����ó�� ���� ������ �ʼ� �Ŀ� �����ؼ� ���� �߻� ���� Ȯ��
 * 	Ȥ ���� �߻��ÿ��� ���α׷� ������ ������ ���� ���� ����
 */

package step07.exception;

class A{
	static {
		System.out.println("byte code�� �޸𸮿� �ε��� �ڵ� ����Ǵ� ���");
	}
}

public class Exception1 {

	public static void main(String[] args) {
		int[] i = {1,2};
		System.out.println(i[1]);
		
		//�����ϴ� �Ϲ� byte�ڵ� �� class�� �޸𸮿� �ε��ϴ� API
		/* forName() ������ ����
		 * 1. ��� : parameter ���ڿ��� ���ԵǴ� Ŭ������ �޸� �ε�
		 * 
		 * 2. �߻� ������ ����� ��
		 * 	1. ���� �ε�
		 * 		- ��¥ �����ϴ� Ŭ������ �ְ� ��Ÿ ���� �ڵ�
		 * 	2. ������ �ε�
		 * 		- class�� ���ų�
		 * 		- ��Ÿ
		 * 3. ���
		 * 	- Ȥ�� ������ �ε��� �ڵ忡�� �߻��� ������ ����ؼ� 
		 * 		1. �޼ҵ� ���𱸿� ��� :
		 * 		2. �޼ҵ� body���� ó�� : 
		 * 	public static Class<?> forName(String className)
                        throws ClassNotFoundException

		 */
		try {
			Class.forName("step07.exception.A");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			Class.forName("step07.exception.Aasdf");//Ŭ���� �̸� ��Ÿ
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	
	}

}
//int[] i = {1,2};
//System.out.println(i[5]); �϶� �����޽���
//�������� �ʴ� �޸𸮰� ������ ��½� ���� �߻�
/*Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: Index 5 out of bounds for length 2
 * at step07.exception.Exception1.main(Exception1.java:7)
 */

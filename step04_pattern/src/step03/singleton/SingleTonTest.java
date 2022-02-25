/* �н� ����
 * singleton design pattern
 * 1. server�� �������� �ڿ��� �������鿡�� �ʿ��� ��Ŀ����
 * 2. server ���ο� ���� �ÿ� ��ü���� ������ �ϳ��� ���� ����
 * 3. ���� ���
 * 	1. ��ü ���� ���� - �ܺο��� ��ü ���� ����
 * 		private ������(){}
 * 	2. �ܺο��� �� ��ü�� �ٸ� ���(�޼ҵ�)�� Ȱ�� ���
 * 		1. �ش� Ŭ���� ������ ��ü ����
 * 		2. ������ ��ü�� �޼ҵ�� ��ȯ
 */

package step03.singleton;

public class SingleTonTest {
	public static void main(String[] args) {
		
		SingleTon s = SingleTon.getInstance();
		//SingleTon�� �޼ҵ� ����ؾ� �ϴ� ����
	}
}
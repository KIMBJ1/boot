
/* �н����� -Set
 * 1. �����͵� �ߺ� ����
 * 2. ���� ������ ���� ���� ����
 * 3. ������ �ϳ��ϳ� �����Ҽ� �ִ� ���� index ����
 * 4. API�� ���� ������ �ϳ��� ��ȯ �޼ҵ� ����
 * 	- Iterator API Ȱ���ؼ� �ϳ��� ��ȯ
 * 		- boolean hasNest() : ������ Ȯ��
 * 		- Object next() : ������ �ϳ� ��ȯ
 * 
 */

package step01.test;

import java.util.HashSet;
import java.util.Iterator;

public class SetTest {

	public static void main(String[] args) {
		System.out.println("------- HashSet ����ؼ� �ߺ�����");
		HashSet<String> set = new HashSet<String>();
		set.add("a");
		set.add("b");
		set.add("c");
		set.add("d");
		set.add("d"); //������ �̹� ������ ������ ���� �� �� ������ ����
		set.add("c"); //���� c ������ �� c ����
		System.out.println(set);
		
		//set ������ �����Ͱ����� �ϳ��� ���� �����ϰ� ���ִ� ��ü
		Iterator<String> all = set.iterator();
		/* hasNext() : ���� ���� Ȯ�� �޼ҵ�
		 * next() : ������ ����(�޸𸮿��� ���� -��, �ѹ��� ��� ������ ��ü)
		 */
		
		System.out.println("\n------- hasNext() &nd next()");
		while(all.hasNext()){
			System.out.println(all.next());
		}
		
		
		System.out.println("\n------- ����ȯ ���� String���� ��� ȣ�� ����");
		Iterator<String> all2 = set.iterator();
		String v = null;
		while(all2.hasNext()){
			v = all2.next();
			System.out.println(v.charAt(0));
		}
		
		System.out.println("\n------- ���׸� �̹ݿ� ������ �ڵ�� �������� �� ��");
		System.out.println("------- ���׸��� all ���� ����ó�� �����ϸ鼭 Ȱ���ϴ� �ڵ� ����"
				+ "");
		
		HashSet<String> set2 = new HashSet<String>();
		set2.add("a");
		set2.add("b");
		set2.add("c");
		set2.add("d");
		set2.add("d");
		
		Iterator all22 = set2.iterator();
		
		while(all22.hasNext()){
			System.out.println(((String)all22.next()).charAt(0));
		}
	}

}

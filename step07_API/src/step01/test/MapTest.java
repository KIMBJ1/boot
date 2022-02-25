/* �н� ���� : Map
 * 1. ������ ������(key)�� ��(value) ���� �� Ȱ���ϴ� �Ĥ�
 * 2. ��ü Ÿ�Ը� Ȱ��
 * 3. key�� �ߺ� ���� / value�� �ߺ� ����
 */
package step01.test;

import java.util.ArrayList;
import java.util.HashMap;

import model.domain.Employee;

public class MapTest {

	public static void main(String[] args) {
		HashMap<String, String> maps = new HashMap<String, String>();
		maps.put("a", "asdf");
		maps.put("b", "qwer");
		maps.put("c", "zxcv");
		maps.put("a", "zxcv"); //a��� key�� �̹� �����ϴ� ��ü ���� �� ����
		System.out.println("------- maps : key �ߺ� �Ұ� / value �ߺ� ����");
		//�����ǵ� toString() ��ȯ�� �ܼ� ���
		System.out.println(maps);
		
		System.out.println("\n------- ������ key�� ������ �ϳ� �̾Ƽ� ���");
		String v = maps.get("a");
		System.out.println("key�� a�� maps�� value : " + v);

		HashMap<String, Employee> maps2 = new HashMap<String, Employee>();
		maps2.put("11", new Employee("11", "charlie", 10));
		maps2.put("22", new Employee("22", "adam", 10));
		System.out.println("\n------- adam"
				+ "�̸��� ����ϱ�");
		System.out.println(maps2.get("22").getEname());
		
		System.out.println("\n------- Map�� List ���� �� Ȱ��");
		/* �μ����� ���� ����(ArrayList) -> �μ��� �����ڷ� ��� ���� ����(HashMap)
		 * 
		 */
		ArrayList<Employee> emps = new ArrayList<Employee>();
		//�� 10�� �μ���� ����
		emps.add(new Employee("11","emp01",10));
		emps.add(new Employee("22","emp02",10));
		emps.add(new Employee("33","emp03",10));
		
		System.out.println(emps);
		
		HashMap<String, ArrayList<Employee>> all = new HashMap<String, ArrayList<Employee>>();
		all.put("����", emps); //�ѹ��� ��ȣ�� 10
		System.out.println("\n------- emp03�̶�� ������ �̸� ���");
		System.out.println(all.get("����").get(2).getEname());
		
		System.out.println("\n------- emp02 �̸� ������ ���");
		all.get("����").get(1).setEname("emp99");
		System.out.println(all.get("����").get(1).getEname());
	}

}

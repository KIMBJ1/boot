/* ArrayList�� ���� ������ �����͵� Ÿ��
 * - ��ü Ÿ�� ��� �� ���
 * - java.lang.Object ���� Ÿ�Ե� �� ���� ����
 * - java.util.ArrayList�� ����(��ü, Ŭ����) Ÿ��
 * - ArrayList�� ArrayList ���� ����
 * 
 *  ex)
 * -�μ����� ArrayList�� ����
 * 	: �μ��� 10����� 10���� ArrayLust
 * - ��� ������ ������ ArrayList�� ����
 * 	: �ϳ��� ArrayList�� 10���� �μ��� ArrayList ����
 */
package step01.test;

import java.util.ArrayList;

import model.domain.Employee;

public class ReviewTest {
	
	/* Employee ��ü 3���� ������ ArrayList�� ArrayList�� ����
	 * 
	 */
	static void m1() {
		//step07_API\model.domain\Employee.java ���
		ArrayList<Employee> emps = new ArrayList<Employee>();
		//ArrayList<Employee>�� �����Ҽ� �ִ� ArrayList
		ArrayList<ArrayList<Employee>> all = new ArrayList<ArrayList<Employee>>();
		
		emps.add(new Employee("11","emp01",10));
		emps.add(new Employee("22","emp02",22));
		emps.add(new Employee("33","emp03",33));
		
		all.add(emps); //0��° ������
		
		System.out.println("------- 1��° ����� ���� ���� ���");
		ArrayList<Employee> v1 = all.get(0);
		Employee v2 = v1.get(1); //empno, ename, deptno�� ������ ����
		System.out.println(v2);
		System.out.println(v1.get(1));
		System.out.println(emps.get(1));
		System.out.println();
		System.out.println("------- v2�� �μ���ȣ �����ص� ����");
		v2.setDeptno(200);
		System.out.println(all.get(0).get(1).getDeptno());
	}
	
	static void m2() {
		ArrayList<Employee> emps = new ArrayList<Employee>();
		ArrayList<ArrayList<Employee>> all = new ArrayList<ArrayList<Employee>>();
		
		emps.add(new Employee("11","emp01",10));
		emps.add(new Employee("22","emp02",22));
		emps.add(new Employee("33","emp03",33));
		
		all.add(emps);
		
		all.get(0).get(1).setDeptno(200);; //empno, ename, deptno�� ������ ����
		System.out.println("\n------- m1 �ڵ� ���̱�");
		System.out.println(all.get(0).get(1).getDeptno());
		/* System : class
		 * out : System���� static���� ����� ����
		 * println() :
		 * out.println() �� out ���� Ÿ���� PrintStream Ŭ�������� �����ϴ� �޼ҵ�
		 */
		System.out.println("\n------- emp03 -> asdff�� �ٲٱ�");
		System.out.println(all.get(0).get(2));
		System.out.println(all.get(0).get(2).getEname());
		all.get(0).get(2).setEname("asdff");
		System.out.println(all.get(0).get(2));
		System.out.println(all.get(0).get(2).getEname());
		
	}

	public static void main(String[] args) {
		m1();
		m2();

	}

}

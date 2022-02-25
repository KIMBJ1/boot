/* Employee CRUD ����
 * 
 * 1. ArrayList�� ��� ���� ����? / �� �޼ҵ庰 ���� ���� ����?
 * 	- 4���� �޼ҵ尡 �����ϴ� �ڿ�(data)
 * 	- ��� ���� : ��� �޼ҵ尡 ���� -----------------------------�̰ɷ� ��
 * 			  : �����ϴ� �ڿ��̱� ������ ��������� ��
 * 	- rdbms���� select�Ѵٰ� ����
 * 		- �����͸� �ʱ�ȭ�ϴ� ����
 * 			static{}
 * 	- ���� ���� : ����� �޼ҵ� �������� ���
 * 		***����� ������ ���� ������ {}�������� ����
 * 2. ��� �� �� �˻��� ���� ������
 * 3. ��� �� �� ���� ���� ������? � ������ ����  --- �̰Ŵ� �μ���ȣ
 * 4. ���� �� � ������ ��������?
 */
package step01.test;

import java.util.ArrayList;

import exception.idInvalidateException;
import model.domain.Employee;

public class ListTest2 {
	//private static�� ���� : private�� ��ü �����ؾ߸� ��� ������ ������ static{}���ο��� ȣ�� �Ұ�
	private static ArrayList<Employee> al = new ArrayList<>();
	
	//static{} : ��ü ���� ������ �����ϰ� ListTest2.class �ε��� �ڵ� ����
	//
	static {
		al.add(new Employee("1", "asdf", 11)); //0��° ����
		al.add(new Employee("2", "qwer", 22)); //1���� ����
	}
	
	//create() - Employee ��ü�� ArrayList ����
//	//��� 1
//	public static void create() {
//		al.add(new Employee("3","zxcv",33));
//	}
//	//���2
//	public static void create(String empno, String ename, int deptno) {
//		al.add(new Employee(empno, ename, deptno));
//	}
	//���3 ------------------------------------------------------- �̰ɷ� ��
	//��ü �����̶� �̷��Ŵ� ��ü�� ����� Ȱ���ϴ� �ڵ�
	/* ���� ������ ��� ����
	 * ����� �� 1 - ������ ���� id �� ���� ���� ����
	 * ����� �� 2 - �̹� �ִ� id(�ߺ�) : �����ڵ��� ������ exception Ŭ������ ���� ��Ȳ ó��
	 * 	idInvalidateException.java�� �����
	 */
	
	//�������� �������ϴ� ����� ��쿡�� add�Ҽ� �ְ� �ڵ� ����
	public static void create(Employee newEmp) throws idInvalidateException {
		for(Employee e:al) {
			if(e.getEmpno().equals(newEmp.getEmpno())) { //ArrayList�� �̹� ������ ���� �߻�
				throw new idInvalidateException("��� �ߺ�");
			}else { //ArrayList�� ������ ����
			}
		}
		//�� ������ ����Ǵ� ���� ArrayListdp wndqhrehls tkqjsdl djqtdmfEoaks tlfgod
		al.add(newEmp);
		}
	//read() - ��� �Ѹ��� ��� �˻�
	/* ����
	 * ArrayList�� ��� ��ü���� ����� �� (���ǽ�, ������ �������̴ϱ� �ݺ��� �ʿ�?)
	 * if �˻� ��û�� ��� ����
	 * 	Employee ��ü ��ȯ
	 * if �˻� ��û�� ��� ���� ����
	 * 	null ��ȯ
	 * 	
	 * String Ŭ������ boolean equals(Object anObject){String��ü�� ���ؼ� ��ȯ}
	 */
	public static Employee read(String empno){//���� ���� ���� : ���
		Employee emp = null; //���� �������� ����� �⺻������ �ʱ�ȭ ����
		/* e.getEmpno().equals(empno)
		 * e - Employee
		 * e.getEmpno() - String
		 * 		public String getEmpno(){}
		 * e.getEmpno().equals(...) - boolean
		 * 		public boolean equals (Object anObject){}
		 */
		for(Employee e:al) {
			if(e.getEmpno().equals(empno)) { //if(true) or if(false)
				return e;
			}
		}
		return null; //if ���� false�� ��쿩�� ��ȯ�� �ʼ��̴ϱ� �ʿ��� �ڵ�
		 
	}
	//update() - ��� �Ѹ��� �μ���ȣ ����
	/* �ʿ� ������ : ����� �����ϰ��� �ϴ� ���ŵ� �μ� ��ȣ
	 * if ���� �����ȣ
	 * if ���� �μ���ȣ
	 * 	if �����ȣ�� Ʋ��
	 * 	if �����ȣ�� �¾�
	 */
	public static boolean update(String empno, int newDept) {
		for(Employee e:al) {
			if(e.getEmpno().equals(empno)) { 
				//�����ȣ�� true��� �μ���ȣ ����
				e.setDeptno(newDept);
				return true;
			}
		}
		return false;
	}
	//delete() - �����ϴ� ��� �Ѹ� ����
	//remove() - ArrayList ���ο� �ش� ����� ��� ����
	public static boolean delete(String empno){
		for(Employee e:al) {
			if(e.getEmpno().equals(empno)) { 
				al.remove(e);		
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		System.out.println("-------0. ���� ����");
		System.out.println(al);
		System.out.println();
		System.out.println("-------1. ���ο� ���� �Ի�");
		System.out.println("�������ϴ� ��� ����");
		try {
			create(new Employee("0", "zxcv", 00));
			System.out.println("���� ����");
			//��� ��ȣ �ߺ� ����
			create(new Employee("0", "zxcv", 00));
		}catch(idInvalidateException e) {
			System.out.println(e.getMessage());
		}
		System.out.println(al);
		System.out.println();
		System.out.println("-------2. ��� ���� �˻�");
		System.out.println(al);
		System.out.println();
		System.out.println("-------3. ��� �� �� �˻� : empno������ null(null�� �����)");
		//null Ű����� ���� ���񽺽ÿ� end user(�����)���� ���� �Ұ�
		Employee e = read("3");
		if(e != null) {
			System.out.println(e);
		}else {
			System.out.println("�ش� ��� �� ����");
		}
		e = read("9");
		if(e != null) {
			System.out.println(e);
		}else {
			System.out.println("�ش� ��� �� ����");
		}
		
		System.out.println();
		System.out.println("-------4. ��� �� �� �μ���ȣ ����");
		update("1", 9);
		System.out.println(al);
		System.out.println();
		System.out.println("-------5. ��� ���� �� �˻�");
		delete("1");
		System.out.println(al);
		boolean result = delete("2");
		if(result) {
			System.out.println("���");
			System.out.println(al);
		}else {
			System.out.println("�ش� ��� �� ����");
		}
	}

}

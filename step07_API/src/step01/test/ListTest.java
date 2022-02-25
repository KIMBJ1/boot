/* list �ڷᱸ�� API
 * 1. Object[] �迭�� ���
 * 2. index�� ����
 * 3. �迭���� ������
 * 	- Ŭ������ ����� ����
 * 	- �����͵��� �޼ҵ�� Ȱ��
 * 	- �迭�� �ѹ� ������ ũ�Ⱑ ���� �Ұ�
 * 	- list�� �������� �ǽð� �޸� ũ�Ⱑ �ٲ�
 * 4. Ư¡ : ��ü Ÿ�Ե鸸 ���� ����
 * 	- ���� 3�̶�� ���ڰ��� �����ϰ� ���� �ܿ� �ذ�å
 * 		- �⺻������ ��üó�� ǥ�� �����ϰ� ���ִ� 8���� ���� Ŭ���� ����
 * 		- int : Integer(Ŭ����, ���� Ÿ��) / byte : Byte(Ŭ����, ���� Ÿ��) etc...
 * 		- wrapper class�� ����(8����)
 * 			- �⺻ Ÿ���� ��üó�� ��� �����ϰ� support���ִ� Ŭ����
 * 5. �ֿ� API
 * 	1. ���� / Ȱ��(��ȯ) / ����
 * 		- add(Object) / get(int) / remove(int
 * 	2. ����� ������ ���� Ȯ��
 * 		- size()
 * 6. �ٸ� ���������� list
 * 	- �ӵ�
 * 		- ������ ������ �޸� ���� / ������ ������ ������ ������ ������ re index
 * 		- ���� �ӵ� ���鿡���� �迭���� ������
 * 	- Ȥ�� �ټ��� �����͵��� �ǽð� ����, ���� �ÿ��� �迭���� ����
 * 	- �����ϴ� �����Ͱ� �迭 �߰��� ���ԵǾ� �ִٸ� ����
 * 	- �����ϴ� �����͵��� ������ �κп� ����Ǿ� �ִٸ� ����
 */

package step01.test;

import java.util.ArrayList;

import model.domain.CustomerDTO;

public class ListTest {

	//���� ���� : ��ü Ÿ���� ��� ������ ��� �� ����
	public static void m1() {
		System.out.println("-------m1");
		//������ ���� ������ �޸� ����
		ArrayList a1 = new ArrayList(); //10���� �޸� ������ ������ ��ü ����
		
		//�����͸� 2�� ���� - String, IntegerŸ�� ���� ���� ���� / �� Object Ÿ��
		//public boolean add(Object o){parameter �� ���Ե� �����͸� ArrayList�� ����)
		a1.add("���ڿ�0"); //0��°�� ����
		a1.add(new Integer(1)); //a1.add(3); ������ �� a1.add(new Integer(3)) �ڵ����� �̷��� �ٲ�
		a1.add("���ڿ�2");
		a1.add(3);
		//����� ������ ���� Ȯ�� - �޸� ���� Ȯ�� �ƴ�
		//�ܼ� Ȯ��
		System.out.println(a1); //a1.toString() ������ : ������ ��� �����Ͱ� �ϳ��� ���ڿ��� ��ȯ
		System.out.println(a1.size()); //������ ����

		//index 2��°�� ���ڿ�2 ���� �� size() ȣ��
		a1.remove(2);
		System.out.println(a1);
		System.out.println(a1.size());
	}
	
	//����(add) Ȱ��(get)
	/* public boolean add(Obect o){}
	 * public Object remove(int index){}
	 * public Object get(int index){�ش� index�� ����Ǿ� �ִ� ������ ��ȯ}
	 */
	public static void m2() {
		System.out.println();
		System.out.println();
		System.out.println("-------m2");
		//�ʱ� �����Ǵ� �޸� ���� + ����ġ �޸� ����
		ArrayList al = new ArrayList(5); //5���� �޸� ����
		al.add("1");
		al.add("2");
		al.add("3");
		System.out.println(al);
		System.out.println("a1 ����Ʈ ������ : " + al.size());
		al.add("4");
		al.add("5");
		System.out.println(al);
		System.out.println("a1 ����Ʈ ������ : " + al.size());
		//5�� �Ѿ�� �޸� �ʿ�� 6�� ������ �����ϸ鼭 �޸� 5���� ����
		al.add("6");
		System.out.println(al);
		System.out.println("a1 ����Ʈ ������ : " + al.size());
		al.add("7");
		al.add("8");
		System.out.println(al);
		System.out.println("a1 ����Ʈ ������ : " + al.size());
		System.out.println("���� a1 ����Ʈ : " + al);
		System.out.println(al.get(2)); //3
		al.remove(2); //�ش� index ���� �ϸ鼭 �ڿ� ����Ǿ� �ִ� �����͸� index ������
		System.out.println("index2 ���� a1 ����Ʈ : " + al);
		System.out.println(al.get(2)); //4
	}
	
	public static void m3() {
		System.out.println();
		System.out.println("-------m3");
		ArrayList al = new ArrayList(); //5���� �޸� ����
		al.add("1");
		al.add("2");
		al.add("3");
		
		System.out.println(al);
		String s = (String)al.get(1);
		System.out.println(s);
		System.out.println(s.charAt(0));
		System.out.println(al.size());

	}
	
	//Ÿ���� ������ �� �ִ� jdk1.5���� ���õ� ���׸� ����
	//���� ���߽ÿ��� �ڷᱸ�� API�� ������ �����ÿ� ��κ� ������ ������ ����
	public static void m4() {
		System.out.println();
		System.out.println("-------m4");
		//String�� ���� ������ ���� �迭 ���� ����
		//String[]�� ���� �� �޸� ũ�� ���� ����
		ArrayList<String> a1 = new ArrayList<String>(); //5���� �޸� ����
		a1.add("a");
		a1.add("s");
		a1.add("d");
		a1.add("f");
		System.out.println(a1);

		String s = a1.get(2);
		System.out.println(s.charAt(0));
		System.out.println(s);
		
	}
	
	//���� ��� ������ ������ ȭ�鿡 ��� ���� db�κ��� select -> CustomerDTO ��ü ���� -> ArrayList���� -> ��ȯ
	public static ArrayList<CustomerDTO> getCustomerDTOs(){
		
		ArrayList<CustomerDTO> all = new ArrayList<CustomerDTO>();
		
		all.add(new CustomerDTO("u1", 11)); //0��° ����
		all.add(new CustomerDTO("u2", 22));
		
		return all;
	}

	public static ArrayList nonGetCustomers(){
		
		ArrayList all = new ArrayList();//10�� �޸� ����
		
		all.add(new CustomerDTO("u1", 11));  //0��° ����
		all.add(new CustomerDTO("u2", 22));  //1��° ����
		
		return all;
	}
	public static void main(String[] args) {
		m1();
		m2();
		m3();
		m4();
		
		ArrayList<CustomerDTO> all = getCustomerDTOs();
		
		// u2�� ���
		/* all.get(1);
		 * all : ArrayList<CustomerDTO>
		 * all.get(1) : CustomerDTO (id, pw �� ���� �����͸� �����ϴ� ��ü
		 */
		System.out.println();
		System.out.println("-------CustomerDTO ���׸�");
		System.out.println(all.get(0));
		System.out.println(all.get(0).getId());
		
		System.out.println("-------CustomerDTO non ���׸�");
		ArrayList a = nonGetCustomers();
		System.out.println(((CustomerDTO)a.get(1)));
		System.out.println(((CustomerDTO)a.get(1)).getId());
	}

}

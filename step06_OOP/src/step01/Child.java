package step01;

public class Child extends Parent{
	String job;
	
	public Child() {
		super(); // ������ ù���ο� �ʼ� ������ �����Ϸ��� �ڵ� �߰�
				 //Object ��ü -> Parent ��ü ���� �Ϸ�
				 // name age �޸� ����
		System.out.println("child�� ���� ����");
	} //���� ����, job �޸� ����

	//printALL : �θ� �״�� �ޱ�
	void printAll() {
		super.printAll(); //�θ�(super) Ŭ������ �ش� �޼ҵ� ���� 100% �״�� �����ϴ� ���� ���� 
		//�θ�Ŭ������ �����ϸ� �ڽ�Ŭ���� ���� �Ϸ�
//		System.out.println(name); //����Ÿ���̴ϱ� name.toString()���� �����
//		System.out.println(age);
		//super.printAll(); ���� �� �� ���� �ʿ� ������
		System.out.println(job);
	}

	@Override //������ �ֳ����̼�
	public String toString() {
		return name + " " +  age + " " + job;
	}
	
	public static void main(String[] args) {
		/* ������ ��ü
		 * Object -> Parent -> Child
		 *  c��� ������ ChildŸ��
		 */
		Child c = new Child();
		System.out.println("toString������ �� : " + c); //null 0 null
													  //String toString() ���ϸ� : step01.Child@7de26db8
		
		c.name = "���̸�";
		c.age = 1995;
		c.job = "asdf";
		
		System.out.println("toString������ �� : " + c); //name age job�������� toString ���� -> ������
	}

}

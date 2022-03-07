package step02;

class Parent extends Object {
	String name;
	int age;

	Parent() {
		super();
	}

	void printAll() {
		System.out.println(name);
		System.out.println(age);
	}
}

public class Child extends Parent {
	String job;

	public Child() {
		super();
	}

	void printAll() {
		super.printAll();
//		System.out.println(job.toString());
		System.out.println(job);
	}

	public static void main(String[] args) {
		/* �������� �θ� Ŭ�������� ������
		 * p.��������� �޼ҵ� ���� ���� �� �ڽ� Ŭ�������� ����
		 * �� printAll() ���� ��������ε� �����ǵ� �ڽ� �޼ҵ� ȣ��
		 */
		Parent p = new Child(); //������, ��� ���� ���� ������ ����
		p.name = "���̸�";
		p.age = 1995;
		System.out.println("-------Parent�� �� ����");
		p.printAll();
		
		
		//�ڽĸ��� ��������� �θ�Ÿ�� ������ ȣ�� �õ�
//		p.job = "IT"; //������
		//�ذ�å : ����ȯ ���� - �θ�Ÿ���� �ڽ�Ÿ������ ��ȯ
		//����ȯ ���� : ����Ÿ�� ���� = (����Ÿ��)����Ÿ��;
		/* p�� ������ Child ��ü�� ���� �� �ּҰ�
		 * ���ο� c��� Child ������ p�� �����ϴ� ������ ��ü�� ����
		 * �� ���ԵǴ� ������ Parent Ÿ���� ��Ӱ����� ���� Ÿ������ ��ȯ�Ǿ� ����
		 * �ϳ��� ��ü�� p�� c�� ���ÿ� ����
		 */
		
		System.out.println("-------����ȯ X");
		p.printAll();
		Child c = (Child)p;
		c.job = "KING";
		System.out.println("-------����ȯ");
		c.printAll();
		System.out.println("-------����ȯ");
		p.printAll();
		
		c.name = "asdf";
		System.out.println("-------c�̸� ���� p���");
		System.out.println(p.name);
		p.name = "zxcv";
		System.out.println("-------p�̸� ���� c���");
		System.out.println(c.name);
		System.out.println("p, c �ּ� : " + p + " " +  c);
	}
}
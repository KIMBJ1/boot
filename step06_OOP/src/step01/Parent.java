package step01;

public class Parent extends Object{
	String name; //����Ÿ��
	int age; //�⺻Ÿ��
	
	public Parent() {
		super(); //�θ� Ŭ������ ����� �ڽ� Ŭ������ ��� �̸��� ���� ��� super Ű���带 ����Ͽ� ����
				 // Object ��ü���� �Ϸ�
		System.out.println("parent�� ���� ����");
	}
	
	void printAll() {
		System.out.println(name); //����Ÿ���̴ϱ� name.toString()���� �����
		System.out.println(age);
	}

}

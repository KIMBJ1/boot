package step06.array;

import step02.Person;

public class Array2 {

	// Person����� �迭 ���� �� ��ȯ
	public static Person[] getPersonArray() {
		Person p1 = Person.builder().name("���̸�").age(1995).build();
		Person p2 = Person.builder().name("���̹�").age(2001).build();
		
		Person[] i = {p1, p2};
		return i;
	}

	// Person����� ������ �迭 �޾Ƽ� ���
	// �ܼ� ������
	public static void printArray(Person[] v) {
		System.out.println("------- �ܼ� �밡�� ������");
		System.out.println(v[0]);
		System.out.println(v[1]);
	}
	// �ݺ��� �߰� �н�
	public static void printArrayFor1(Person[] v) {
		for(int i = 0; i <= 1; i++) {
			System.out.println(v[i]);
		}

	}
	//length : ������ �迭�� �ڵ� �߰��Ǵ� ����(�迭 ũ�Ⱚ ����)
	//alt shift r�� ���� �����ϸ� ���� ���� �� �ٲ�************************************
	public static void printArrayFor2(Person[] v) {
		for(int i = 0; i < v.length; i++) {
			System.out.println(v[i]);
		}

	}
	
	//�迭, List ��ü�鿡�� ���Ǵ� �ݺ���
	public static void printArrayForEach(Person[] v) {
		for(Person i : v) {
			System.out.println(i.getName());
		}

	}

	public static void printArrayWhile(Person[] v) {
		int i = 0;
		while(i < v.length) {
			System.out.println(v[i].getAge());
			i++;
		}

	}

	public static void main(String[] args) {
		Person[] v1 = getPersonArray();
		printArray(v1);
		System.out.println("------- for�� ������");
		printArrayFor1(v1);
		System.out.println("------- for�� length�� ������");
		printArrayFor2(v1);
		System.out.println("------- ForEach�� ������");
		printArrayForEach(v1);
		System.out.println("------- while�� ������");
		printArrayWhile(v1);

	}

}

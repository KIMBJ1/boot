package step02.builder;

import lombok.Builder;
import lombok.Data;

@Builder
@Data //@Getter @Setter @ToString ��� ��������
public class People {
	private String name;
	private int age;
		
	
	public static void main(String [] args) {
		
		// �ټ��� �����߿� name �������� �ʱ�ȭ �ϸ鼭 ��ü �����ϴ� ����
		// �ֳ����̼� @Builder
		// 0106_�н�����.txt\3. ����\����� �� 3
		/*
		 * People.builder() : PeopleBuilder ��ü ��ȯ
		 * PeopleBuilder : People ��ü �������ִ� ��ü
		 * 	- ���� ���õ� �޼ҵ�� �ڵ� �����ؼ� ����
		 * 	- �����ؼ� ������ �ʱ�ȭ(�� ����) ������ ���
		 * 
		 * name("KBJ") : name ������ ���������� �� ���ԵǴ� �޼ҵ�
		 * build() : ���� �ش� ��ü �������ִ� �޼ҵ�
		 */
		People p = People.builder().name("KBJ").build();
		System.out.println(p.name + " " +p.age);//KBJ 0(age�� �� �������� �ʾƼ� �⺻��)
		System.out.println(p);//People(name=KBJ, age=0)
		
	}
}
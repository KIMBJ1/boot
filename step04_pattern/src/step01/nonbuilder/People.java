package step01.nonbuilder;



import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class People {
	private String name;
	private int age;
	
	//parameter�� ���� �⺻ ������
	//�����ڰ� ���� ��� �����Ϸ��� �������ִ� ������
	public People() {}

	//������ - ��ü �����ÿ� ����ڰ� �����ϰ��� �ϴ� ������ ��ü ����
	public People(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	//��ӽÿ� �߰� �н�
	/* java�� ��� Ŭ������ �ֻ��� root ���� = java.lang.Object
	 * - ������ �޼ҵ�� ��� Ŭ������ ��ӹ޾� �����ϰ� �ִ� ��Ȳ
	 * - toString() �޼ҵ常 ���
	 * 		-Object�� toString() ���: ������ ��ü���@��ġ���� ���ڿ��� ��ȯ
	 * - ��, �ڽ� Ŭ���� �������� �޼ҵ� ��� ���� ���� : �޼ҵ� ������
	 * - �޼ҵ� ������(overriding, override)
	 * 		�޼ҵ� ���(body) ����
	 */
	public String toString() {
		return name + " - " + age; //�ϳ��� String���� ���յǾ� ��ȯ
		//�̰� ������ step01.People@2db0f6b2 �ּҰ�
		//�̰� ������ KBJ - 1995
	}
	
	//���� ������ ��½ÿ� toString() �ڵ� ȣ�� �� toString() ��ȯ���� ���
	public static void main(String [] args) {
		//parameter�� �ִ� ������ ȣ���ؼ� KBJ, 1995 ����
		/* People a1 = new People();
		 * a1.setName("asd");
		 * a1.setAge(1995
		 */
						
		People a1 = new People();
		a1.setName("asd");
		a1.setAge(1997);
		//�̰� �� ����
		People a2 = new People("KBJ", 1995);

		System.out.println(a1); //step01.People@2db0f6b2
		System.out.println(a2); //�ּ� step01.People@3cd1f1c8 / ���ϴ� �� KBJ - 1995
	}
	
}

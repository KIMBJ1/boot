package step02;

public class People {
	//���� - ���� ��� �����ϰ� �޸𸮿� �����Ǵ� ���� : ��ü ���� ��
	//��ü ��ü�� �����ϴ� ���� ��� ����
	String name; //����
	int age; //����
	
	//�����Ϸ��� �ڵ����� ������ֱ�� ������ �����ڰ� �߿��� Ŭ������ Ÿ������ �Ѵ�
	//������(�Ķ����){����}
	People(){}
	
	//�޼ҵ� - ����ϴ� �������� ����
	//������ ���� �Ǵ� �����ϴ� �޼ҵ�
	String getName() {
		return name; //ȣ��
	}
	void setName(String newName) { //���� ���� : newName newAge args p1 4�� //����
		name = newName; //ȣ��&nd���� �������ȣ�� = ���ú���ȣ��
	}
	int getAge() {
		return age; //ȣ��
	}
	void setAge(int newAge) { //����
		age = newAge; //ȣ�� ����
	}
	
	public static void main(String[] args) { //����
		//��ü ���� - name, age �޸� ���� �ϸ鼭 People �������� ����
		// �� �ּҰ����� ������ Ȱ��, �� �ּҰ��� �ƴ� p1 ���� ������ �ڵ� �󿡼� ���
		People p1 = new People(); //����
		System.out.println(p1.name); //ȣ��
		
		//���� ȣ��� �� ���� �� Ȯ��
		p1.name = "���̸�";
		System.out.println(p1.name);
		
		//�޼ҵ� ȣ��� �� ���� �� Ȯ��
		p1.setName("���̹�");
		System.out.println(p1.name);
		
		p1.setAge(25);
		System.out.println(p1.age);

	}

}

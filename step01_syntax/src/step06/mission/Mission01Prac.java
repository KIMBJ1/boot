package step06.mission;

public class Mission01Prac {

	public static void main(String[] args) {
		
		// �� �μ���
		Mission01Cannon c = new Mission01Cannon(); 	// ���� ��ü �ϳ� ����
		Mission01Aid a = new Mission01Aid();			// ���� ��ü �ϳ� ����
		
		//�� �μ��� 4�� �� �� 1��
		c.attCastle();
		c.attCastle();
		c.attCastle();
		a.healCastle();
		
		System.out.println(Mission01Castle.hp);
		
	}

}

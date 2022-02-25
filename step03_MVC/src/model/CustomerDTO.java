package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor //�Ķ���Ͱ� ���� �����ڸ� ����
@AllArgsConstructor
@Getter
@Setter
@ToString
public class CustomerDTO {
	//private �ܺο� ����
	private String id;
	private int pw;
	private char grade; // gold(g) silver(s) �� ������ �ִٰ� ����
	private String job;
	
	//grade���� ��ȿ�� ���� ���� ������ ���ǽ� ���� (��ȿ�� ����)
	//��ȿ�� �����͸� ���� �����ϰ� �ϴ� rule - ���� Ÿ�Ը� �´ٰ� �ؼ� ���� ������ ��Ȳ �������Ѿ� ��
	//������ �ܺο��� ȣ�� �Ұ����ϰ� ���� ��ȿ�� �ڵ�� ���� �Ŀ� ����
	//���� ���� : ������ �ܺο��� ����(private)
	//  ��ȿ�� �ڵ�� ���� �޼ҵ�� ���� ���� ���(public)
	public void setGrade(char grade) {
		//'�� char "�� ���ڿ�
		if(grade == 'g' || grade == 's') {
			this.grade = grade;
		}else {
			System.out.println("��� ����");
		}
	}
}

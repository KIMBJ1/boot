package model;

public class Model {
	//controller�� ��û���� �Ѹ��� ������ db�κ��� �˻��ؼ� CustomerDTO ������ ����
	public static CustomerDTO getCustomer() {
		//��ü ����
		//setXxx()�޼ҵ�� id = encore, pw = 12, grade = gold
		//��ȯ
		
		CustomerDTO c = new CustomerDTO();
		c.setId("encore");
		c.setPw(12);
		c.setGrade('g');
		
		return c;
	}
	
	//������ ��� ��ȯ
	
	public static CustomerDTO[] getCustomers() {
		CustomerDTO[] c = {new CustomerDTO("id1",11,'g', "����"),
						new CustomerDTO("id2",22,'s', "��ȹ")};
		
		return c;
	}
	
	//..CRUD
}

package view;

import model.CustomerDTO;

public class EndView {

	public static void print(CustomerDTO c) {
		System.out.println(c.getId() + " &nd " + c.getGrade());
	}

	//��� �� ���� ���
	//forEach ��� / println() ���������� ��½� toSstring() �ڵ� ȣ��
	public static void printAll(CustomerDTO[] all) {
		for(CustomerDTO v : all) {
			System.out.println(v);//v.toString()
		}
	}

	public static void printMsg(String msg) {
		System.out.println(msg);
	}
}

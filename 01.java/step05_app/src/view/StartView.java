
package view;

import controller.Controller;

public class StartView {

	public static void main(String[] args) {
		// reqRes�� 1�� ��û�� ��� �л� ���� ���
		System.out.println("******�л� ����");
		Controller.reqRes(1);

		// reqRes�� 2�� ��û�� ��� ���б� ��� ���� ���
		System.out.println("******���б� ����");
		Controller.reqRes(2);

	}

}

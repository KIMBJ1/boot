package view;

import controller.Controller;

public class StartView {

	/*client�� 1�� ��û�� �� �Ѹ� ���� ��û
	 *client�� 2�� ��û�� ��� �� ���� ��û
	 */
	public static void main(String[] args) {
		System.out.println("******�� �� �� ���� ��û");
		Controller.reqRes(1);

		System.out.println("******��� �� ���� ��û");
		Controller.reqRes(2);
		
		System.out.println("******�߸��� ���� ��û");
		Controller.reqRes(99);
		
	}

}

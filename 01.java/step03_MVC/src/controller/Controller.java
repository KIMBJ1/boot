package controller;

import model.CustomerDTO;
import model.Model;
import view.EndView;

public class Controller {
	
	//1 ��û : �� �� �� ���� ����
	//2 ��û : ��� �� ���� ����
	/*���� : 1�ΰ�?2�ΰ�? 1�̳� 2�� �ƴѰ�?
	 * ���� �� ������(����񱳿�����) ==
	 */
	public static void reqRes(int flag) {
		if(flag == 1) {
			EndView.print(Model.getCustomer());
		}else if(flag == 2) {
			/*EndView.printAll(Model.getCustomers()); ���� ����
			 * Model.getCustomers)
			 * -> EndView.printAll()
			 * 	->;
			 */	
			 	
			EndView.printAll(Model.getCustomers());
		}else {
			EndView.printMsg("��û ����. ��û�� 1 �Ǵ� 2�� ����");
		}
	}
}

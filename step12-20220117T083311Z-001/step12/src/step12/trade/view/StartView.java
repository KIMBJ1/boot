package step12.trade.view;

import step12.trade.controller.TradeController;
import step12.trade.dto.Item;
import step12.trade.dto.User;

public class StartView {

	public static void main(String[] args) {

		User u1 = new User("Ȳ����",11);
		User u2 = new User("������",22);
		User u3 = new User("�躴��",33);
		User u4 = new User("������",44);
		
		Item item1 = new Item("�º�", 600000, u1);
		Item item2 = new Item("����", 20000, u2);
		Item item3 = new Item("����", 25000, u3);
		Item item4 = new Item("���", 130000, u4);

		TradeController controller = TradeController.getInstance();
		
		System.out.println("*** 01. Item ��� ***");
		controller.newItemInsert(item1);
		controller.newItemInsert(item2);
		controller.newItemInsert(item3);
		controller.newItemInsert(item4);
		
		controller.getItemList();
		System.out.println("--- '����' �˻� ---");
		controller.getItem("����");
		
		System.out.println("update");
		controller.itemTradeUpdate("����", "�躴��", 33, 30000);
	}

}

package step12.trade.view;

import step12.trade.controller.TradeController;
import step12.trade.dto.Item;
import step12.trade.dto.User;

public class StartView {

	public static void main(String[] args) {

		User u1 = new User("Ȳ����");
		User u2 = new User("������");
		User u3 = new User("�躴��");
		User u4 = new User("������");

		Item item1 = new Item("�º�", 600000, "Ȳ����");
		Item item2 = new Item("����", 20000, "������");
		Item item3 = new Item("����", 25000, "�躴��");
		Item item4 = new Item("���", 130000, "������");

		TradeController controller = TradeController.getInstance();
	}

}

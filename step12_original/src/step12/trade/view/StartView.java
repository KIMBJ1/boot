package step12.trade.view;

import step12.trade.controller.TradeController;
import step12.trade.dto.Item;
import step12.trade.dto.User;

public class StartView {

	public static void main(String[] args) {

		User u1 = new User("황세원");
		User u2 = new User("정지현");
		User u3 = new User("김병조");
		User u4 = new User("김진주");

		Item item1 = new Item("태블릿", 600000, "황세원");
		Item item2 = new Item("가방", 20000, "김진주");
		Item item3 = new Item("의자", 25000, "김병조");
		Item item4 = new Item("향수", 130000, "정지현");

		TradeController controller = TradeController.getInstance();
	}

}

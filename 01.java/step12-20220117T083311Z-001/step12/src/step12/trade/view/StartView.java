package step12.trade.view;

import step12.trade.controller.TradeController;
import step12.trade.dto.Item;
import step12.trade.dto.User;

public class StartView {

	public static void main(String[] args) {

		User u1 = new User("황세원",11);
		User u2 = new User("정지현",22);
		User u3 = new User("김병조",33);
		User u4 = new User("김진주",44);
		
		Item item1 = new Item("태블릿", 600000, u1);
		Item item2 = new Item("가방", 20000, u2);
		Item item3 = new Item("의자", 25000, u3);
		Item item4 = new Item("향수", 130000, u4);

		TradeController controller = TradeController.getInstance();
		
		System.out.println("*** 01. Item 등록 ***");
		controller.newItemInsert(item1);
		controller.newItemInsert(item2);
		controller.newItemInsert(item3);
		controller.newItemInsert(item4);
		
		controller.getItemList();
		System.out.println("--- '가방' 검색 ---");
		controller.getItem("가방");
		
		System.out.println("update");
		controller.itemTradeUpdate("의자", "김병조", 33, 30000);
	}

}

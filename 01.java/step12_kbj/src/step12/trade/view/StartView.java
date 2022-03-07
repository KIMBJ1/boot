package step12.trade.view;

import step12.trade.controller.ItemTradeController;
import step12.trade.model.dto.Buyer;
import step12.trade.model.dto.Seller;
import step12.trade.model.dto.Trade;

public class StartView {
	public static void main(String[] args) {
		// 판매자
		Seller s1 = new Seller("s1", "item1");
		Seller s2 = new Seller("s2", "item2");
		Seller s3 = new Seller("s3", "item3");
		Seller s4 = new Seller("s4", "item4");
		
		//구매자
		Buyer b1 = new Buyer("b1", "item1");
		Buyer b2 = new Buyer("b2", "item2");
		Buyer b3 = new Buyer("b3", "item3");
		Buyer b4 = new Buyer("b4", "item4");
		
		//물건
		Item i1 = new Item();
		Item i2 = new Item();
		Item i3 = new Item();
		Item i4 = new Item();
		
		//거래
		Trade t1 = new Trade(s1, b1, i1);
		Trade t2 = new Trade(s2, b2, i2);
		Trade t3 = new Trade(s3, b3, i3);
		Trade t4 = new Trade(s4, b4, i4);
		
		System.out.println("update");
		ItemTradeController.tradeItemUpdate("item1","s1");
	}
}

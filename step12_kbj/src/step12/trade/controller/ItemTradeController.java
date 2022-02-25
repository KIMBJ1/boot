package step12.trade.controller;

import step12.trade.service.ItemTradeService;

public class ItemTradeController {
	
	private static ItemTradeController instance = new ItemTradeController();
	
	private ItemTradeService service = ItemTradeService.getInstance();
	
	private ItemTradeController(){}
	
	public static ItemTradeController getInstance() {
		return instance;
	}

	public static void tradeItemUpdate(String string, String string2) {
		// TODO Auto-generated method stub
		
	}

}

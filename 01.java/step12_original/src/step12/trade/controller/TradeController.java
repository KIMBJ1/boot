package step12.trade.controller;

import step12.trade.service.TradeService;

public class TradeController {
	private static TradeController instance = new TradeController();
	
	private TradeService service = TradeService.getInstance();
	
	private TradeController() {}
	
	public static TradeController getInstance() {
		return instance;
	}
}

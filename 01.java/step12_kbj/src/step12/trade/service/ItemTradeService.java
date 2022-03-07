package step12.trade.service;

public class ItemTradeService {
	private static ItemTradeService instance = new ItemTradeService();
	private ItemTradeService() {}
	public static ItemTradeService getInstance() {
		return instance;
	}
	
	

}

package step12.trade.service;

import java.util.ArrayList;

import step12.trade.dto.Item;

public class TradeService {
	
	private static TradeService instance = new TradeService();
	
	private ArrayList<Item> itemList = new ArrayList<Item>();
	
	private TradeService() {}

	public static TradeService getInstance() {
		return instance;
	}
}
